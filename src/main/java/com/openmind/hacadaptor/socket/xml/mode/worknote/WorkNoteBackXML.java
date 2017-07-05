package com.openmind.hacadaptor.socket.xml.mode.worknote;

import com.openmind.hacadaptor.socket.xml.mode.common.Context;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * 提交变更工单,返回的结果
 */
public class WorkNoteBackXML extends Context {
    private List<WorkNote> workNoteList;

    @XmlElement(name = "Item")
    public List<WorkNote> getContextDetail() {
        return workNoteList;
    }

    public void setContextDetail(List<WorkNote> workNoteList) {
        this.workNoteList = workNoteList;
    }
}
