package com.openmind.hacadaptor.mode;

/**
 * 变更工单
 */
public class WorkNote extends Identity {
    private String operator;
    private String workNoteNumber;
    private String startTime;
    private String endTime;
    private String reason;
    private Port[] port;

    public WorkNote(){

    }

//    public WorkNote(long id) {
//        super(id);
//    }
//
//    public WorkNote(String operator, String workNoteNumber, String startTime, String endTime, String reason, Port[] port) {
//        this.operator = operator;
//        this.workNoteNumber = workNoteNumber;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.reason = reason;
//        this.port = port;
//    }
//
//    public WorkNote(long id, String operator, String workNoteNumber, String startTime, String endTime, String reason, Port[] port) {
//        super(id);
//        this.operator = operator;
//        this.workNoteNumber = workNoteNumber;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.reason = reason;
//        this.port = port;
//    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getWorkNoteNumber() {
        return workNoteNumber;
    }

    public void setWorkNoteNumber(String workNoteNumber) {
        this.workNoteNumber = workNoteNumber;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Port[] getPort() {
        return port;
    }

    public void setPort(Port[] port) {
        this.port = port;
    }
}
