package com.openmind.hacadaptor.socket.xml.mode.session;

import com.openmind.hacadaptor.socket.xml.mode.common.Context;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * 返回的Session结果
 */
public class WorkNoteSessionXMLBack extends Context<List<Session>> {
    private List<Session> session;

    public WorkNoteSessionXMLBack() {
        this.session = new ArrayList<Session>();
    }

    @XmlElement(name = "Session")
    public List<Session> getContextDetail() {
        return session;
    }

    public void setContextDetail(List<Session> session) {
        this.session = session;
    }

    public void addSession(Session s) {
        session.add(s);
    }
}
