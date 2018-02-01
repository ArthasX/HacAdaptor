package com.openmind.hacadaptor.socket.xml.model.common;

import java.nio.ByteBuffer;

/**
 * The completed xml data template to be sent to HAC
 */
public class XMLData {
    protected XMLHeader xmlHeader;
    protected IXMLBody xmlBody;
    private byte[] bodyBytes;
    private byte[] headerBytes;
    private int xmlSize;

    public XMLHeader getXmlHeader() {
        return xmlHeader;
    }

    public void setXmlHeader(XMLHeader xmlHeader) {
        this.xmlHeader = xmlHeader;
        if(xmlBody!=null)
            xmlHeader.setiXmlSize(xmlBody.size());
    }

    public IXMLBody getXmlBody() {
        return xmlBody;
    }

    public void setXmlBody(IXMLBody xmlBody) {
        this.xmlBody = xmlBody;
        if(xmlBody!=null)
            xmlHeader.setiXmlSize(xmlBody.size());
//        if (xmlBody != null)
//            try {
//                bodyBytes = XMLParser.Object2XML(this.xmlBody).getBytes();
//                xmlSize = bodyBytes.length;
//                if (xmlHeader != null)
//                    xmlHeader.setiXmlSize(xmlSize);
//            } catch (JAXBException e) {
//                e.printStackTrace();
//            }
        bodyBytes=xmlBody.getBytes();
    }

    public byte[] getBytes() {
        byte[] header = xmlHeader.getBytes();
        if (xmlBody != null) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(header.length + bodyBytes.length);
            return byteBuffer.put(header).put(bodyBytes).array();
        } else
            return header;
    }

}
