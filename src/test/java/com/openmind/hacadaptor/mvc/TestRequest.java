package com.openmind.hacadaptor.mvc;

import com.alibaba.fastjson.JSON;
import com.openmind.hacadaptor.model.WorkNote;
import com.openmind.hacadaptor.util.ComUtil;
import org.junit.Test;

/**
 * @author LiuBin
 * @version Created on 2017/7/11
 */
public class TestRequest {

    @Test
    public void testRequest(){
        ComUtil.httpRequest("http://localhost:8080/hacadaptor/devices/1234","GET",null);
    }


    @Test
    public void testRequestBody(){
        WorkNote workNote = new WorkNote();
        workNote.setOperator("asd");
        workNote.setWorkNoteNumber("123");
        workNote.setReason("fuck");
        String s= JSON.toJSONString(workNote);
        ComUtil.httpRequest("http://localhost:8080/hacadaptor/worknote/worknote","POST",s);

    }

    @Test
    public void testRequestPara(){
        WorkNote workNote = new WorkNote();
        workNote.setOperator("asd");
        workNote.setWorkNoteNumber("123");
        workNote.setReason("fuck");
        String s= JSON.toJSONString(workNote);
        ComUtil.httpRequest("http://localhost:8080/hacadaptor/worknote/worknote1"
                ,"POST",s);

    }
}
