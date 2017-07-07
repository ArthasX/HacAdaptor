package com.openmind.hacadaptor.socket.xml.mode.session;

import com.openmind.hacadaptor.socket.xml.mode.common.IContext;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLBody;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by LiuBin on 2017/7/6.
 */
@XmlRootElement(name = "Document")
public class SessionBackXMLBody extends XMLBody<IContext, SessionBackContext> {
    private SessionBackContext context;

    @XmlElement(name = "Context")
    public SessionBackContext getBackContext() {
        return context;
    }

    public void setBackContext(SessionBackContext context) {
        this.context = context;
    }
}
