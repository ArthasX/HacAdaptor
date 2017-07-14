package com.openmind.hacadaptor.socket.xml.mode.worknote;

import com.openmind.hacadaptor.socket.xml.mode.common.Context;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * 提交变更工单,返回的结果
 */
public class WorkNoteBackContext extends Context<List<SWorkNote>> {
    private List<SWorkNote> workNoteList;

    @XmlElement(name = "Item")
    public List<SWorkNote> getContextDetail() {
        return workNoteList;
    }

    public void setContextDetail(List<SWorkNote> workNoteList) {
        this.workNoteList = workNoteList;
    }
}
