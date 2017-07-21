package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.dao.LogMapper;
import com.openmind.hacadaptor.model.Identity;
import com.openmind.hacadaptor.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiuBin
 * @version Created on 2017/7/17
 */
@Service
public class LogServiceImpl extends BaseServiceImp<Log, Identity> implements ILogService {
    @Autowired
    LogMapper logMapper;

    @Override
    public int setWorkNoteStatusClosed(String workNoteNumber,String closeDate) {
        return logMapper.setWorkNoteStatusClosed(workNoteNumber,closeDate);
    }
}
