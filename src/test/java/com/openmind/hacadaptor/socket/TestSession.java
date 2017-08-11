package com.openmind.hacadaptor.socket;

import com.openmind.hacadaptor.socket.hacoperation.IOperator;
import com.openmind.hacadaptor.socket.hacoperation.SessionOperation;
import com.openmind.hacadaptor.socket.xml.model.session.SSession;
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
        IOperator operation=new SessionOperation("123123123");
        List<SSession> sessions=(List<SSession>) operation.getXmldtoBack().getResult().getBackContext().getContextDetail();
//        System.out.println(sessions.get(0).getSessionId());
        Assert.assertEquals(2,sessions.size());
    }
}
