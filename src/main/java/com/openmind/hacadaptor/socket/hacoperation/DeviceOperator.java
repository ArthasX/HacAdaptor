package com.openmind.hacadaptor.socket.hacoperation;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLTransmitter;
import com.openmind.hacadaptor.socket.xml.mode.datafactory.DeviceXMLDataFactory;
import com.openmind.hacadaptor.socket.xml.mode.devices.Device;
import com.openmind.hacadaptor.socket.xml.mode.devices.DeviceDTO;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by LiuBin on 2017/7/3.
 */
public class DeviceOperator extends BaseOperation {
    static Logger logger = Logger.getLogger(DeviceOperator.class);
    private XMLDTO xmldto;

    public DeviceOperator() {
        xmldto = new DeviceDTO();
        DeviceXMLDataFactory deviceXMLDataFactory = new DeviceXMLDataFactory();
        xmldto.setXmlData(deviceXMLDataFactory.getXMLData());
        xmldto = XMLTransmitter.trans(xmldto);
    }

    /**
     * get devices from hac
     */
    public List<Device> getDevices() {
        xmldto = getXmldtoBack();
        return (List<Device>)xmldto.getResult().getBackContext().getContextDetail();
    }

    @Override
    public XMLDTO getXmldtoBack() {
        return xmldto;
    }
}
