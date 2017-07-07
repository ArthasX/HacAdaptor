package com.openmind.hacadaptor.socket.hacoperation;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLTransmitter;
import com.openmind.hacadaptor.socket.xml.mode.datafactory.SessionXMLDataFactory;
import com.openmind.hacadaptor.socket.xml.mode.session.SessionDTO;
import org.apache.log4j.Logger;

/**
 * Created by LiuBin on 2017/7/6.
 */
public class SessionOperator extends BaseOperation {
    static Logger logger = Logger.getLogger(SessionOperator.class);
    private XMLDTO xmldto;

    public SessionOperator(String workNoteNumber){
        xmldto=new SessionDTO();
        SessionXMLDataFactory sessionXMLDataFactory = new SessionXMLDataFactory(workNoteNumber);
        xmldto.setXmlData(sessionXMLDataFactory.getXMLData());
        xmldto= XMLTransmitter.trans(xmldto);
    }
    @Override
    public XMLDTO getXmldtoBack() {
        return xmldto;
    }
}
