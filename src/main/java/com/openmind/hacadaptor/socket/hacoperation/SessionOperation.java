package com.openmind.hacadaptor.socket.hacoperation;

import com.openmind.hacadaptor.socket.xml.model.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.model.common.XMLTransmitter;
import com.openmind.hacadaptor.socket.xml.model.datafactory.SessionXMLDataFactory;
import com.openmind.hacadaptor.socket.xml.model.session.SSession;
import com.openmind.hacadaptor.socket.xml.model.session.SessionDTO;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by LiuBin on 2017/7/6.
 */
public class SessionOperation extends BaseOperation {
    static Logger logger = Logger.getLogger(SessionOperation.class);
    private XMLDTO xmldto;
    private StringBuilder sessionSb;
    private List<SSession> sSessions;

    public SessionOperation(String workNoteNumber) {
        xmldto = new SessionDTO();
        SessionXMLDataFactory sessionXMLDataFactory = new SessionXMLDataFactory(workNoteNumber);
        xmldto.setXmlData(sessionXMLDataFactory.getXMLData());

    }

    @Override
    public XMLDTO getXmldtoBack() {
        if (xmldto.getXmlBodyBytesBack() == null)
            xmldto = XMLTransmitter.trans(xmldto);
        return xmldto;
    }

    public List<SSession> getsSessions() {
        if (sSessions == null) {
            getXmldtoBack();
            sSessions = (List<SSession>) xmldto.getResult().getBackContext().getContextDetail();
        }
        return sSessions;
    }

    public String getCause() {
        if (sessionSb == null)
            return "";
        return sessionSb.toString();
    }

    /**
     * Whether a work note can be closed.
     * If a end-datetime is null or "" ,it means there is at least one alive session and the work note can't be closed.
     *
     * @return
     */
    public boolean closeable() {
        sessionSb = new StringBuilder();
        boolean flag = true;
        List<SSession> sSessions = getsSessions();
        for (SSession sSession : sSessions) {
            String s = sSession.getEndDateTime();
            if (s.equals("") || s == "") {
                sessionSb.append("[sessionId]:").append(sSession.getSessionId())
                        .append("[operator]:").append(sSession.getOperator());
                flag = false;
            }
        }
        if (!flag)
            sessionSb.append(" 上述Session未关闭，无法关闭工单");
        return flag;
    }


}
