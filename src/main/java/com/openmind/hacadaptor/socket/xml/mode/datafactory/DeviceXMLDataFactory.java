package com.openmind.hacadaptor.socket.xml.mode.datafactory;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLData;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLHeader;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLType;
import com.openmind.hacadaptor.socket.xml.mode.devices.DeviceXML;

/**
 * Created by KJB-001064 on 2017/6/30.
 */
public class DeviceXMLDataFactory extends XMLDataFactory {

    public DeviceXMLDataFactory(){
        xmlHeader = XMLHeader.getPreparedHeader();
        xmlHeader.setiXmlType(XMLType.XML_WN_GET_RESOURCE);
        xmlHeader.setiXmlSize(0);
    }

    @Override
    public XMLData<DeviceXML> getXMLData() {
        XMLData<DeviceXML> xmlData= new XMLData<>();
        xmlData.setXmlBody(xmlBody);
        xmlData.setXmlHeader(xmlHeader);
        return xmlData;
    }

}
