package com.openmind.hacadaptor.socket.xml.mode.common;


import com.openmind.hacadaptor.socket.util.ByteUtil;

import java.nio.ByteBuffer;
import java.util.ResourceBundle;

import static com.openmind.hacadaptor.socket.util.ByteUtil.getSubBytes;

/**
 * Created by LiuBin on 2017/6/26.
 */
public class XMLHeader {
    private String sToken;
    private int iXmlType;
    private int iXmlSize;

    public XMLHeader() {
        ;
    }

    public XMLHeader(String sToken, int iXmlType, int iXmlSize) {
        this.sToken = sToken;
        this.iXmlType = iXmlType;
        this.iXmlSize = iXmlSize;
    }

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
    public static XMLHeader getPreparedHeader(int xmlType) {
        XMLHeader xmlHeader = new XMLHeader();
        xmlHeader.setsToken(ResourceBundle.getBundle("setting").getString("token"));
        xmlHeader.setiXmlType(xmlType);
        return xmlHeader;
    }

    public byte[] getBytes() {
        byte[] token = sToken.getBytes();
        byte[] xmlType = ByteUtil.intToByteArray(iXmlType);
        byte[] xmlSize = ByteUtil.intToByteArray(iXmlSize);

        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
        byteBuffer.put(token).put(xmlType).put(xmlSize);
        return byteBuffer.array();
    }

    public static XMLHeader HeaderBytes2Object(byte[] bytes) {
        String token = new String(getSubBytes(bytes, 0, 12));
        int xmlType = ByteUtil.byteArrayToInt(getSubBytes(bytes, 12, 4));
        int xmlSize = ByteUtil.byteArrayToInt(getSubBytes(bytes, 16, 4));
        return new XMLHeader(token, xmlType, xmlSize);
    }
}

