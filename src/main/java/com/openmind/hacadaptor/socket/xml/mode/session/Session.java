package com.openmind.hacadaptor.socket.xml.mode.session;

import javax.xml.bind.annotation.XmlElement;

/**
 * 工单Session的具体内容
 */

public class Session {

    private String sessionId;
    private String operator;
    private String clientIpAddress;
    private String startDateTime;
    private String endDateTime;
    private String destIpAddress;
    private String destPort;
    private String protocol;
    private String account;
    private String logSize;

    @XmlElement(name = "SessionId")
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @XmlElement(name = "Operator")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @XmlElement(name = "ClientIpAddress")
    public String getClientIpAddress() {
        return clientIpAddress;
    }

    public void setClientIpAddress(String clientIpAddress) {
        this.clientIpAddress = clientIpAddress;
    }

    @XmlElement(name = "StartDateTime")
    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    @XmlElement(name = "EndDateTime")
    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    @XmlElement(name = "DestIpAddress")
    public String getDestIpAddress() {
        return destIpAddress;
    }

    public void setDestIpAddress(String destIpAddress) {
        this.destIpAddress = destIpAddress;
    }

    @XmlElement(name = "DestPort")
    public String getDestPort() {
        return destPort;
    }

    public void setDestPort(String destPort) {
        this.destPort = destPort;
    }

    @XmlElement(name = "Protocol")
    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @XmlElement(name = "Account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @XmlElement(name = "LogSize")
    public String getLogSize() {
        return logSize;
    }

    public void setLogSize(String logSize) {
        this.logSize = logSize;
    }
}
