package com.openmind.hacadaptor.socket;

import com.openmind.hacadaptor.socket.hacoperation.IOperation;
import com.openmind.hacadaptor.socket.hacoperation.WorkNoteOperator;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.mode.datafactory.WorkNoteXMLDataFactory;
import com.openmind.hacadaptor.socket.xml.mode.devices.Port;
import com.openmind.hacadaptor.socket.xml.mode.worknote.WorkNote;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by KJB-001064 on 2017/7/5.
 */
public class TestWorkNoteSocket {

    @Test
    public void testWorkNote(){
        Port p = new Port("4091",Arrays.asList("4123","4124"));
        IOperation iOperation=new WorkNoteOperator("slz","S20170701001"
                ,"2017-07-01D08:30:00T","2017-07-31D08:30:00T"
                ,"what the fuck",p);
        XMLDTO xmldto=iOperation.getXmldtoBack();
        Assert.assertNotNull(xmldto.getResult().getBackContext());
    }


    @Test
    public void testSetWorkNote(){
        IOperation iOperation=new WorkNoteOperator("S20170701001");
        XMLDTO xmldto=iOperation.getXmldtoBack();
        Assert.assertNotNull(xmldto);
    }
}
