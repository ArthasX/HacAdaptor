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
public class WorkNoteSentXMLBody extends XMLBody<WorkNoteSentContext,IContext> {

    WorkNoteSentContext context;
    @XmlElement(name = "Context")
    @Override
    public WorkNoteSentContext getSentContext() {
        return context;
    }
    @Override
    public void setSentContext(WorkNoteSentContext context) {
        this.context = context;
        try {
            bytes = XMLParser.Object2XML(this).getBytes();
            size=bytes.length;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
