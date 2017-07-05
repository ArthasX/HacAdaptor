package com.openmind.hacadaptor.socket.xml.mode.common;

/**
 * Created by KJB-001064 on 2017/7/4.
 */
public interface IXMLBody<T,B> {
    DocumentProperties getDocumentProperties();

    T getSentContext();
    void setSentContext(T sentContext);

    B getBackContext();
    void setBackContext(B backContext);

    byte[] getBytes();
}
