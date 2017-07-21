package com.openmind.hacadaptor.socket.xml.model.worknote;

import com.openmind.hacadaptor.socket.xml.model.common.Context;
import com.openmind.hacadaptor.socket.xml.model.devices.SPort;

import javax.xml.bind.annotation.XmlElement;

/**
 * 提交变更工单
 */
public class WorkNoteSentContext extends Context {
    private String operator;
    private String workNoteNumber;
    private String startTime;
    private String endTime;
    private String reason;
    private SPort[] SPort;

    public WorkNoteSentContext() {
    }

    public WorkNoteSentContext(String operator, String workNoteNumber, String startTime, String endTime, String reason, SPort[] SPort) {
        this.operator = operator;
        this.workNoteNumber = workNoteNumber;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reason = reason;
        this.SPort = SPort;
    }

    @XmlElement(name = "Operator")
    public String getOperator() {
        return operator;
    }

    @XmlElement(name = "WorkNoteNumber")
    public String getWorkNoteNumber() {
        return workNoteNumber;
    }

    @XmlElement(name = "StartTime")
    public String getStartTime() {
        return startTime;
    }

    @XmlElement(name = "EndTime")
    public String getEndTime() {
        return endTime;
    }

    @XmlElement(name = "Reason")
    public String getReason() {
        return reason;
    }

    @XmlElement(name = "Port")
    public SPort[] getPort() {
        return SPort;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setWorkNoteNumber(String workNoteNumber) {
        this.workNoteNumber = workNoteNumber;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setPort(SPort[] SPort) {
        this.SPort = SPort;
    }
}
