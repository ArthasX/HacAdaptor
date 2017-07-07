package com.openmind.hacadaptor.socket.hacoperation;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLTransmitter;
import com.openmind.hacadaptor.socket.xml.mode.datafactory.WorkNoteXMLDataFactory;
import com.openmind.hacadaptor.socket.xml.mode.devices.Port;
import com.openmind.hacadaptor.socket.xml.mode.worknote.WorkNoteStatusDTO;
import com.openmind.hacadaptor.socket.xml.mode.worknote.WorkNoteDTO;
import org.apache.log4j.Logger;

/**
 * Created by LiuBin on 2017/7/4.
 */
public class WorkNoteOperator extends BaseOperation {
    static Logger logger = Logger.getLogger(WorkNoteOperator.class);
    public static final int SUBMIT_WORK_NOTE = 0;
    public static final int SET_WORK_NOTE = 1;
    private XMLDTO xmldto;

    /**
     * 设置工单状态为结束。需要先判断是否存在与工单关联的在线操作会话（session）
     * 如果存在，需要先结束这些session
     *
     * @param workNoteNumber
     */
    public WorkNoteOperator(String workNoteNumber) {
        xmldto = new WorkNoteStatusDTO();
        WorkNoteXMLDataFactory workNoteXMLDataFactory =
                new WorkNoteXMLDataFactory(SET_WORK_NOTE, workNoteNumber);
        xmldto.setXmlData(workNoteXMLDataFactory.getXMLData());
        xmldto = XMLTransmitter.trans(xmldto);
    }

    /**
     * @param operator
     * @param workNoteNumber
     * @param startTime
     * @param endTime
     * @param reason
     * @param port
     */
    public WorkNoteOperator(String operator, String workNoteNumber, String startTime, String endTime, String reason, Port... port) {
        xmldto = new WorkNoteDTO();
        WorkNoteXMLDataFactory workNoteXMLDataFactory =
                new WorkNoteXMLDataFactory(SUBMIT_WORK_NOTE
                        , operator, workNoteNumber, startTime, endTime, reason, port);
        xmldto.setXmlData(workNoteXMLDataFactory.getXMLData());
        xmldto = XMLTransmitter.trans(xmldto);
    }

    @Override
    public XMLDTO getXmldtoBack() {
        return xmldto;
    }
//    public XMLDTO setWorkNoteStatus() {
//        WorkNoteStatusXMLBody setWorkNoteStatusXMLBody = new WorkNoteStatusXMLBody();
//        WorkNoteStatusSentContext setWorkNoteStatusSentXML = new WorkNoteStatusSentContext();
//        setWorkNoteStatusSentXML.setWorkNoteNumber(workNoteNumber);
//        setWorkNoteStatusXMLBody.setSentContext(setWorkNoteStatusSentXML);
//        WorkNoteXMLDataFactory xmlDataFactory =
//                new WorkNoteXMLDataFactory(operationType, setWorkNoteStatusXMLBody);
//        xmldto.setXmlData(xmlDataFactory.getXMLData());
//        xmldto = XMLTransmitter.trans(xmldto);
//        return xmldto;
//    }
//
//    public XMLDTO submitWorkNote() {
//        logger.info("初始化变更工单信息");
//        logger.info("操作员:" + operator);
//        logger.info("提交工单:" + workNoteNumber);
//        logger.info("开始时间:" + startTime);
//        logger.info("结束时间:" + endTime);
//        logger.info("变更原因:" + reason);
//        WorkNoteSentXMLBody workNoteSentXMLBody = new WorkNoteSentXMLBody();
//        WorkNoteSentContext workNoteSentXML =
//                new WorkNoteSentContext(operator, workNoteNumber, startTime, endTime, reason, port);
//        workNoteSentXMLBody.setSentContext(workNoteSentXML);
//        WorkNoteXMLDataFactory xmlDataFactory =
//                new WorkNoteXMLDataFactory(operationType, workNoteSentXMLBody);
//        xmldto.setXmlData(xmlDataFactory.getXMLData());
//        xmldto = XMLTransmitter.trans(xmldto);
//        return xmldto;
//    }


}
