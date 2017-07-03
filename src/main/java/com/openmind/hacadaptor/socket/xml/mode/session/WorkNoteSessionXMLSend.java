package com.openmind.hacadaptor.socket.xml.mode.session;

import com.openmind.hacadaptor.socket.xml.mode.common.Context;
import javax.xml.bind.annotation.XmlElement;


/**
 * 获取工单回话信息 用于关闭前确认
 */

public class WorkNoteSessionXMLSend extends Context{

    private String workNoteNumber;

    @XmlElement(name = "WorkNoteNumber")
    public String getWorkNoteNumber() {
        return workNoteNumber;
    }

    public void setWorkNoteNumber(String workNoteNumber) {
        this.workNoteNumber = workNoteNumber;
    }
}
