package com.openmind.hacadaptor.mode;

import com.openmind.hacadaptor.sqlutil.Column;
import com.openmind.hacadaptor.sqlutil.Table;

import java.io.Serializable;

/**
 * Created by LiuBin on 2017/6/27.
 */
@Table("LOG")
public class Log extends Identity implements BaseMode {

    @Column("workorder")
    private String workOrder;
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

    public Log() {

    }

    public Log(String workOrder, String deviceName, String ip, String content, String optDate, String remark) {
        this.workOrder = workOrder;
        this.deviceName = deviceName;
        this.ip = ip;
        this.content = content;
        this.optDate = optDate;
        this.remark = remark;
    }

    public Log(String id, String workOrder, String deviceName, String ip, String content, String optDate, String remark) {
        super(id);
        this.workOrder = workOrder;
        this.deviceName = deviceName;
        this.ip = ip;
        this.content = content;
        this.optDate = optDate;
        this.remark = remark;
    }

    public String getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(String workOrder) {
        this.workOrder = workOrder;
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
}
