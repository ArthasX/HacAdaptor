package com.openmind.hacadaptor.socket.xml.mode.datafactory;

import com.openmind.hacadaptor.socket.xml.mode.common.IXMLBody;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLData;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLHeader;

/**
 * Created by LiuBin on 2017/6/28.
 */
public abstract class XMLDataFactory implements IMake {
    protected XMLHeader xmlHeader;
    protected IXMLBody xmlBody;
    protected XMLData xmlData;
    public XMLHeader getXmlHeader() {
        return xmlHeader;
    }

    public void setXmlHeader(XMLHeader xmlHeader) {
        this.xmlHeader = xmlHeader;
    }

    public IXMLBody getXmlBody() {
        return xmlBody;
    }

    public void setXmlBody(IXMLBody xmlBody) {
        this.xmlBody = xmlBody;
    }

    public  XMLData getXMLData(){
        return xmlData;
    }

//    public abstract XMLData getXMLData(int xmlSize) ;
}
