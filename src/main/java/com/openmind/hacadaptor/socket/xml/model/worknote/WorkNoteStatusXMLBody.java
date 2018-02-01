package com.openmind.hacadaptor.socket.xml.model.worknote;

import com.openmind.hacadaptor.socket.xml.model.common.IContext;
import com.openmind.hacadaptor.socket.xml.model.common.XMLBody;
import com.openmind.hacadaptor.socket.xml.model.common.XMLParser;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by LiuBin on 2017/7/4.
 */
@XmlRootElement(name = "Document")
public class WorkNoteStatusXMLBody extends XMLBody<WorkNoteStatusSentContext, IContext> {
    WorkNoteStatusSentContext context;

    @XmlElement(name = "Context")
    @Override
    public void setSentContext(WorkNoteStatusSentContext context) {
        this.context = context;
        try {
            bytes = XMLParser.Object2XML(this).getBytes();
            size = bytes.length;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public WorkNoteStatusSentContext getSentContext() {
        return context;
    }

}
