package com.openmind.hacadaptor.socket.xml.mode.devices;

import com.openmind.hacadaptor.socket.xml.mode.common.Context;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by LiuBin on 2017/6/30.
 */
public class DeviceBackContext extends Context<List<SDevice>> {
//    private List<SDevice> devices;
    private List<SDevice> contextDetail;

    public void setDevices(List<SDevice> SDevices) {
        this.contextDetail = SDevices;
    }
    @XmlElement(name = "Item")
    public List<SDevice> getContextDetail(){
        return contextDetail;
    }

    public void setContextDetail(List<SDevice> contextDetail) {
        this.contextDetail = contextDetail;
    }
}
