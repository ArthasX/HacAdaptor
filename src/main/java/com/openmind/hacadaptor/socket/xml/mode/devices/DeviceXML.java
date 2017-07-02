package com.openmind.xml.mode.devices;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by KJB-001064 on 2017/6/30.
 */
public class DeviceXML {
    private List<Device> device;

    @XmlElement(name = "Item")
    public List<Device> getDevice() {
        return device;
    }

    public void setDevice(List<Device> device) {
        this.device = device;
    }
}
