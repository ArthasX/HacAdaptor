package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.model.Identity;
import com.openmind.hacadaptor.model.Log;

/**
 * @author LiuBin
 * @version Created on 2017/7/17
 */
public interface ILogService  extends IBaseService<Log,Identity>{
    int setWorkNoteStatusClosed(String workNoteNumber,String closeDate)throws Throwable;
}
