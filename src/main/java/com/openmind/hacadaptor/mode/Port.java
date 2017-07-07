package com.openmind.hacadaptor.mode;

import com.openmind.hacadaptor.sqlutil.Column;
import com.openmind.hacadaptor.sqlutil.Table;

import java.io.Serializable;

/**
 * Created by LiuBin on 2017/6/22.
 */
@Table("PORT")
public class Port extends Identity implements BaseMode{
    @Column("portid")
    private String portId;
    @Column("name")
    private String name;
    @Column("protocol")
    private String protocol;
    @Column("deviceid")
    private String deviceId;

    public Port() {
        super();
    }

    public Port(String portId) {
        this.portId = portId;
    }

    //    public Port(long id, String portId, String name, String protocol, String deviceId) {
    public Port(String id, String portId, String name, String protocol, String deviceId) {
        super(id);
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
}
