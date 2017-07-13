package com.openmind.hacadaptor.mode;

import com.openmind.hacadaptor.sqlutil.Column;
import com.openmind.hacadaptor.sqlutil.Table;

/**
 * Created by LiuBin on 2017/6/27.
 */
@Table("LOG")
public class Log extends Identity implements IBaseMode {

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



    public Log() {

    }

    public Log(String workNote, String deviceName, String ip, String content, String optDate, String remark, String startDate, String endDate) {
        this.workNote = workNote;
        this.deviceName = deviceName;
        this.ip = ip;
        this.content = content;
        this.optDate = optDate;
        this.remark = remark;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Log(long id, String workNote, String deviceName, String ip, String content, String optDate, String remark, String startDate, String endDate) {
        super(id);
        this.workNote = workNote;
        this.deviceName = deviceName;
        this.ip = ip;
        this.content = content;
        this.optDate = optDate;
        this.remark = remark;
        this.startDate = startDate;
        this.endDate = endDate;
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
}
