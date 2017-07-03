package com.openmind.hacadaptor.socket.hacoperation;

import com.openmind.hacadaptor.socket.util.ByteUtil;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLBody;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLParser;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLTransmitter;
import com.openmind.hacadaptor.socket.xml.mode.datafactory.DeviceXMLDataFactory;
import com.openmind.hacadaptor.socket.xml.mode.devices.Device;
import com.openmind.hacadaptor.socket.xml.mode.devices.DeviceXML;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KJB-001064 on 2017/7/3.
 */
public class DeviceOperator {
    static Logger logger = Logger.getLogger(DeviceOperator.class);

    /**
     * get devices from hac
     */
    public static List<Device> getDevices() {
        List<Device> list = new ArrayList<>();
        DeviceXMLDataFactory deviceXMLDataFactory = new DeviceXMLDataFactory();
//        byte[] b = XMLTransmitter.trans(deviceXMLDataFactory.getXMLData());
//        byte[] header= ByteUtil.getSubBytes(b,0,20);
//        byte[] body=ByteUtil.getSubBytes(b,20);
        XMLDTO<DeviceXML> xmldto = new XMLDTO<>();
        xmldto.setXmlData(deviceXMLDataFactory.getXMLData());
        xmldto=XMLTransmitter.trans(xmldto);
//        try {
//
//        XMLBody<DeviceXML> result = XMLParser.XML2Object(XMLBody.class, body);
//            list = result.getContext().getDevices();
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//        XMLBody<DeviceXML> result=xmldto.getXmlBody();
//        list = result.getContext().getDevices();
//        list=xmldto.getXmlBody().getContext().getDevices();
        list=xmldto.getResult().getContext().getDevices();
        return list;
    }


}
