package com.openmind.hacadaptor.model;

import com.openmind.hacadaptor.sqlutil.Column;
import com.openmind.hacadaptor.sqlutil.Table;

/**
 * Created by LiuBin on 2017/6/27.
 */
@Table("LOG")
public class Log extends Identity {

    @Column("worknoteid")
    private String workNoteId;
    @Column("worknotenumber")
    private String workNoteNumber;
    @Column("groupname")
    private String groupName;
    @Column("ip")
    private String ip;
    @Column("content")
    private String content;
    @Column("optdate")
    private String optDate;
    @Column("remark")
    private String remark;
    @Column("starttime")
    private String startTime;
    @Column("endtime")
    private String endTime;
    @Column("status")
    private String status;
    @Column("closeDate")
    private String closeDate;
    @Column("worknotetype")
    private String worknotetype;

    public Log() {

    }

    public Log(long id) {
        super(id);
    }

    public Log(String workNoteId, String workNoteNumber, String groupName, String ip, String content, String optDate, String remark, String startTime, String endTime, String status, String closeDate, String worknotetype) {
        this.workNoteId = workNoteId;
        this.workNoteNumber = workNoteNumber;
        this.groupName = groupName;
        this.ip = ip;
        this.content = content;
        this.optDate = optDate;
        this.remark = remark;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.closeDate = closeDate;
        this.worknotetype = worknotetype;
    }

    public Log(long id, String workNoteId, String workNoteNumber, String groupName, String ip, String content, String optDate, String remark, String startTime, String endTime, String status, String closeDate, String worknotetype) {
        super(id);
        this.workNoteId = workNoteId;
        this.workNoteNumber = workNoteNumber;
        this.groupName = groupName;
        this.ip = ip;
        this.content = content;
        this.optDate = optDate;
        this.remark = remark;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.closeDate = closeDate;
        this.worknotetype = worknotetype;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOptDate() {
        return optDate;
    }

    public void setOptDate(String optDate) {
        this.optDate = optDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWorkNoteId() {
        return workNoteId;
    }

    public void setWorkNoteId(String workNoteId) {
        this.workNoteId = workNoteId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getWorknotetype() {
        return worknotetype;
    }

    public void setWorknotetype(String worknotetype) {
        this.worknotetype = worknotetype;
    }
}
