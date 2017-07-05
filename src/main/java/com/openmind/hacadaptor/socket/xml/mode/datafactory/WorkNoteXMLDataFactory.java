package com.openmind.hacadaptor.socket.xml.mode.datafactory;

import com.openmind.hacadaptor.socket.hacoperation.WorkNoteOperator;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLBody;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLData;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLHeader;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLType;

/**
 * Created by KJB-001064 on 2017/7/4.
 */
public class WorkNoteXMLDataFactory extends XMLDataFactory {


    public WorkNoteXMLDataFactory(int operationType, XMLBody body) {
        xmlBody = body;
        switch (operationType) {
            case WorkNoteOperator.SUBMIT_WORK_NOTE:
                initSubmitWorkNoteSendHeader();
                break;
            case WorkNoteOperator.SET_WORK_NOTE:
                initSetWorkNoteSendHeader();
                break;
        }
    }


    private void initSubmitWorkNoteSendHeader() {
        xmlHeader = XMLHeader.getPreparedHeader(XMLType.XML_WN_CHANGE_DATA);
    }

    private void initSetWorkNoteSendHeader() {
        xmlHeader = XMLHeader.getPreparedHeader(XMLType.XML_WN_SET_END);
    }

    @Override
    public XMLData getXMLData() {
        XMLData xmlData = new XMLData();
        xmlData.setXmlHeader(xmlHeader);
        xmlData.setXmlBody(xmlBody);
        return xmlData;
    }


}
