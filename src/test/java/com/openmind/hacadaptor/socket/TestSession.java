package com.openmind.hacadaptor.socket;

import com.openmind.hacadaptor.socket.hacoperation.IOperation;
import com.openmind.hacadaptor.socket.hacoperation.SessionOperator;
import com.openmind.hacadaptor.socket.xml.mode.session.Session;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/7/6
 */
public class TestSession {

    @Test
    public void testSession(){
        IOperation operation=new SessionOperator("123123123");
        List<Session> sessions=(List<Session>) operation.getXmldtoBack().getResult().getBackContext().getContextDetail();
        Assert.assertEquals(2,sessions.size());
    }
}
