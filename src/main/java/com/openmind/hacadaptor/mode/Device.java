package com.openmind.hacadaptor.mode;

import com.openmind.hacadaptor.sqlutil.Column;
import com.openmind.hacadaptor.sqlutil.Table;

import java.io.Serializable;

/**
 * Created by LiuBin on 2017/6/22.
 */
@Table("DEVICE")
public class Device implements BaseMode{

    @Column("deviceid")
//    private Identity deviceId;
    private String deviceId;
    @Column("name")
    private String name;
    @Column("ip")
    private String ip;


    public Device() {

    }

    public Device(String deviceId) {
        this.deviceId = deviceId;
    }

    public Device(String id,String deviceId, String name, String ip) {
        this.deviceId = deviceId;
        this.name = name;
        this.ip = ip;

    }


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

//
//    public Device(Identity deviceId, String name, String ip) {
//        this.deviceId = deviceId;
//        this.name = name;
//        this.ip = ip;
//    }
//
//    public Identity getDeviceId() {
//        return deviceId;
//    }
//
//    public void setDeviceId(Identity deviceId) {
//        this.deviceId = deviceId;
//    }
//
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
