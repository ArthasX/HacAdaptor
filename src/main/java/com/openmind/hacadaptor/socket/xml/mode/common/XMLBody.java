package com.openmind.hacadaptor.socket.xml.mode.common;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.lang.reflect.Field;

/**
 * Created by KJB-001064 on 2017/6/26.
 */
@XmlRootElement(name = "Document")
//@XmlType(name = "", propOrder = {"documentProperties", "backContext"})
public abstract class XMLBody<T extends IContext, B extends IContext> implements IXMLBody<T, B> {
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

    public void setDocumentProperties(DocumentProperties documentProperties) {
        this.documentProperties = documentProperties;
    }

    @XmlTransient
    @Override
    public T getSentContext() {
        return sentContext;
    }

    @Override
    public void setSentContext(T sentContext) {
        this.sentContext = sentContext;
    }

    @XmlTransient
    @Override
    public B getBackContext() {
        return backContext;
    }

    @Override
    public void setBackContext(B context) {
        this.backContext = context;
    }

    @Override
    public byte[] getBytes() {
//        Field[] fields=this.getClass().getDeclaredFields();
//        for(Field f:fields){
//            try {
//                f.get
//                f.getInt(this);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
        byte[] bytes = null;
        try {
            bytes = XMLParser.Object2XML(this).getBytes();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return bytes;
    }

}
