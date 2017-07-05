package com.openmind.hacadaptor.socket.hacoperation;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLTransmitter;
import com.openmind.hacadaptor.socket.xml.mode.datafactory.WorkNoteXMLDataFactory;
import com.openmind.hacadaptor.socket.xml.mode.devices.Port;
import com.openmind.hacadaptor.socket.xml.mode.worknote.*;
import org.apache.log4j.Logger;

/**
 * Created by KJB-001064 on 2017/7/4.
 */
public class WorkNoteOperator implements IOperation {
    static Logger logger = Logger.getLogger(WorkNoteOperator.class);
    public static final int SUBMIT_WORK_NOTE = 0;
    public static final int SET_WORK_NOTE = 1;
    private XMLDTO xmldto;

    private String operator;
    private String workNoteNumber;
    private String startTime;
    private String endTime;
    private String reason;
    private Port[] port;
    private int operationType;

    /**
     *
     * @param workNoteNumber
     */
    public WorkNoteOperator(String workNoteNumber) {
        xmldto= new SetWorkNoteDTO();
        this.operationType = WorkNoteOperator.SET_WORK_NOTE;
    }

    /**
     *
     * @param operator
     * @param workNoteNumber
     * @param startTime
     * @param endTime
     * @param reason
     * @param port
     */
    public WorkNoteOperator(String operator, String workNoteNumber, String startTime, String endTime, String reason, Port... port) {
        xmldto= new WorkNoteDTO();
        this.operator = operator;
        this.workNoteNumber = workNoteNumber;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reason = reason;
        this.port = port;
        this.operationType = WorkNoteOperator.SUBMIT_WORK_NOTE;
    }

    public XMLDTO setWorkNoteStatus() {
        SetWorkNoteStatusXMLBody setWorkNoteStatusXMLBody = new SetWorkNoteStatusXMLBody();
        SetWorkNoteStatusSentXML setWorkNoteStatusSentXML = new SetWorkNoteStatusSentXML();
        setWorkNoteStatusSentXML.setWorkNoteNumber(workNoteNumber);
        setWorkNoteStatusXMLBody.setSentContext(setWorkNoteStatusSentXML);
        WorkNoteXMLDataFactory xmlDataFactory =
                new WorkNoteXMLDataFactory(operationType, setWorkNoteStatusXMLBody);
        xmldto.setXmlData(xmlDataFactory.getXMLData());
        xmldto = XMLTransmitter.trans(xmldto);
        return xmldto;
    }

    public XMLDTO submitWorkNote() {
        WorkNoteSentXMLBody workNoteSentXMLBody = new WorkNoteSentXMLBody();
        WorkNoteSentXML workNoteSentXML =
                new WorkNoteSentXML(operator, workNoteNumber, startTime, endTime, reason, port);
        workNoteSentXMLBody.setSentContext(workNoteSentXML);
        WorkNoteXMLDataFactory xmlDataFactory =
                new WorkNoteXMLDataFactory(operationType, workNoteSentXMLBody);
        xmldto.setXmlData(xmlDataFactory.getXMLData());
        xmldto = XMLTransmitter.trans(xmldto);
        return xmldto;
    }


    @Override
    public XMLDTO getXmldtoBack() {
        if (operationType == WorkNoteOperator.SUBMIT_WORK_NOTE)
            submitWorkNote();
        if (operationType == WorkNoteOperator.SET_WORK_NOTE)
            setWorkNoteStatus();
        return xmldto;
    }
}
