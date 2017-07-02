package com.openmind.xml.mode.datafactory;

import com.openmind.xml.mode.common.XMLBody;
import com.openmind.xml.mode.common.XMLHeader;

/**
 * Created by KJB-001064 on 2017/6/28.
 */
abstract class XMLDataFactory implements IMake {
    protected XMLHeader xmlHeader;
    protected XMLBody xmlBody;

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
}
