package com.openmind.hacadaptor.socket.xml.mode.session;

import com.openmind.hacadaptor.socket.xml.mode.common.IContext;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLBody;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by LiuBin on 2017/7/6.
 */
@XmlRootElement(name = "Document")
public class SessionSentXMLBody extends XMLBody<SessionSentContext, IContext> {
    //workNoteNumber
    private SessionSentContext context;

    @XmlElement(name = "Context")
    public SessionSentContext getSentContext() {
        return context;
    }

    public void setSentContext(SessionSentContext context) {
        this.context = context;
    }
}
