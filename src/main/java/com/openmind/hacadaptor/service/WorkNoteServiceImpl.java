package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.model.*;
import com.openmind.hacadaptor.socket.hacoperation.SessionOperation;
import com.openmind.hacadaptor.socket.hacoperation.WorkNoteOperation;
import com.openmind.hacadaptor.socket.xml.model.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.model.devices.SPort;
import com.openmind.hacadaptor.socket.xml.model.worknote.SWorkNote;
import com.openmind.hacadaptor.sqlutil.IdWorker;
import com.openmind.hacadaptor.util.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/7/10
 */
@Service
public class WorkNoteServiceImpl extends BaseServiceImp<WorkNote, Identity> implements IWorkNoteService {
    Logger logger = Logger.getLogger(WorkNoteServiceImpl.class);

    @Autowired
    private LogServiceImpl logService;

    @Autowired
    private PortServiceImpl portService;
    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private UserMappingServiceImpl userMappingService;


    private Result checkPortAccount(List<? extends IBasePort> ports, String groupName) {
        Result result = new Result();
        if (ports.size() == 0) {
            result.setErrorCode(1);
            result.setSuccess(false);
            result.setErrorMessage("port为空，请检查对应的系统[" + groupName + "]设备资源是否齐全");
            return result;
        } else {
            for (IBasePort port : ports) {
                if (port.getAccountId() == null || port.getAccountId().size() == 0) {
                    result.setErrorMessage("[portId]:"
                            + port.getPortId() + " 对应的account为空，请检查对应的系统["
                            + groupName + "]设备资源是否齐全");
                    result.setErrorCode(1);
                    result.setSuccess(false);
                }
            }
        }
        return result;
    }

//    private Result checkPortAccount(List<SPort> sPorts, String groupName) {
//        Result result = new Result();
//        if (sPorts.size() == 0) {
//            result.setErrorCode(1);
//            result.setSuccess(false);
//            result.setErrorMessage("port为空，请检查对应的系统[" + groupName + "]设备资源是否齐全");
//            return result;
//        } else {
//            for (SPort sPort : sPorts) {
//                if (sPort.getAccountId() == null || sPort.getAccountId().size() == 0) {
//                    result.setErrorMessage("[portId]:"
//                            + sPort.getPortId() + " 对应的account为空，请检查对应的系统["
//                            + groupName + "]设备资源是否齐全");
//                    result.setErrorCode(1);
//                    result.setSuccess(false);
//                }
//            }
//        }
//        return result;
//    }

    /**
     * 提交紧急变更 通过传入的具体的prot account来提单子
     *
     * @param workNote
     * @param sPorts
     * @return
     */
    @Override
    public Result submitEmergentWorkNote(WorkNote workNote, List<SPort> sPorts, List<String> groupNames) throws Throwable {
        logger.info("##紧急变更数据准备##：");
        Result result;

        StringBuilder sb = new StringBuilder();
        for (String name : groupNames) {
            sb.append(name).append("|");
        }
        result = checkPortAccount(sPorts, sb.toString());
        if (!result.isSuccess())
            return result;
        return submitWorkNote(workNote, sPorts, sb.toString(), "紧急");
    }


    /**
     * 常规变更  通过groupName获得所有的port  account
     *
     * @param workNote
     * @param groupNames
     * @return
     */
    @Override
    public Result submitNormalWorkNote(WorkNote workNote, List<String> groupNames) throws Throwable {
        logger.info("##常规变更数据准备##：");
        Result result;
        List<Port> ports;
        List<SPort> sPorts = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String name : groupNames) {
            ports = portService.getPortsAccountsByGroupName(name);

            for (Port port : ports) {
                SPort sport = new SPort();
                BeanUtils.copyProperties(port, sport);
                sPorts.add(sport);
            }
            result = checkPortAccount(sPorts, name);
            if (!result.isSuccess())
                return result;
            sb.append(name).append("|");
        }

        return submitWorkNote(workNote, sPorts, sb.toString(), "常规");
    }


    private Result submitWorkNote(WorkNote workNote, List<SPort> sPorts, String groupName, String type) throws Throwable {
        Result result;
        //TODO 这个要根据 工号和HAC中的操作员号码的映射关系获得了
        String[] ops = workNote.getOperator().split(",");
        int opsCount = ops.length;
        List<String> operator = new ArrayList<>();
        for (String op : ops) {
            String s = userMappingService.getOperatorById(op);
            if (s != null || !s.equals("")) {
                operator.add(s);
            }
        }
        if (operator.size() != opsCount) {
            result = Result.getFailureResult("传入的Operator执行人数量[" + opsCount + "]和映射表中所查询的数量[" + operator.size() + "]不一致");
            return result;
        }
        String workNoteNumber = workNote.getWorkNoteNumber();
        String startTime = workNote.getStartTime();
        String endTime = workNote.getEndTime();
        String reason = workNote.getReason();
        logger.info("准备提交【" + type + "】变更工单: " + workNoteNumber + " 内容:" + reason);
        //HAC的原因，传中文会导致无返回值。 及时用GB2312编码后传也一样。 Fuck HAC
        WorkNoteOperation workNoteOperator =
                new WorkNoteOperation(operator, workNoteNumber, startTime, endTime, "", sPorts);
        //获取返回结果
        XMLDTO xmldto = workNoteOperator.getXmldtoBack();
        result = Result.getResult(xmldto);
//        System.out.println(xmldto.getErrorCode());
        if (xmldto.getErrorCode() == 0) {
            List<SWorkNote> list = (List<SWorkNote>) xmldto.getResult().getBackContext().getContextDetail();
            for (int i = 0; i < xmldto.getResultCount(); i++) {
                SWorkNote sWorkNote = list.get(i);
                Log log = new Log(IdWorker.getId());
                log.setGroupName(groupName);
                log.setWorkNoteNumber(workNoteNumber);
                log.setWorkNoteId(sWorkNote.getWorkNoteId());
                log.setStartTime(startTime);
                log.setEndTime(endTime);
                log.setContent(reason);
                log.setOptDate(DateUtil.getYYYMMDD());
                log.setStatus("open");
                log.setWorkNoteType(type);
                log.setRemark(workNote.getOperator());
                try {
                    logService.insert(log);
                }
                //捕捉以事务后不会回滚
                catch (RuntimeException e) {
                    result.setMessage("提交工单成功，但是log表写入失败: [workNoteNumber]" + workNoteNumber + "[cause]" + e.getMessage());
                    logger.error("提交工单成功，但是log表写入失败: [workNoteNumber]" + workNoteNumber);
                    logger.equals(e.getMessage());
                }

            }
        }
        logger.info(result.toJsonString());
        return result;
    }

    /**
     * First check closeable,then do the operation.
     *
     * @param workNoteNumber
     * @return
     */
    @Override
    public Result setWorkNote(String workNoteNumber) throws Throwable {
        logger.info("开始关闭工单:" + workNoteNumber);
        Result result;
        SessionOperation sessionOperator = new SessionOperation(workNoteNumber);
        boolean closeable = sessionOperator.closeable();
        logger.info("工单是否可关闭：" + closeable);
        if (!closeable) {
            result = new Result();
            result.setErrorCode(1);
            result.setSuccess(false);
            result.setErrorMessage("无法关闭工单:" + workNoteNumber + "原因:" + sessionOperator.getCause());
            logger.info("无法关闭工单:" + workNoteNumber + "原因:" + sessionOperator.getCause());
        } else {
            WorkNoteOperation workNoteOperator = new WorkNoteOperation(workNoteNumber);
            XMLDTO xmldto = workNoteOperator.getXmldtoBack();
            result = Result.getResult(xmldto);
            if (xmldto.getErrorCode() == 0)
                if (logService.setWorkNoteStatusClosed(workNoteNumber, DateUtil.getYYYMMDD()) == 0)
                    result.setMessage("[workNoteNumber]" + workNoteNumber + "HAC关闭成功，但LOG表工单状态未更新。"
                            + "可能原因为提交工单时LOG写入失败导致LOG表中无改工单记录");

        }
        return result;
    }

    /**
     * If errorCode = 0 ,it means closeable.
     *
     * @param workNoteNumber
     * @return
     */
    @Override
    public Result closeable(String workNoteNumber) throws Throwable {
        logger.info("查询工单是否可关闭:" + workNoteNumber);
        Result result = new Result();
        SessionOperation sessionOperator = new SessionOperation(workNoteNumber);
        boolean closeable = sessionOperator.closeable();
        if (!closeable) {
            result.setErrorCode(1);
            result.setSuccess(false);
            result.setErrorMessage("无法关闭工单:" + workNoteNumber + "原因:" + sessionOperator.getCause());
            logger.info("无法关闭工单:" + workNoteNumber + "原因:" + sessionOperator.getCause());
        }
        return result;
    }

}
