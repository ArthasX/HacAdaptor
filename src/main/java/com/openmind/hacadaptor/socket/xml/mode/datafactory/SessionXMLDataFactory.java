package com.openmind.hacadaptor.socket.xml.mode.datafactory;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLData;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLHeader;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLType;
import com.openmind.hacadaptor.socket.xml.mode.session.SessionSentContext;
import com.openmind.hacadaptor.socket.xml.mode.session.SessionSentXMLBody;

/**
 * Created by LiuBin on 2017/7/6.
 */
public class SessionXMLDataFactory extends XMLDataFactory {

    public SessionXMLDataFactory(String workNoteNumber){
        xmlData = new XMLData();
        xmlHeader = XMLHeader.getPreparedHeader(XMLType.XML_QX_GET_SESSION);
        SessionSentXMLBody sessionSentXMLBody = new SessionSentXMLBody();
        SessionSentContext sessionSentContext =new SessionSentContext();
        sessionSentContext.setWorkNoteNumber(workNoteNumber);
        sessionSentXMLBody.setSentContext(sessionSentContext);
        xmlBody=sessionSentXMLBody;
        xmlData.setXmlHeader(xmlHeader);
        xmlData.setXmlBody(xmlBody);
    }
//    @Override
//    public XMLData getXMLData() {
//        return xmlData;
//    }
}
