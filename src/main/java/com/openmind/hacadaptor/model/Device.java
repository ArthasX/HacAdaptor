package com.openmind.hacadaptor.model;

import com.openmind.hacadaptor.sqlutil.Column;
import com.openmind.hacadaptor.sqlutil.Table;

import java.util.List;

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

    private List<Port> ports;
    private List<Account> accounts;

    public Device() {
    }

    public Device(long id) {
        super(id);
    }

    public Device(String deviceId) {
        this.deviceId = deviceId;
    }

    public Device(String deviceId, String deviceName, String ipAddress, String groupId) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.ipAddress = ipAddress;
        this.groupId = groupId;
    }

    public Device(long id, String deviceId, String deviceName, String ipAddress, String groupId) {
        super(id);
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.ipAddress = ipAddress;
        this.groupId = groupId;
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<Port> getPorts() {
        return ports;
    }

    public void setPorts(List<Port> ports) {
        this.ports = ports;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
