package com.openmind.hacadaptor.socket.xml.model.common;

import com.openmind.hacadaptor.socket.socketutil.SocketUtil;
import org.apache.log4j.Logger;

/**
 * Created by LiuBin on 2017/6/30.
 */
public class XMLTransmitter {
    static Logger logger = Logger.getLogger(XMLTransmitter.class);
    private XMLData xmlData;

    /**
     * @param xmlData
     * @return hac返回的xml
     */
    public static byte[] trans(XMLData xmlData) {
        return SocketUtil.request(xmlData.getBytes());
    }

    public static byte[] trans(byte[] bytes) {
        return SocketUtil.request(bytes);
    }

    public static XMLDTO trans(XMLDTO xmldto) {
        logger.info(new String(xmldto.getXmlData().getBytes()));
        return SocketUtil.request(xmldto);
    }
}
