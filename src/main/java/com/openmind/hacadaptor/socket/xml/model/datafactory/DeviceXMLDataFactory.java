package com.openmind.hacadaptor.socket.xml.model.datafactory;

import com.openmind.hacadaptor.socket.xml.model.common.XMLData;
import com.openmind.hacadaptor.socket.xml.model.common.XMLHeader;
import com.openmind.hacadaptor.socket.xml.model.common.XMLType;

/**
 * Created by LiuBin on 2017/6/30.
 */
public class DeviceXMLDataFactory extends XMLDataFactory {

    /**
     * 由于获取device资源不需要发送xml data，所以 xmlSize默认是0
     */
    public DeviceXMLDataFactory() {
        xmlData = new XMLData();
        xmlHeader = XMLHeader.getPreparedHeader(XMLType.XML_WN_GET_RESOURCE);
//        xmlHeader.setiXmlType(XMLType.XML_WN_GET_RESOURCE);
       // xmlHeader.setiXmlSize(0);
       // DeviceXMLBody deviceXMLBody = new DeviceXMLBody();
        xmlData.setXmlHeader(xmlHeader);
        //xmlData.setXmlBody(deviceXMLBody);
    }

//    @Override
//    public XMLData getXMLData() {
//        return xmlData;
//    }


}
