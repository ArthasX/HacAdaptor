package com.openmind.hacadaptor.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.openmind.hacadaptor.mode.Account;
import com.openmind.hacadaptor.mode.Port;
import com.openmind.hacadaptor.mode.Result;
import com.openmind.hacadaptor.mode.WorkNote;
import com.openmind.hacadaptor.service.IWorkNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/7/10
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/worknote")
public class WorkNoteController {

    @Autowired
    private IWorkNoteService workNoteServiceImpl;

    /**
     * Set the status of the work note .
     * <p>
     * Be sure to check the (HAC)sessions of the work note and no session alive.
     * <p>
     * If there is one or more sessions alive, the work note will not be closed.
     *
     * @param workNoteNumber Just as the name
     * @return Result
     */
    @RequestMapping(value = "/worknotestatus/{workNoteNumber}", method = RequestMethod.PUT)
    @ResponseBody
    public Result setWorkNote(@PathVariable String workNoteNumber) {
        Result result = workNoteServiceImpl.setWorkNote(workNoteNumber);
        return result;
    }

    /**
     * Submit the normal work note. 常规变更
     *
     * @param jsonObject should be like this : {"workNote":{xxx},"groupname":["xxx"]}
     * @return Result
     */
    @RequestMapping(value = "/normal"
            , method = RequestMethod.POST
            , produces = {MediaType.TEXT_HTML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE
            , MediaType.APPLICATION_FORM_URLENCODED_VALUE}
            , consumes = {MediaType.TEXT_HTML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE
            , MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @ResponseBody
    public Result submitNormalWorkNote(@RequestBody JSONObject jsonObject) {
        WorkNote workNote = jsonObject.getJSONObject("workNote").toJavaObject(WorkNote.class);
        List<String> groupNames = jsonObject.getObject("groupname", ArrayList.class);
        Result result = workNoteServiceImpl.submitNormalWorkNote(workNote, groupNames);
        return result;
    }

    /**
     * Submit the emergent work note. 紧急变更
     *
     * @param jsonObject should be like this :
     *                   {"workNote":{xxx},"prot":[xxx,xxx],"account":[yy,yyy],"groupname":["xxx"]}
     * @return Result
     */
    @RequestMapping(value = "/emergent"
            , method = RequestMethod.POST
            , produces = {MediaType.TEXT_HTML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE
            , MediaType.APPLICATION_FORM_URLENCODED_VALUE}
            , consumes = {MediaType.TEXT_HTML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE
            , MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @ResponseBody
    public Result submitEmergentWorkNote(@RequestBody JSONObject jsonObject) {
        WorkNote workNote = jsonObject.getJSONObject("workNote").toJavaObject(WorkNote.class);
        JSONArray accountArray = jsonObject.getJSONArray("account");
        List<Account> accounts = accountArray.toJavaList(Account.class);
        JSONArray portArray = jsonObject.getJSONArray("port");
        List<Port> ports = portArray.toJavaList(Port.class);
        List<String> groupNames = jsonObject.getObject("groupname", ArrayList.class);
        Result result = workNoteServiceImpl.submitEmergentWorkNote(workNote, ports, accounts, groupNames);
        return result;
    }
//
//    @RequestMapping(value = "/worknote1"
//            ,method = RequestMethod.POST
//            )
//    @ResponseBody
//    public Result sentWorkNote1(@RequestBody SWorkNote workNote){
//        Result result=new Result();
//        result.setData(workNote);
//        return result;
//    }
}
