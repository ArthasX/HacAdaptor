package com.openmind.hacadaptor.socket.xml.model.worknote;

import com.openmind.hacadaptor.socket.xml.model.common.Context;

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
