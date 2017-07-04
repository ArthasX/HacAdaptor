package com.openmind.hacadaptor.socket.xml.mode.datafactory;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLData;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLHeader;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLType;
import com.openmind.hacadaptor.socket.xml.mode.devices.DeviceXMLBody;

/**
 * Created by KJB-001064 on 2017/6/30.
 */
public class DeviceXMLDataFactory extends XMLDataFactory {

    public DeviceXMLDataFactory() {
        xmlHeader = XMLHeader.getPreparedHeader();
        xmlHeader.setiXmlType(XMLType.XML_WN_GET_RESOURCE);
        xmlHeader.setiXmlSize(0);
    }

    @Override
    public XMLData getXMLData() {
        XMLData xmlData = new XMLData();
        DeviceXMLBody deviceXMLBody = new DeviceXMLBody();
        xmlData.setXmlBody(deviceXMLBody);
        xmlData.setXmlHeader(xmlHeader);
        return xmlData;
    }



}
