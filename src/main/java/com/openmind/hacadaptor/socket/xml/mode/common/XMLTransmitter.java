package com.openmind.hacadaptor.socket.xml.mode.common;

import com.openmind.hacadaptor.socket.socketutil.SocketUtil;

/**
 * Created by KJB-001064 on 2017/6/30.
 */
public class XMLTransmitter   {

    private XMLData xmlData;

    /**
     *
     * @param xmlData
     * @return hac返回的xml
     */
    public static byte[] trans(XMLData xmlData) {
        return SocketUtil.request(xmlData.getBytes());
    }

    public static byte[] trans(byte[] bytes){
        return SocketUtil.request(bytes);
    }

    public static<T extends  Context> XMLDTO<T> trans(XMLDTO<T> xmldto){
        return SocketUtil.request(xmldto);
    }
}
