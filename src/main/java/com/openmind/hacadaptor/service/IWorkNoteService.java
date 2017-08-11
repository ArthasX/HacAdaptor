package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.model.Identity;
import com.openmind.hacadaptor.model.Result;
import com.openmind.hacadaptor.model.WorkNote;
import com.openmind.hacadaptor.socket.xml.model.devices.SPort;
import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/7/17
 */
public interface IWorkNoteService extends IBaseService<WorkNote, Identity> {
    Result submitEmergentWorkNote(WorkNote workNote, List<SPort> sPorts, List<String> groupNames)throws Throwable;

    Result submitNormalWorkNote(WorkNote workNote, List<String> groupNames)throws Throwable;

    Result setWorkNote(String workNoteNumber)throws Throwable;

    Result closeable(String workNoteNumber)throws Throwable;
}
