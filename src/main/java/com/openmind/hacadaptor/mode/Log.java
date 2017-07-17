package com.openmind.hacadaptor.mode;

import com.openmind.hacadaptor.sqlutil.Column;
import com.openmind.hacadaptor.sqlutil.IdWorker;
import com.openmind.hacadaptor.sqlutil.Table;

/**
 * Created by LiuBin on 2017/6/27.
 */
@Table("LOG")
public class Log extends Identity {

    @Column("worknote")
    private String workNote;
    @Column("devicename")
    private String deviceName;
    @Column("ip")
    private String ip;
    @Column("content")
    private String content;
    @Column("optDate")
    private String optDate;
    @Column("remark")
    private String remark;
    @Column("startDate")
    private String startDate;
    @Column("endDate")
    private String endDate;
    @Column("status")
    private String status;
    @Column("closeDate")
    private String closeDate;

    public Log() {

    }

    public Log(long id) {
        super(id);
    }

    public Log(String workNote, String deviceName, String ip, String content, String optDate, String remark, String startDate, String endDate, String status) {
        this.workNote = workNote;
        this.deviceName = deviceName;
        this.ip = ip;
        this.content = content;
        this.optDate = optDate;
        this.remark = remark;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Log(long id, String workNote, String deviceName, String ip, String content, String optDate, String remark, String startDate, String endDate, String status) {
        super(id);
        this.workNote = workNote;
        this.deviceName = deviceName;
        this.ip = ip;
        this.content = content;
        this.optDate = optDate;
        this.remark = remark;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public String getWorkNote() {
        return workNote;
    }

    public void setWorkNote(String workNote) {
        this.workNote = workNote;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
}
