package com.openmind.hacadaptor.socket.xml.mode.worknote;

import com.openmind.hacadaptor.socket.xml.mode.common.Context;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by LiuBin on 2017/6/30.
 */
public class SWorkNote extends Context {//这里的继承可以去掉
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
