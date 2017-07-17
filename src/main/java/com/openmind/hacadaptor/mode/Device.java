package com.openmind.hacadaptor.mode;

import com.openmind.hacadaptor.sqlutil.Column;
import com.openmind.hacadaptor.sqlutil.IdWorker;
import com.openmind.hacadaptor.sqlutil.PK;
import com.openmind.hacadaptor.sqlutil.Table;

import java.io.Serializable;

/**
 * Created by LiuBin on 2017/6/22.
 */
@Table("DEVICE")
public class Device extends Identity {

    @Column("deviceid")
//    private Identity deviceId;
    private String deviceId;
    @Column("devicename")
    private String deviceName;
    @Column("ipaddress")
    private String ipAddress;
    @Column("groupId")
    private String groupId;

    public Device() {
    }

    public Device(long id) {
        super(id);
    }

    public Device(String deviceId) {
        this.deviceId = deviceId;
    }

    public Device(String deviceId, String deviceName, String ipAddress) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.ipAddress = ipAddress;
    }

    public Device(long id, String deviceId, String deviceName, String ipAddress) {
        super(id);
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.ipAddress = ipAddress;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    //
//    public SDevice(Identity deviceId, String name, String ip) {
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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
