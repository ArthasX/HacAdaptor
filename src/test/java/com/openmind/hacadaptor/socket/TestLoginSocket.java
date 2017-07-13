package com.openmind.hacadaptor.socket;

import com.openmind.hacadaptor.socket.hacoperation.IOperator;
import com.openmind.hacadaptor.socket.hacoperation.LoginOperator;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author LiuBin
 * @version Created on 2017/7/6
 */
public class TestLoginSocket {
    @Test
    public void testLogin(){
        IOperator iOperator =new LoginOperator();
        iOperator.getXmldtoBack().getResult().getBackContext().getContextDetail();
        XMLDTO xmldto= iOperator.getXmldtoBack();
        Class c= xmldto.getResult().getClass();
        System.out.println("xmldto.getResult().getClass()"+c);
        c=xmldto.getResult().getBackContext().getClass();
        System.out.println("xmldto.getResult().getBackContext().getClass()"+c);
        c=xmldto.getResult().getBackContext().getContextDetail().getClass();
        System.out.println("xmldto.getResult().getBackContext().getContextDetail().getClass()"+c);
        System.out.println(c.getTypeParameters()[0].getGenericDeclaration());
        Assert.assertNotNull(xmldto.getResult().getBackContext());
    }
}
