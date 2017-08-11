package com.openmind.hacadaptor.socket.xml.model.datafactory;

import com.openmind.hacadaptor.socket.hacoperation.WorkNoteOperation;
import com.openmind.hacadaptor.socket.xml.model.common.XMLBody;
import com.openmind.hacadaptor.socket.xml.model.common.XMLData;
import com.openmind.hacadaptor.socket.xml.model.common.XMLHeader;
import com.openmind.hacadaptor.socket.xml.model.common.XMLType;
import com.openmind.hacadaptor.socket.xml.model.devices.SPort;
import com.openmind.hacadaptor.socket.xml.model.worknote.WorkNoteStatusSentContext;
import com.openmind.hacadaptor.socket.xml.model.worknote.WorkNoteStatusXMLBody;
import com.openmind.hacadaptor.socket.xml.model.worknote.WorkNoteSentContext;
import com.openmind.hacadaptor.socket.xml.model.worknote.WorkNoteSentXMLBody;

import java.util.List;

/**
 * Created by LiuBin on 2017/7/4.
 */
public class WorkNoteXMLDataFactory extends XMLDataFactory {


    public WorkNoteXMLDataFactory(int operationType, XMLBody body) {
        init(operationType, body);
    }

    /**
     * 关闭工单用
     * @param operationType
     * @param workNoteNumber
     */
    public WorkNoteXMLDataFactory(int operationType, String workNoteNumber) {
        WorkNoteStatusXMLBody workNoteStatusXMLBody = new WorkNoteStatusXMLBody();
        WorkNoteStatusSentContext workNoteStatusSentContext = new WorkNoteStatusSentContext();
        workNoteStatusSentContext.setWorkNoteNumber(workNoteNumber);
        workNoteStatusXMLBody.setSentContext(workNoteStatusSentContext);
        init(operationType, workNoteStatusXMLBody);
    }

    /**
     * 提交工单用
     * @param operationType
     * @param operator
     * @param workNoteNumber
     * @param startTime
     * @param endTime
     * @param reason
     * @param SPort
     */
    public WorkNoteXMLDataFactory(int operationType
            , List<String> operator, String workNoteNumber
            , String startTime, String endTime, String reason, SPort... SPort) {
        WorkNoteSentXMLBody workNoteSentXMLBody = new WorkNoteSentXMLBody();
        WorkNoteSentContext workNoteSentContext =
                new WorkNoteSentContext(operator, workNoteNumber, startTime, endTime, reason, SPort);
        workNoteSentXMLBody.setSentContext(workNoteSentContext);
        init(operationType, workNoteSentXMLBody);
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
            case WorkNoteOperation.SUBMIT_WORK_NOTE:
                initSubmitWorkNoteSendHeader();
                break;
            case WorkNoteOperation.SET_WORK_NOTE:
                initSetWorkNoteSendHeader();
                break;
        }
        xmlData.setXmlHeader(xmlHeader);
        xmlData.setXmlBody(xmlBody);
    }

}
