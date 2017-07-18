package com.openmind.hacadaptor.socket.xml.mode.common;

import com.openmind.hacadaptor.socket.util.ClassUtil;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBException;

/**
 * @param <T> XMLDataBody
 */
public class XMLDTO<T, B> implements BaseDTO<T, B> {
    static Logger logger = Logger.getLogger(XMLDTO.class);
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
        if (resultType == XMLType.XML_WN_REQUEST_ERROR) {
            errorCode = 2;
            errorMessage="HAC服务器端处理失败";
        }
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

    @SuppressWarnings("unchecked")
    public void setXmlBodyBytesBack(byte[] xmlBodyBytesBack) {
        this.xmlBodyBytesBack = xmlBodyBytesBack;
        if (xmlBodyBytesBack != null && xmlBodyBytesBack.length > 0) {
            Class<B> tClass = (Class<B>) ClassUtil.getSuperClassGenricType(getClass(), 1);
            logger.info("start to parse xml to object ["+tClass.getSimpleName()+"]");
            try {
                IXMLBody xmlBody = (IXMLBody) XMLParser.XML2Object(tClass, xmlBodyBytesBack);
                String resultC = xmlBody.getDocumentProperties().getNumber();
                if (resultC != null || !"".equals(resultC))
                    this.resultCount = Integer.parseInt(resultC);
                this.xmlDataBack.setXmlBody(xmlBody);
                logger.info("result count:"+resultCount);
            } catch (JAXBException e) {
                e.printStackTrace();
                errorCode = 1;
                errorMessage = "[" + this.getClass().getName() + "]XML to JavaBean error :" + tClass.getName();
                logger.error(errorMessage);
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

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public XMLData getXmlDataBack() {
        return xmlDataBack;
    }

    public void setXmlDataBack(XMLData xmlDataBack) {
        this.xmlDataBack = xmlDataBack;
    }
}
