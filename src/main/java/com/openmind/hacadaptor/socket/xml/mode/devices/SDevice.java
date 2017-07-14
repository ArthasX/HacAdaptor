package com.openmind.hacadaptor.socket.xml.mode.devices;

import com.openmind.hacadaptor.socket.xml.mode.common.Context;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by LiuBin on 2017/6/28.
 */
public class SDevice extends Context {
    private String deviceId;
    private String deviceName;
    private String ipAddress;
    private List<SPort> SPort;
    private List<SAccount> SAccount;

    @XmlElement(name = "DeviceId")
    public String getDeviceId() {
        return deviceId;
    }

    @XmlElement(name = "DeviceName")
    public String getDeviceName() {
        return deviceName;
    }

    @XmlElement(name = "IpAddress")
    public String getIpAddress() {
        return ipAddress;
    }

    @XmlElement(name = "Port")
    public List<SPort> getPort() {
        return SPort;
    }

    @XmlElement(name = "Account")
    public List<SAccount> getAccount() {
        return SAccount;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setPort(List<SPort> SPort) {
        this.SPort = SPort;
    }

    public void setAccount(List<SAccount> SAccount) {
        this.SAccount = SAccount;
    }
}
