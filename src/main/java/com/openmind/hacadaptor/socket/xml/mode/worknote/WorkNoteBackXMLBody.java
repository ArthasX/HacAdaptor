package com.openmind.hacadaptor.socket.xml.mode.worknote;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLBody;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by KJB-001064 on 2017/7/4.
 */
@XmlRootElement(name = "Document")
public class WorkNoteBackXMLBody extends XMLBody<Object,WorkNoteBackXML> {

    WorkNoteBackXML context;
    @XmlElement(name = "Context")
    @Override
    public WorkNoteBackXML getBackContext() {
        return context;
    }
    @Override
    public void setBackContext(WorkNoteBackXML context) {
        this.context = context;
    }
}
