package com.openmind.hacadaptor.socket.xml.mode.worknote;

import com.openmind.hacadaptor.socket.xml.mode.common.IContext;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLBody;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by LiuBin on 2017/7/4.
 */
@XmlRootElement(name = "Document")
public class WorkNoteBackXMLBody extends XMLBody<IContext,WorkNoteBackContext> {

    WorkNoteBackContext context;
    @XmlElement(name = "Context")
    @Override
    public WorkNoteBackContext getBackContext() {
        return context;
    }
    @Override
    public void setBackContext(WorkNoteBackContext context) {
        this.context = context;
    }
}