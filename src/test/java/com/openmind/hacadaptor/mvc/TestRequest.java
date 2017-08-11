package com.openmind.hacadaptor.mvc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.openmind.hacadaptor.model.WorkNote;
import com.openmind.hacadaptor.util.ComUtil;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/7/11
 */
public class TestRequest {

    @Test
    public void testRequest() {
        try {
            String s = URLEncoder.encode("核心账务系统", "UTF-8");
            ComUtil.httpRequest("http://localhost:8080/hacadaptor/devices/group/"+s, "GET", null);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testRequestBody() {
        WorkNote workNote = new WorkNote();
        workNote.setWorkNoteNumber("S20170701018");
        workNote.setOperator("001064,001000");
        workNote.setReason("fuck");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'D'HH:mm:ss'T'");
        workNote.setStartTime(sdf.format(new Date()));
        workNote.setEndTime(sdf.format(new Date()));
        List<String> groupNames = new ArrayList<>();
        groupNames.add("核心账务系统");
        JSONObject jjj = new JSONObject();
        jjj.put("groupname", groupNames);
        jjj.put("workNote", workNote);
        ComUtil.httpRequest("http://localhost:8080/hacadaptor/worknote/normal", "POST", jjj.toJSONString());

    }

    @Test
    public void testRequestPara() {
        WorkNote workNote = new WorkNote();
        workNote.setWorkNoteNumber("S20170701018");
        workNote.setOperator("001064,001000");
        workNote.setReason("fuck");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        workNote.setStartTime(sdf.format(new Date()));
        workNote.setEndTime(sdf.format(new Date()));
        List<String> groupNames = new ArrayList<>();
        groupNames.add("核心账务系统");
        JSONObject jjj = new JSONObject();
        jjj.put("groupname", groupNames);
        jjj.put("workNote", workNote);
        ComUtil.httpRequest("http://localhost:8080/hacadaptor/worknote/emergent"
                , "POST", jjj.toJSONString());

    }
}
