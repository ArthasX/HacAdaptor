package com.openmind.hacadaptor.socket;

import com.openmind.hacadaptor.socket.hacoperation.IOperation;
import com.openmind.hacadaptor.socket.hacoperation.WorkNoteOperator;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.mode.devices.Port;
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
        Port p = new Port("4091",Arrays.asList("4123","4124"));
        IOperation iOperation=new WorkNoteOperator("slz","S20170701001"
                ,"2017-07-01D08:30:00T","2017-07-31D08:30:00T"
                ,"what the fuck",p);
        XMLDTO xmldto=iOperation.getXmldtoBack();
        Assert.assertNotNull(xmldto.getResult().getBackContext());
        logger.info("【结束】提交工单信息操作【结束】");
    }


    @Test
    public void testSetWorkNote(){
        IOperation iOperation=new WorkNoteOperator("S20170701001");
        XMLDTO xmldto=iOperation.getXmldtoBack();
        Assert.assertNotNull(xmldto);
    }
}
