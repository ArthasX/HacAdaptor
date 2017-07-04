package com.openmind.hacadaptor.socket.xml.mode.devices;

import com.openmind.hacadaptor.socket.xml.mode.common.Context;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by KJB-001064 on 2017/6/30.
 */
public class DeviceBackXML extends Context {
    private List<Device> devices;

    @XmlElement(name = "Item")
    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
