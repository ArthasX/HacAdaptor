package com.openmind.hacadaptor.socket.xml.mode.worknote;

import com.openmind.hacadaptor.socket.xml.mode.common.Context;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by LiuBin on 2017/6/28.
 */
public class WorkNoteStatusSentContext extends Context<String> {
    private String WorkNoteNumber;

    @XmlElement(name = "WorkNoteNumber")
    public String getWorkNoteNumber() {
        return WorkNoteNumber;
    }

    public void setWorkNoteNumber(String workNoteNumber) {
        WorkNoteNumber = workNoteNumber;
    }
}
