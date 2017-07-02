package com.openmind.xml.mode.datafactory;

import com.openmind.xml.mode.common.XMLBody;
import com.openmind.xml.mode.common.XMLData;
import com.openmind.xml.mode.common.XMLHeader;
import com.openmind.xml.mode.common.XMLType;
import com.openmind.xml.mode.devices.Device;

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
    public XMLData getXMLData() {
        XMLData<Device> xmlData= new XMLData<>();
        xmlData.setXmlBody(xmlBody);
        xmlData.setXmlHeader(xmlHeader);
        return xmlData;
    }

}
