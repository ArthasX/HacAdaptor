package com.openmind.hacadaptor.socket.xml.mode.common;

import com.openmind.hacadaptor.socket.xml.mode.devices.Device;
import com.openmind.hacadaptor.socket.xml.mode.devices.DeviceXML;
import com.openmind.hacadaptor.socket.xml.mode.login.LoginXML;
import com.openmind.hacadaptor.socket.xml.mode.login.User;
import com.openmind.hacadaptor.socket.xml.mode.session.Session;
import com.openmind.hacadaptor.socket.xml.mode.session.WorkNoteSessionXMLBack;
import com.openmind.hacadaptor.socket.xml.mode.session.WorkNoteSessionXMLSend;
import com.openmind.hacadaptor.socket.xml.mode.token.TokenXML;
import com.openmind.hacadaptor.socket.xml.mode.worknote.SetWorkNoteStatusXMLSend;
import com.openmind.hacadaptor.socket.xml.mode.worknote.WorkNote;
import com.openmind.hacadaptor.socket.xml.mode.worknote.WorkNoteXMLBack;
import com.openmind.hacadaptor.socket.xml.mode.worknote.WorkNoteXMLSend;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by KJB-001064 on 2017/6/26.
 */
@XmlRootElement(name = "Document")
@XmlType(name = "", propOrder = {"documentProperties","context"})
public class XMLBody<T extends  Context>  {
    protected DocumentProperties documentProperties;
    protected T context;

    public XMLBody() {
        documentProperties = new DocumentProperties();
        documentProperties.setVersion("3");
    }

    public XMLBody(String num) {
        documentProperties = new DocumentProperties();
        documentProperties.setVersion("3");
        documentProperties.setNumber(num);
    }

    public XMLBody(T context){
        this.context = context;
    }

    @XmlElement(name = "DocumentProperties")
    public DocumentProperties getDocumentProperties() {
        return documentProperties;
    }

    public void setDocumentProperties(DocumentProperties documentProperties) {
        this.documentProperties = documentProperties;
    }

    @XmlElements({
            @XmlElement(name = "Context",type= WorkNoteSessionXMLSend.class),
            @XmlElement(name = "Context",type= Session.class),
            @XmlElement(name = "Context",type= WorkNoteSessionXMLBack.class),
            @XmlElement(name = "Context",type= DeviceXML.class),
            @XmlElement(name = "Context",type= Device.class),
            @XmlElement(name = "Context",type= LoginXML.class),
            @XmlElement(name = "Context",type= User.class),
            @XmlElement(name = "Context",type= TokenXML.class),
            @XmlElement(name = "Context",type= WorkNote.class),
            @XmlElement(name = "Context",type= WorkNoteXMLBack.class),
            @XmlElement(name = "Context",type= WorkNoteXMLSend.class),
            @XmlElement(name = "Context",type= SetWorkNoteStatusXMLSend.class),
    })

    public T getContext() {
        return context;
    }

    public void setContext(T context) {
        this.context = context;
    }


}
