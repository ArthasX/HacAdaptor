package com.openmind.hacadaptor.socket.hacoperation;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLTransmitter;
import com.openmind.hacadaptor.socket.xml.mode.datafactory.DeviceXMLDataFactory;
import com.openmind.hacadaptor.socket.xml.mode.devices.Device;
import com.openmind.hacadaptor.socket.xml.mode.devices.DeviceDTO;
import com.openmind.hacadaptor.socket.xml.mode.devices.DeviceBackXML;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by KJB-001064 on 2017/7/3.
 */
public class DeviceOperator implements IOperation {
    static Logger logger = Logger.getLogger(DeviceOperator.class);
    private XMLDTO xmldto;

    public DeviceOperator() {
        xmldto = new DeviceDTO();
    }

    /**
     * get devices from hac
     */
    public List<Device> getDevices() {
        xmldto = getXmldtoBack();
        DeviceBackXML deviceBackXML = (DeviceBackXML) xmldto.getResult().getBackContext();
        return deviceBackXML.getDevices();
    }

    public XMLDTO getXmldtoBack() {
        DeviceXMLDataFactory deviceXMLDataFactory = new DeviceXMLDataFactory();
        xmldto.setXmlData(deviceXMLDataFactory.getXMLData());
        xmldto = XMLTransmitter.trans(xmldto);
        return xmldto;
    }

}
