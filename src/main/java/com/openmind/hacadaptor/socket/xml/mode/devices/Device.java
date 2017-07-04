package com.openmind.hacadaptor.socket.xml.mode.devices;

import com.openmind.hacadaptor.socket.xml.mode.common.Context;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by KJB-001064 on 2017/6/28.
 */
public class Device extends Context {
    private String deviceName;
    private String ipAddress;
    private List<Port> port;
    private List<Account> account;

    @XmlElement(name = "DeviceName")
    public String getDeviceName() {
        return deviceName;
    }

    @XmlElement(name = "IpAddress")
    public String getIpAddress() {
        return ipAddress;
    }

    @XmlElement(name = "Port")
    public List<Port> getPort() {
        return port;
    }

    @XmlElement(name = "Account")
    public List<Account> getAccount() {
        return account;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setPort(List<Port> port) {
        this.port = port;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }
}
