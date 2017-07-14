package com.openmind.hacadaptor.socket.xml.mode.datafactory;

import com.openmind.hacadaptor.socket.hacoperation.WorkNoteOperator;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLBody;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLData;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLHeader;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLType;
import com.openmind.hacadaptor.socket.xml.mode.devices.SPort;
import com.openmind.hacadaptor.socket.xml.mode.worknote.WorkNoteStatusSentContext;
import com.openmind.hacadaptor.socket.xml.mode.worknote.WorkNoteStatusXMLBody;
import com.openmind.hacadaptor.socket.xml.mode.worknote.WorkNoteSentContext;
import com.openmind.hacadaptor.socket.xml.mode.worknote.WorkNoteSentXMLBody;

/**
 * Created by LiuBin on 2017/7/4.
 */
public class WorkNoteXMLDataFactory extends XMLDataFactory {


    public WorkNoteXMLDataFactory(int operationType, XMLBody body) {
        init(operationType, body);
    }

    public WorkNoteXMLDataFactory(int operationType, String workNoteNumber) {
        WorkNoteStatusXMLBody workNoteStatusXMLBody = new WorkNoteStatusXMLBody();
        WorkNoteStatusSentContext workNoteStatusSentContext = new WorkNoteStatusSentContext();
        workNoteStatusSentContext.setWorkNoteNumber(workNoteNumber);
        workNoteStatusXMLBody.setSentContext(workNoteStatusSentContext);
        init(operationType, workNoteStatusXMLBody);
    }

    public WorkNoteXMLDataFactory(int operationType
            , String operator, String workNoteNumber
            , String startTime, String endTime, String reason, SPort... SPort) {
        WorkNoteSentXMLBody workNoteSentXMLBody = new WorkNoteSentXMLBody();
        WorkNoteSentContext workNoteSentContext =
                new WorkNoteSentContext(operator, workNoteNumber, startTime, endTime, reason, SPort);
        workNoteSentXMLBody.setSentContext(workNoteSentContext);
        init(operationType, workNoteSentXMLBody);
    }


    private void initSubmitWorkNoteSendHeader() {
        xmlHeader = XMLHeader.getPreparedHeader(XMLType.XML_WN_CHANGE_DATA);
    }

    private void initSetWorkNoteSendHeader() {
        xmlHeader = XMLHeader.getPreparedHeader(XMLType.XML_WN_SET_END);
    }

    //    @Override
//    public XMLData getXMLData() {
//        return xmlData;
//    }
    private void init(int operationType, XMLBody body) {
        xmlData = new XMLData();
        xmlBody = body;
        switch (operationType) {
            case WorkNoteOperator.SUBMIT_WORK_NOTE:
                initSubmitWorkNoteSendHeader();
                break;
            case WorkNoteOperator.SET_WORK_NOTE:
                initSetWorkNoteSendHeader();
                break;
        }
        xmlData.setXmlHeader(xmlHeader);
        xmlData.setXmlBody(xmlBody);
    }

}
