package com.openmind.hacadaptor.socket.xml.model.common;

/**
 * Created by LiuBin on 2017/7/4.
 */
public interface IXMLBody<S extends IContext,B extends IContext> {
    DocumentProperties getDocumentProperties();

    S getSentContext();
    void setSentContext(S sentContext);

    B getBackContext();
    void setBackContext(B backContext);

    byte[] getBytes();

    int size();
}
