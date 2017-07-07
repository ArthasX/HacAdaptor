package com.openmind.hacadaptor.socket.xml.mode.worknote;

import com.openmind.hacadaptor.socket.xml.mode.common.IContext;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLBody;

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
    }
}
