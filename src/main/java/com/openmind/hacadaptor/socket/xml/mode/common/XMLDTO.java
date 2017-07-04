package com.openmind.hacadaptor.socket.xml.mode.common;

import com.openmind.hacadaptor.socket.util.ClassUtil;

import javax.xml.bind.JAXBException;

/**
 *
 * @param <T> XMLDataBody
 */
public class XMLDTO<T,B> implements BaseDTO<T,B> {
    private XMLData xmlData;
    private XMLData xmlDataBack;
    private byte[] xmlBodyBytesBack;
    private byte[] xmlHeaderBytesBack;
    private int resultCount = 0;
    private int resultType;
    private int errorCode = 0;
    private String errorMessage = "";

    public XMLDTO() {
        xmlDataBack = new XMLData();
    }

    public IXMLBody getResult() {
        return xmlDataBack.getXmlBody();
    }

    private void setResultType(int resultType) {
        this.resultType = resultType;
        if (resultType == XMLType.XML_WN_REQUEST_ERROR)
            errorCode = 1;
    }

    public XMLData getXmlData() {
        return xmlData;
    }

    public void setXmlData(XMLData xmlData) {
        this.xmlData = xmlData;
    }

    public byte[] getXmlBodyBytesBack() {
        return xmlBodyBytesBack;
    }

    public void setXmlBodyBytesBack(byte[] xmlBodyBytesBack) {
        this.xmlBodyBytesBack = xmlBodyBytesBack;
        if (xmlBodyBytesBack != null) {
            Class<B> tClass = (Class<B>) ClassUtil.getSuperClassGenricType(getClass(), 1);
            try {
                IXMLBody xmlBody = (IXMLBody) XMLParser.XML2Object(tClass, xmlBodyBytesBack);
                String resultC = xmlBody.getDocumentProperties().getNumber();
                if (resultC != null || !"".equals(resultC))
                    this.resultCount = Integer.parseInt(resultC);
                this.xmlDataBack.setXmlBody(xmlBody);
            } catch (JAXBException e) {
                e.printStackTrace();
                errorCode = 1;
                errorMessage = "XML to JavaBean error";
            }
        }
    }

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public int getResultType() {
        return resultType;
    }

    public byte[] getXmlHeaderBytesBack() {
        return xmlHeaderBytesBack;
    }

    public void setXmlHeaderBytesBack(byte[] xmlHeaderBytesBack) {
        this.xmlHeaderBytesBack = xmlHeaderBytesBack;
        this.xmlDataBack.setXmlHeader(XMLHeader.HeaderBytes2Object(xmlHeaderBytesBack));
        setResultType(this.xmlDataBack.getXmlHeader().getiXmlType());
    }
}
