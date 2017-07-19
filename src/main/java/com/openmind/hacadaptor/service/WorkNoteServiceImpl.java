package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.dao.AccountMapper;
import com.openmind.hacadaptor.dao.LogMapper;
import com.openmind.hacadaptor.dao.PortMapper;
import com.openmind.hacadaptor.mode.*;
import com.openmind.hacadaptor.socket.hacoperation.SessionOperator;
import com.openmind.hacadaptor.socket.hacoperation.WorkNoteOperator;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.mode.devices.SPort;
import com.openmind.hacadaptor.socket.xml.mode.worknote.SWorkNote;
import com.openmind.hacadaptor.sqlutil.IdWorker;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/7/10
 */
@Service
public class WorkNoteServiceImpl extends BaseServiceImp<WorkNote, Identity> implements IWorkNoteService {
    Logger logger = Logger.getLogger(WorkNoteServiceImpl.class);

    @Autowired
    LogMapper logMapper;
    @Autowired
    PortMapper portMapper;
    @Autowired
    AccountMapper accountMapper;

    private List<SPort> getSPorts(String deviceId) {
        Port p = new Port();
        p.setDeviceId(deviceId);
        List<Port> list = portMapper.fuzzySelect(p);
        List<SPort> sPorts = new ArrayList<>();
        for (Port port : list) {
            SPort sPort = new SPort();
            BeanUtils.copyProperties(port, sPort);
            sPorts.add(sPort);
        }
        return sPorts;
    }

    private List<String> getAccountIds(String deviceId) {
        Account a = new Account();
        a.setDeviceId(deviceId);
        List<Account> list = accountMapper.fuzzySelect(a);
        List<String> accountIds = new ArrayList<>();
        for (Account account : list) {
            accountIds.add(account.getAccountId());
        }
        return accountIds;
    }

    private Result checkPortAccount(List<Port> ports, List<Account> accounts, String groupName) {
        Result result = new Result();
        boolean checkAccount = true, checkPort = true;
        if (ports.size() == 0)
            checkPort = false;
        if (accounts.size() == 0)
            checkAccount = false;
        if (!checkAccount || !checkPort) {
            result.setErrorCode(1);
            result.setSuccess(false);
            if (!checkAccount && !checkPort)
                result.setErrorMessage("account、port都为空，请检查对应的系统[" + groupName + "]面设备资源是否齐全");
            else if (!checkPort)
                result.setErrorMessage("port为空，请检查对应的系统[" + groupName + "]面设备资源是否齐全");
            else
                result.setErrorMessage("account为空，请检查对应的系统[" + groupName + "]面设备资源是否齐全");
        }
        return result;
    }

    /**
     * 提交紧急变更 通过传入的具体的prot account来提单子
     *
     * @param workNote
     * @param ports
     * @param accounts
     * @return
     */
    @Override
    public Result submitEmergentWorkNote(WorkNote workNote, List<Port> ports, List<Account> accounts, List<String> groupNames) {
        logger.info("##紧急变更数据准备##：");
        Result result;

        StringBuilder sb = new StringBuilder();
        for (String name : groupNames) {
            sb.append(name).append("|");
        }
        result = checkPortAccount(ports, accounts, sb.toString());
        if (!result.isSuccess())
            return result;
        return submitWorkNote(workNote, ports, accounts, sb.toString(),"紧急");
    }


    /**
     * 常规变更  通过groupName获得所有的port  account
     *
     * @param workNote
     * @param groupNames
     * @return
     */
    @Override
    public Result submitNormalWorkNote(WorkNote workNote, List<String> groupNames) {
        logger.info("##常规变更数据准备##：");
        Result result;
        List<Port> ports = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String name : groupNames) {
            ports.addAll(portMapper.getPortsByGroupName(name));
            accounts.addAll(accountMapper.getAccountsByGroupName(name));
            result = checkPortAccount(ports, accounts, name);
            if (!result.isSuccess())
                return result;
            sb.append(name).append("|");
        }
        return submitWorkNote(workNote, ports, accounts, sb.toString(),"常规");
    }


    private Result submitWorkNote(WorkNote workNote, List<Port> ports, List<Account> accounts, String groupName,String type) {
        Result result;
        String operator = workNote.getOperator();
        String workNoteNumber = workNote.getWorkNoteNumber();
        String startTime = workNote.getStartTime();
        String endTime = workNote.getEndTime();
        String reason = workNote.getReason();
        List<String> accountId = new ArrayList<>();
        List<SPort> sports = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        boolean checkAccount = true, checkPort = true;
//        if (ports.size() == 0)
//            checkPort = false;
//        if (accounts.size() == 0)
//            checkAccount = false;
//        if (checkAccount && checkPort) {
        //TODO 逻辑有问题
        for (Account account : accounts) {
            accountId.add(account.getAccountId());
        }
        for (Port p : ports) {
            SPort sPort = new SPort();
            BeanUtils.copyProperties(p, sPort);
            sPort.setAccountId(accountId);
            sports.add(sPort);
        }

        logger.info("准备提交工单: " + workNoteNumber + " 内容:" + reason);
        WorkNoteOperator workNoteOperator =
                new WorkNoteOperator(operator, workNoteNumber, startTime, endTime, reason, sports);
        //获取返回结果
        XMLDTO xmldto = workNoteOperator.getXmldtoBack();
        result = Result.getResult(xmldto);
        if (xmldto.getErrorCode() == 0) {
            List<SWorkNote> list = (List<SWorkNote>) xmldto.getResult().getBackContext().getContextDetail();
            for (int i = 0; i < xmldto.getResultCount(); i++) {
                SWorkNote sWorkNote = list.get(i);
                WorkNote w = new WorkNote();
                w.setWorkNoteNumber(sWorkNote.getWorkNoteNumber());
                w.setWorkId(sWorkNote.getWorkNoteId());
                //更新返回的WORKID到workNote表
                //TODO 需要修改update的代码，因为没有ID，需要一个update 方法带有 condition参数 ??
//                baseMapper.update(w);
                Log log = new Log(IdWorker.getId());
                log.setGroupName(groupName);
                log.setWorkNoteNumber(workNoteNumber);
                log.setWorkNoteId(sWorkNote.getWorkNoteId());
                log.setStartTime(startTime);
                log.setEndTime(endTime);
                log.setContent(reason);
                log.setOptDate(sdf.format(new Date()));
                log.setStatus("open");
                log.setWorknotetype(type);
                try {
                    logMapper.insert(log);
                }
                //捕捉以事务后不会回滚
                catch (RuntimeException e) {
                    result.setMessage("提交工单成功，但是log表写入失败: [workNoteNumber]" + workNoteNumber + "[cause]" + e.getMessage());
                    logger.error("提交工单成功，但是log表写入失败: [workNoteNumber]" + workNoteNumber);
                    logger.equals(e.getMessage());
                }
            }
        }
//        }
//        else {
//            result = new Result();
//            result.setSuccess(false);
//            result.setErrorCode(1);
//            if (!checkAccount && !checkPort)
//                result.setErrorMessage("account、port都为空，请检查对应的系统[" + groupName + "]面设备资源是否齐全");
//            else if (!checkPort)
//                result.setErrorMessage("port为空，请检查对应的系统[" + groupName + "]面设备资源是否齐全");
//            else
//                result.setErrorMessage("account为空，请检查对应的系统[" + groupName + "]面设备资源是否齐全");
//        }
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
    public Result setWorkNote(String workNoteNumber) {
        logger.info("开始关闭工单:" + workNoteNumber);
        Result result;
        SessionOperator sessionOperator = new SessionOperator(workNoteNumber);
        boolean closeable = sessionOperator.closeable();
        logger.info("工单是否可关闭：" + closeable);
        if (!closeable) {
            result = new Result();
            result.setErrorCode(1);
            result.setErrorMessage("无法关闭工单:" + workNoteNumber);
            logger.info("无法关闭工单:" + workNoteNumber);
        } else {
            WorkNoteOperator workNoteOperator = new WorkNoteOperator(workNoteNumber);
            XMLDTO xmldto = workNoteOperator.getXmldtoBack();
            if (xmldto.getErrorCode() == 0)
                //TODO 设置log表中对应工单的status为close 到时候重构代码 用service层调用logService.updateStatus()...
                ;
            result = Result.getResult(xmldto);
        }
        return result;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public LogMapper getLogMapper() {
        return logMapper;
    }

    public void setLogMapper(LogMapper logMapper) {
        this.logMapper = logMapper;
    }
}
