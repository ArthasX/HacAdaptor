package com.openmind.hacadaptor.socket.xml.model.session;

import com.openmind.hacadaptor.socket.xml.model.common.Context;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SessionBackContext extends Context<List<SSession>> {
    private List<SSession> session;

    public SessionBackContext() {
        this.session = new ArrayList<SSession>();
    }

    @XmlElement(name = "Session")
    public List<SSession> getContextDetail() {
        return session;
    }

    public void setContextDetail(List<SSession> session) {
        this.session = session;
    }

    public void addSession(SSession s) {
        session.add(s);
    }
}
