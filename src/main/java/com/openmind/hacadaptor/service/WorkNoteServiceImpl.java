package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.dao.AccountMapper;
import com.openmind.hacadaptor.dao.LogMapper;
import com.openmind.hacadaptor.dao.PortMapper;
import com.openmind.hacadaptor.mode.*;
import com.openmind.hacadaptor.socket.hacoperation.WorkNoteOperator;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.mode.devices.SAccount;
import com.openmind.hacadaptor.socket.xml.mode.devices.SPort;
import com.openmind.hacadaptor.socket.xml.mode.worknote.SWorkNote;
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

    /**
     * 提交紧急变更
     *
     * @param workNote
     * @param ports
     * @param accounts
     * @return
     */
    @Override
    public Result submitEmergentWorkNote(WorkNote workNote, List<Port> ports, List<Account> accounts) {
        Result result;
        String operator = workNote.getOperator();
        String workNoteNumber = workNote.getWorkNoteNumber();
        String startTime = workNote.getStartTime();
        String endTime = workNote.getEndTime();
        String reason = workNote.getReason();
        List<String> accountId = new ArrayList<>();
        List<SPort> sports = new ArrayList<>();
        for (Account account : accounts) {
            accountId.add(account.getAccountId());
        }
        for (Port p : ports) {
            SPort sPort = new SPort();
            BeanUtils.copyProperties(p, sPort);
            sPort.setAccountId(accountId);
            sports.add(sPort);
        }
        //准备提交工单
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
                baseMapper.update(w);
                Log log = new Log();
                //TODO 接口调用方只需要传入deviceId，ports 和 accounts由service层完成装载
                log.setDeviceName("");
                try {
                    logMapper.insert(log);
                }
                //捕捉以事务后不会回滚
                catch (RuntimeException e) {
                    logger.error("提交工单成功，但是log表写入失败: [deviceId]" + "deviceId" + "[]" + workNoteNumber);
                }
            }
        }

        return result;
    }

    @Override
    public Result submitNormalWorkNote(WorkNote workNote, String group) {
        Result result;
        WorkNoteOperator workNoteOperator = new WorkNoteOperator(workNote.getWorkNoteNumber());
        XMLDTO xmldto = workNoteOperator.getXmldtoBack();
        result = Result.getResult(xmldto);


        return result;
    }

    /**
     * @param workNoteNumber
     * @return
     */
    @Override
    public Result setWorkNote(String workNoteNumber) {
        return null;
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
