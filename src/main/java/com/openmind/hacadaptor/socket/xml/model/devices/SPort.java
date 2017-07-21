package com.openmind.hacadaptor.socket.xml.model.devices;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * 提交的变更工单中包含的端口
 */
public class SPort {
    private String portId;
    private String name;
    private String protocol;
    private List<String> accountId;

    public SPort() {
    }

    public SPort(String portId, List<String> accountId) {
        this.portId = portId;
        this.accountId = accountId;
    }

    public SPort(String portId, String name, String protocol, List<String> accountId) {
        this.portId = portId;
        this.name = name;
        this.protocol = protocol;
        this.accountId = accountId;
    }

    @XmlElement(name = "PortId")
    public String getPortId() {
        return portId;
    }

    @XmlElement(name = "Account")
    public List<String> getAccountId() {
        return accountId;
    }
    @XmlElement(name = "Name")
    public String getName() {
        return name;
    }
    @XmlElement(name = "Protocol")
    public String getProtocol() {
        return protocol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setPortId(String portId) {
        this.portId = portId;
    }

    public void setAccountId(List<String> accountId) {
        this.accountId = accountId;
    }
}
