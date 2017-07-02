package com.openmind.xml.mode.common;

import com.openmind.socketutil.SocketUtil;

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

    public static String trans(XMLData xmlData) {
        return SocketUtil.request(xmlData.getBytes());
    }
}
