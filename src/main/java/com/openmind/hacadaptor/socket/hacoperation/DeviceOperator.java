package com.openmind.hacadaptor.socket.hacoperation;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLTransmitter;
import com.openmind.hacadaptor.socket.xml.mode.datafactory.DeviceXMLDataFactory;
import com.openmind.hacadaptor.socket.xml.mode.devices.Device;
import com.openmind.hacadaptor.socket.xml.mode.devices.DeviceXMLDTO;
import com.openmind.hacadaptor.socket.xml.mode.devices.DeviceBackXML;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KJB-001064 on 2017/7/3.
 */
public class DeviceOperator {
    static Logger logger = Logger.getLogger(DeviceOperator.class);
    XMLDTO xmldto;

    public DeviceOperator() {
        xmldto = new DeviceXMLDTO();
    }

    /**
     * get devices from hac
     */
    public List<Device> getDevices() {
        List<Device> list = new ArrayList<>();
        DeviceXMLDataFactory deviceXMLDataFactory = new DeviceXMLDataFactory();
        xmldto.setXmlData(deviceXMLDataFactory.getXMLData());
        xmldto = XMLTransmitter.trans(xmldto);
        DeviceBackXML deviceBackXML = (DeviceBackXML) xmldto.getResult().getBackContext();
        list = deviceBackXML.getDevices();
        return list;
    }


}
