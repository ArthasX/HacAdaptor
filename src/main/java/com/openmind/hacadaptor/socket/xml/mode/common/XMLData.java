package com.openmind.xml.mode.common;

import javax.xml.bind.JAXBException;
import java.nio.ByteBuffer;

/**
 * The completed xml data to be sent to HAC
 */
public class XMLData<T> {
    protected XMLHeader xmlHeader;
    protected XMLBody<T> xmlBody;

    public XMLHeader getXmlHeader() {
        return xmlHeader;
    }

    public void setXmlHeader(XMLHeader xmlHeader) {
        this.xmlHeader = xmlHeader;
    }

    public XMLBody getXmlBody() {
        return xmlBody;
    }

    public void setXmlBody(XMLBody xmlBody) {
        this.xmlBody = xmlBody;
    }

    public byte[] getBytes() {
        byte[] body = new byte[0];
        byte[] header = xmlHeader.getBytes();
        if (xmlBody != null) {
            try {
                body = XMLParser.Object2XML(xmlBody).getBytes();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            ByteBuffer byteBuffer = ByteBuffer.allocate(header.length + body.length);
            return byteBuffer.put(header).put(body).array();
        } else
            return header;
    }

}
