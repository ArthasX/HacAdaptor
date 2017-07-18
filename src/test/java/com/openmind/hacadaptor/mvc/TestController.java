package com.openmind.hacadaptor.mvc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.openmind.hacadaptor.mode.Device;
import com.openmind.hacadaptor.mode.WorkNote;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * Created by LiuBin on 2017/6/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-mybatis.xml"})
public class TestController {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void before() {
        this.mockMvc = webAppContextSetup(wac).build();
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/devices/1234")).andExpect(status().isOk()).andDo(print());
    }


    @Test
    public void testDevices() throws Exception {
        mockMvc.perform(get("/devices/")).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void testDevicePost() throws Exception {
        Device device = new Device();
        device.setDeviceId("1234");
        String json = JSON.toJSONString(device);
        Object j = JSON.toJSON(device);
        System.out.println(json);
        mockMvc.perform(post("/devices/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .param("device", json))
                .andDo(print());
    }


    @Test
    public void testWorkNoteStatus() throws Exception {
        String url = "/worknote/worknotestatus/1234";
        System.out.println(url);
        mockMvc.perform(put(url))
                //.param("workNoteNumber", "12345"))
                .andExpect(status().isOk())
                .andDo(print());


    }

    @Test
    public void testUpdateDeviceFromHac() throws Exception {
        String url = "/devices/updateDevices";
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    public void testSubmitNormalWorkNote() throws Exception {
        String url = "/worknote/normal";
        WorkNote workNote = new WorkNote();
        workNote.setOperator("slz");
        workNote.setReason("fuck");
        String json = JSON.toJSONString(workNote);
        Object j = JSON.toJSON(workNote);
        String json1 = JSON.toJSONString("123456");
        System.out.println(json);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("groupId","123456");
        String groupId=jsonObject.toJSONString();
//        String groupId="{\"groupId\":\"12345\"}";
        JSONObject jjj=new JSONObject();
        jjj.put("groupId","123455");
        jjj.put("workNote",workNote);
        System.out.println("test :"+groupId);
        System.out.println("test :"+jjj.toString());
        mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jjj.toJSONString())
//                .content(groupId)
                .accept(MediaType.APPLICATION_JSON))
                //.andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testSubmiEmergentWorkNote() throws Exception {
        String url = "/worknote/emergent";
        WorkNote workNote = new WorkNote();
        workNote.setOperator("slz");
        workNote.setReason("fuck");
        String json = JSON.toJSONString(workNote);
        Object j = JSON.toJSON(workNote);
        String json1 = JSON.toJSONString("123456");
        System.out.println(json);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("groupId","123456");
        String groupId=jsonObject.toJSONString();
//        String groupId="{\"groupId\":\"12345\"}";
        JSONObject jjj=new JSONObject();
        jjj.put("groupId","123455");
        jjj.put("workNote",workNote);
        System.out.println("test :"+groupId);
        System.out.println("test :"+jjj.toString());
        mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jjj.toJSONString())
//                .content(groupId)
                .accept(MediaType.APPLICATION_JSON))
                //.andExpect(status().isOk())
                .andDo(print());
    }
}
