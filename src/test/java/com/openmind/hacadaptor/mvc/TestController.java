package com.openmind.hacadaptor.mvc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.openmind.hacadaptor.model.Account;
import com.openmind.hacadaptor.model.Device;
import com.openmind.hacadaptor.model.Port;
import com.openmind.hacadaptor.model.WorkNote;
import com.openmind.hacadaptor.socket.xml.model.devices.SPort;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        String url = "/worknote/worknotestatus/CXXXXXXXX1";
        System.out.println(url);
        mockMvc.perform(put(url))
                //.param("workNoteNumber", "12345"))
                .andExpect(status().isOk())
                .andDo(print());


    }

    @Test
    public void testUpdateDeviceFromHac() throws Exception {
        String url = "/devices/refreshDevices";
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    public void testSubmitNormalWorkNote() throws Exception {
        String url = "/worknote/normal";
        WorkNote workNote = new WorkNote();
        workNote.setWorkNoteNumber("CXXXXXXXX");
        workNote.setOperator("001064");
        workNote.setReason("fuck");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'D'HH:mm:ss'T'");
        workNote.setStartTime(sdf.format(new Date()));
        workNote.setEndTime(sdf.format(new Date()));
        List<String> groupNames = new ArrayList<>();
        groupNames.add("核心系统");
        JSONObject jjj = new JSONObject();
        jjj.put("groupname", groupNames);
        jjj.put("workNote", workNote);
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
        workNote.setWorkNoteNumber("CXXXXXXXX");
        workNote.setOperator("001064");
        workNote.setReason("fuck");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'D'HH:mm:ss'T'");
        workNote.setStartTime(sdf.format(new Date()));
        workNote.setEndTime(sdf.format(new Date()));
        List<String> groupNames = new ArrayList<>();
        groupNames.add("核心系统");
        List<String> accountId = new ArrayList<>();
        accountId.add("12345");
        SPort sPort = new SPort();
        sPort.setPortId("1");
//        sPort.setAccountId(accountId);
        List<SPort> ports = new ArrayList<>();
        ports.add(sPort);

//        JSON json = JSON.parseObject();
        JSONObject jjj = new JSONObject();
        jjj.put("groupname", groupNames);
        jjj.put("workNote", workNote);
        jjj.put("port", ports);
        mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jjj.toJSONString())
//                .content(groupId)
                .accept(MediaType.APPLICATION_JSON))
                //.andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testJson() {
        WorkNote workNote = new WorkNote();
        workNote.setWorkNoteNumber("CXXXXXXXX");
        workNote.setOperator("slz");
        workNote.setReason("fuck");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'D'hh:mm:ss'T'");
        workNote.setStartTime(sdf.format(new Date()));
        workNote.setEndTime(sdf.format(new Date()));
        List<String> groupNames = new ArrayList<>();
        groupNames.add("核心系统");
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setAccountId("1");
        accounts.add(account);
        Port port = new Port();
        port.setPortId("1");
        List<Port> ports = new ArrayList<>();
        ports.add(port);
//        JSON json = JSON.parseObject();
        JSONObject jjj = new JSONObject();
        jjj.put("groupname", groupNames);
        jjj.put("workNote", workNote);
        jjj.put("account", accounts);
        jjj.put("port", ports);

        String j = jjj.toJSONString();
        JSONObject jsonObject = JSON.parseObject(j);

        JSONArray jsonArray = jsonObject.getJSONArray("account");
        List<Account> accounts2 = jsonArray.toJavaList(Account.class);
        List<Account> accounts1 = JSONObject.parseArray(jsonArray.toJSONString(), Account.class);
        System.out.println();
    }

    @Test
    public void testDeviceWithPortAccount() throws Exception {
        String url = "/devices/group/核心系统";
        mockMvc.perform(get(url).characterEncoding("UTF-8"))

                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    public void testGetNewDevices()throws Exception {
        String url = "/devices/3/group/1";
        mockMvc.perform(put(url).characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testSetGroup() throws  Exception{
        String url = "/devices/new";
        mockMvc.perform(put(url)
                .characterEncoding("UTF-8")
        )
                .andExpect(status().isOk())
                .andDo(print());
    }
}
