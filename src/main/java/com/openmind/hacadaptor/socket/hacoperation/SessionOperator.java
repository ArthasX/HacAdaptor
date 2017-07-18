package com.openmind.hacadaptor.socket.hacoperation;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLTransmitter;
import com.openmind.hacadaptor.socket.xml.mode.datafactory.SessionXMLDataFactory;
import com.openmind.hacadaptor.socket.xml.mode.session.SSession;
import com.openmind.hacadaptor.socket.xml.mode.session.SessionDTO;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by LiuBin on 2017/7/6.
 */
public class SessionOperator extends BaseOperator {
    static Logger logger = Logger.getLogger(SessionOperator.class);
    private XMLDTO xmldto;

    public SessionOperator(String workNoteNumber) {
        xmldto = new SessionDTO();
        SessionXMLDataFactory sessionXMLDataFactory = new SessionXMLDataFactory(workNoteNumber);
        xmldto.setXmlData(sessionXMLDataFactory.getXMLData());

    }

    @Override
    public XMLDTO getXmldtoBack() {
        xmldto = XMLTransmitter.trans(xmldto);
        return xmldto;
    }

    /**
     * Whether a work note can be closed.
     * If a end date time is null,it means there is at least one alive session and the work note can't be closed.
     *
     * @return
     */
    public boolean closeable() {
        getXmldtoBack();
        List<SSession> sSessions = (List<SSession>) xmldto.getResult().getBackContext().getContextDetail();
        for (SSession sSession : sSessions) {
            String s = sSession.getEndDateTime();
            if (s.equals("") || s == "") {
                return false;
            }
        }
        return true;
    }
}
