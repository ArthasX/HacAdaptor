package com.openmind.hacadaptor.socket.xml.mode.devices;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLBody;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by KJB-001064 on 2017/7/4.
 */
@XmlRootElement(name = "Document")
public class DeviceXMLBody extends XMLBody<Object,DeviceBackXML> {

    DeviceBackXML context;

    @XmlElement(name = "Context")
    @Override
    public DeviceBackXML getBackContext() {
        return context;
    }

    public void setBackContext(DeviceBackXML context) {
        this.context = context;
    }
}
