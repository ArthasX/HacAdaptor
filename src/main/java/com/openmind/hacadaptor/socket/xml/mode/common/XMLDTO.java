package com.openmind.hacadaptor.socket.xml.mode.common;

import com.openmind.hacadaptor.socket.xml.mode.devices.DeviceXML;

import javax.xml.bind.JAXBException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by KJB-001064 on 2017/7/3.
 */
public class XMLDTO<T extends Context> {
    private XMLData<T> xmlData;
    private byte[] xmlBodyBytes;
    private int resultCount;
    private boolean isSuccess = true;
    private int resultType;


    public XMLBody<T> getXmlBody() {
        return xmlData.getXmlBody();
    }

    public T getContext() {
        return xmlData.getXmlBody().getContext();
    }

    public XMLData getXmlData() {
        return xmlData;
    }

    public void setXmlData(XMLData<T> xmlData) {
        this.xmlData = xmlData;
    }

    public byte[] getXmlBodyBytes() {
        return xmlBodyBytes;
    }

    public void setXmlBodyBytes(byte[] xmlBodyBytes) {
        this.xmlBodyBytes = xmlBodyBytes;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public XMLBody<T> getResult() {
        if (xmlData.getXmlBody() == null) {
            try {
                Type genType=this.getClass().getGenericSuperclass();
                Type[] params=((ParameterizedType)genType).getActualTypeArguments();
                Class entityClass =(Class)params[0];
                XMLBody<T> resultXMLBody = new XMLBody<>();
                XMLParser.XML2Object(resultXMLBody, xmlBodyBytes);
                String resultC = resultXMLBody.getDocumentProperties().getNumber();
                if (resultC != null || !"".equals(resultC))
                    this.resultCount = Integer.parseInt(resultC);
                this.xmlData.setXmlBody(resultXMLBody);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return xmlData.getXmlBody();
    }

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getResultType() {
        return resultType;
    }

    public void setResultType(int resultType) {
        this.resultType = resultType;
        if (resultType == XMLType.XML_WN_REQUEST_ERROR)
            isSuccess = false;
    }
}
