package com.openmind.hacadaptor.socket.xml.mode.devices;

import com.openmind.hacadaptor.socket.xml.mode.common.Context;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by LiuBin on 2017/6/30.
 */
public class DeviceBackContext extends Context<List<Device>> {
//    private List<Device> devices;
    private List<Device> contextDetail;

    public void setDevices(List<Device> devices) {
        this.contextDetail = devices;
    }
    @XmlElement(name = "Item")
    public List<Device> getContextDetail(){
        return contextDetail;
    }

    public void setContextDetail(List<Device> contextDetail) {
        this.contextDetail = contextDetail;
    }
}
