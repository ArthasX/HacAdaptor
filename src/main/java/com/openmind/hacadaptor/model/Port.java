package com.openmind.hacadaptor.model;

import com.openmind.hacadaptor.sqlutil.Column;
import com.openmind.hacadaptor.sqlutil.Table;

import java.util.List;

/**
 * Created by LiuBin on 2017/6/22.
 */
@Table("PORT")
public class Port extends Identity implements IBasePort {
    @Column("portid")
    private String portId;
    @Column("name")
    private String name;
    @Column("protocol")
    private String protocol;
    @Column("deviceid")
    private String deviceId;
    private List<String> accountId;

    public Port() {

    }

    public Port(long id) {
        super(id);
    }

    public Port(String portId) {
        this.portId = portId;
    }

    public Port(long id, String portId, String name, String protocol, String deviceId) {
        super(id);
        this.portId = portId;
        this.name = name;
        this.protocol = protocol;
        this.deviceId = deviceId;
    }

    public Port(String portId, String name, String protocol, String deviceId) {
        this.portId = portId;
        this.name = name;
        this.protocol = protocol;
        this.deviceId = deviceId;
    }

    public String getPortId() {
        return portId;
    }

    public void setPortId(String portId) {
        this.portId = portId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public List<String> getAccountId() {
        return accountId;
    }

    public void setAccountId(List<String> accountId) {
        this.accountId = accountId;
    }
}
