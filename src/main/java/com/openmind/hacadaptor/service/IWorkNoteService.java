package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.mode.*;

import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/7/17
 */
public interface IWorkNoteService extends IBaseService<WorkNote,Identity> {
     Result submitEmergentWorkNote(WorkNote workNote, List<Port> ports, List<Account> accounts);
     Result submitNormalWorkNote(WorkNote workNote,String group);
     Result setWorkNote(String workNoteNumber);

}
