package com.openmind.xml.mode.common;

import com.openmind.xml.mode.devices.Device;
import com.openmind.xml.mode.devices.DeviceXML;
import com.openmind.xml.mode.login.LoginXML;
import com.openmind.xml.mode.login.User;
import com.openmind.xml.mode.session.Session;
import com.openmind.xml.mode.session.WorkNoteSessionXMLBack;
import com.openmind.xml.mode.session.WorkNoteSessionXMLSend;
import com.openmind.xml.mode.token.TokenXML;
import com.openmind.xml.mode.worknote.SetWorkNoteStatusXMLSend;
import com.openmind.xml.mode.worknote.WorkNote;
import com.openmind.xml.mode.worknote.WorkNoteXMLBack;
import com.openmind.xml.mode.worknote.WorkNoteXMLSend;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by KJB-001064 on 2017/6/26.
 */
@XmlRootElement(name = "Document")
public class XMLBody<T>  {
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
