package com.openmind.hacadaptor.socket.xml.mode.worknote;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLBody;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by KJB-001064 on 2017/7/4.
 */
@XmlRootElement(name = "Document")
public class SetWorkNoteStatusXMLBody extends XMLBody<SetWorkNoteStatusSentXML, Object> {
    SetWorkNoteStatusSentXML context;

    @XmlElement(name = "Context")
    @Override
    public void setSentContext(SetWorkNoteStatusSentXML context) {
        this.context = context;
    }

    public SetWorkNoteStatusSentXML getSentContext() {
        return context;
    }

}
