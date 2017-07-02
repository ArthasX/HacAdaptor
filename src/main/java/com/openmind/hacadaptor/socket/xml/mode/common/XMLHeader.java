package com.openmind.xml.mode.common;


import com.openmind.util.ArrayUtil;
import com.openmind.util.ByteUtil;

import java.nio.ByteBuffer;
import java.util.ResourceBundle;

/**
 * Created by KJB-001064 on 2017/6/26.
 */
public class XMLHeader {
    private String sToken;
    private int iXmlType;
    private int iXmlSize;

    public String getsToken() {
        return sToken;
    }

    public void setsToken(String sToken) {
        this.sToken = sToken;
    }

    public int getiXmlType() {
        return iXmlType;
    }

    public void setiXmlType(int iXmlType) {
        this.iXmlType = iXmlType;
    }

    public int getiXmlSize() {
        return iXmlSize;
    }

    public void setiXmlSize(int iXmlSize) {
        this.iXmlSize = iXmlSize;
    }

    public static XMLHeader getPreparedHeader() {
        XMLHeader xmlHeader = new XMLHeader();
        xmlHeader.setsToken(ResourceBundle.getBundle("setting").getString("token"));
        return xmlHeader;
    }

    public byte[] getBytes() {
        byte[] token=sToken.getBytes();
        byte[] xmlType=ByteUtil.intToByteArray(iXmlType);
        byte[] xmlSize=ByteUtil.intToByteArray(iXmlSize);

        ByteBuffer byteBuffer=ByteBuffer.allocate(20);
        byteBuffer.put(token).put(xmlType).put(xmlSize);
        return byteBuffer.array();
    }
}

