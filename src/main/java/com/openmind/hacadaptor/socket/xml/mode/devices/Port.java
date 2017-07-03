package com.openmind.xml.mode.devices;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * 提交的变更工单中包含的端口
 */
public class Port {
    private String portId;
    private List<String> accountId;

    @XmlElement(name="Port")
    public String getPortId() {
        return portId;
    }
    @XmlElement(name="Account")
    public List<String> getAccountId() {
        return accountId;
    }

    public void setPortId(String portId) {
        this.portId = portId;
    }

    public void setAccountId(List<String> accountId) {
        this.accountId = accountId;
    }
}