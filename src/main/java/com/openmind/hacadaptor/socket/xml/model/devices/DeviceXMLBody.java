package com.openmind.hacadaptor.socket.xml.model.devices;

import com.openmind.hacadaptor.socket.xml.model.common.IContext;
import com.openmind.hacadaptor.socket.xml.model.common.XMLBody;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by LiuBin on 2017/7/4.
 */
@XmlRootElement(name = "Document")
public class DeviceXMLBody extends XMLBody<IContext,DeviceBackContext> {

    DeviceBackContext context;

    @XmlElement(name = "Context")
    @Override
    public DeviceBackContext getBackContext() {
        return context;
    }

    public void setBackContext(DeviceBackContext context) {
        this.context = context;
    }
}
