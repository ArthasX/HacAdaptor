package com.openmind.hacadaptor.socket.xml.mode.common;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by KJB-001064 on 2017/6/26.
 */
@XmlRootElement(name = "Document")
//@XmlType(name = "", propOrder = {"documentProperties", "backContext"})
public abstract class XMLBody<T,B> implements IXMLBody<T,B> {
    protected DocumentProperties documentProperties;
    protected T sentContext;
    protected B backContext;

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
    @XmlTransient
    public T getSentContext() {
        return sentContext;
    }

    @Override
    public void setSentContext(T sentContext) {

    }
    @XmlTransient
    public B getBackContext(){
        return backContext;
    }

    @Override
    public void setBackContext(B context) {
        this.backContext = context;
    }

    public void setDocumentProperties(DocumentProperties documentProperties) {
        this.documentProperties = documentProperties;
    }

}
