package com.openmind.hacadaptor.socket.hacoperation;

import com.openmind.hacadaptor.socket.xml.model.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.model.common.XMLTransmitter;
import com.openmind.hacadaptor.socket.xml.model.datafactory.DeviceXMLDataFactory;
import com.openmind.hacadaptor.socket.xml.model.devices.SDevice;
import com.openmind.hacadaptor.socket.xml.model.devices.DeviceDTO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by LiuBin on 2017/7/3.
 */
@Component(value = "deviceOperation")
public class DeviceOperation extends BaseOperation {
    static Logger logger = Logger.getLogger(DeviceOperation.class);
    private XMLDTO xmldto;

    public DeviceOperation() {
        xmldto = new DeviceDTO();
        DeviceXMLDataFactory deviceXMLDataFactory = new DeviceXMLDataFactory();
        xmldto.setXmlData(deviceXMLDataFactory.getXMLData());

    }

    /**
     * get devices from hac
     */
    @SuppressWarnings("unchecked")
    public List<SDevice> getDevices() {
        xmldto = getXmldtoBack();
        return (List<SDevice>)xmldto.getResult().getBackContext().getContextDetail();
    }

    @Override
    public XMLDTO getXmldtoBack() {
        xmldto = XMLTransmitter.trans(xmldto);
        return xmldto;
    }
}
