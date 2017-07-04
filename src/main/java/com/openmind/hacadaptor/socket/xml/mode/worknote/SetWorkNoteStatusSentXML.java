package com.openmind.hacadaptor.socket.xml.mode.worknote;

import com.openmind.hacadaptor.socket.xml.mode.common.Context;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by KJB-001064 on 2017/6/28.
 */
public class SetWorkNoteStatusSentXML extends Context {
    private String WorkNoteNumber;

    @XmlElement(name = "WorkNoteNumber")
    public String getWorkNoteNumber() {
        return WorkNoteNumber;
    }

    public void setWorkNoteNumber(String workNoteNumber) {
        WorkNoteNumber = workNoteNumber;
    }
}
