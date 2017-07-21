package com.openmind.hacadaptor.socket.xml.model.common;

/**
 * Created by LiuBin on 2017/7/4.
 */
public interface IXMLBody<T extends IContext,B extends IContext> {
    DocumentProperties getDocumentProperties();

    T getSentContext();
    void setSentContext(T sentContext);

    B getBackContext();
    void setBackContext(B backContext);

    byte[] getBytes();
}
