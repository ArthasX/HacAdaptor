package com.openmind.xml.mode.worknote;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by KJB-001064 on 2017/6/30.
 */
public class WorkNote {
    private String workNoteId;
    private String workNoteNumber;

    @XmlElement(name = "WorkNoteId")
    public String getWorkNoteId() {
        return workNoteId;
    }

    @XmlElement(name = "WorkNoteNumber")
    public String getWorkNoteNumber() {
        return workNoteNumber;
    }

    public void setWorkNoteId(String workNoteId) {
        this.workNoteId = workNoteId;
    }

    public void setWorkNoteNumber(String workNoteNumber) {
        this.workNoteNumber = workNoteNumber;
    }
}
