package com.openmind.xml.mode.worknote;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * 提交变更工单
 */
public class WorkNoteXMLBack {
    private List<WorkNote> workNoteList;

    @XmlElement(name = "Item")
    public List<WorkNote> getWorkNoteList() {
        return workNoteList;
    }

    public void setWorkNoteList(List<WorkNote> workNoteList) {
        this.workNoteList = workNoteList;
    }
}
