package com.openmind.hacadaptor.mode;

import com.openmind.hacadaptor.sqlutil.Column;
import com.openmind.hacadaptor.sqlutil.Table;

import java.io.Serializable;

/**
 * Created by KJB-001064 on 2017/6/22.
 */
@Table("DEVICE")
public class Device extends Identity {

    @Column("deviceid")
    private String deviceId;
    @Column("name")
    private String name;
    @Column("ip")
    private String ip;


    public Device() {
        super();
    }

    public Device(String deviceId) {
        this.deviceId = deviceId;
    }

    public Device(String deviceId, String name, String ip, long id) {
        super(id);
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
