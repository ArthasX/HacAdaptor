package com.openmind.hacadaptor.socket.xml.mode.datafactory;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLData;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLHeader;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLType;

/**
 * Created by KJB-001064 on 2017/7/4.
 */
public class WorkNoteXMLDataFactory extends XMLDataFactory {


    public WorkNoteXMLDataFactory() {
        xmlHeader = XMLHeader.getPreparedHeader();
    }

    /**
     *
     * @param xmlSize 发送的XML数据byte长度
     */
    private void initWorkNoteSendHeader(int xmlSize){
        xmlHeader.setiXmlType(XMLType.XML_WN_CHANGE_DATA);
        xmlHeader.setiXmlSize(xmlSize);
    }
    private void initSetWorkNoteSendHeader(){

    }
    @Override
    public XMLData getXMLData() {
        return null;
    }
}
