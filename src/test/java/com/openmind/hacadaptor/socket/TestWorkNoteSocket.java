package com.openmind.hacadaptor.socket;

import com.openmind.hacadaptor.socket.hacoperation.IOperator;
import com.openmind.hacadaptor.socket.hacoperation.WorkNoteOperation;
import com.openmind.hacadaptor.socket.xml.model.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.model.devices.SPort;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by LiuBin on 2017/7/5.
 */
public class TestWorkNoteSocket {
    static Logger logger = Logger.getLogger(TestWorkNoteSocket.class);
    @Test
    public void testWorkNote(){
        logger.info("【开始】提交工单信息操作【开始】");
        SPort p = new SPort("10113",Arrays.asList("15247"));
        IOperator iOperator =new WorkNoteOperation("liubin,slz,hxc","S201707010179"
                ,"2017-09-05D08:30:01T","2018-07-31D08:30:00T"
                ,"what the fuck",p);
        XMLDTO xmldto= iOperator.getXmldtoBack();
        Assert.assertNotNull(xmldto.getResult().getBackContext());
        logger.info("【结束】提交工单信息操作【结束】");
    }


    @Test
    public void testSetWorkNote(){
        IOperator iOperator =new WorkNoteOperation("S201707010171");
        XMLDTO xmldto= iOperator.getXmldtoBack();
        System.out.println(xmldto.getErrorCode());
        Assert.assertNotNull(xmldto);
    }
}
