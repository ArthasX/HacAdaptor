package com.openmind.hacadaptor.socket.xml.mode.login;

import com.openmind.hacadaptor.socket.xml.mode.common.IContext;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLBody;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by LiuBin on 2017/7/6.
 */
@XmlRootElement(name = "Document")
public class LoginBackXMLBody extends XMLBody<IContext, LoginContext> {

    private LoginContext context;

    @XmlElement(name = "Context")
    public LoginContext getBackContext() {
        return context;
    }

    public void setBackContext(LoginContext context) {
        this.context = context;
    }
}
