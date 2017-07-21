package com.openmind.hacadaptor.socket.xml.model.datafactory;

import com.openmind.hacadaptor.socket.xml.model.common.XMLData;
import com.openmind.hacadaptor.socket.xml.model.common.XMLHeader;
import com.openmind.hacadaptor.socket.xml.model.common.XMLType;

/**
 * Created by LiuBin on 2017/7/6.
 */
public class LoginXMLDataFactory extends XMLDataFactory {

    public LoginXMLDataFactory(){
        xmlData=new XMLData();
        xmlHeader= XMLHeader.getPreparedHeader(XMLType.XML_WN_GET_LOGIN);
        xmlData.setXmlHeader(xmlHeader);
    }
}
