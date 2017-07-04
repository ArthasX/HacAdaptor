package com.openmind.hacadaptor.socket.xml.mode.worknote;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLBody;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by KJB-001064 on 2017/7/4.
 */
@XmlRootElement(name = "Document")
public class WorkNoteSentXMLBody extends XMLBody<WorkNoteSentXML,Object> {

    WorkNoteSentXML context;
    @XmlElement(name = "Context")
    @Override
    public WorkNoteSentXML getSentContext() {
        return context;
    }
    @Override
    public void setSentContext(WorkNoteSentXML context) {
        this.context = context;
    }
}
