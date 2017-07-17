package com.openmind.hacadaptor.controller;

import com.alibaba.fastjson.JSON;
import com.openmind.hacadaptor.mode.Account;
import com.openmind.hacadaptor.mode.Port;
import com.openmind.hacadaptor.mode.Result;
import com.openmind.hacadaptor.mode.WorkNote;
import com.openmind.hacadaptor.service.BaseServiceImp;
import com.openmind.hacadaptor.service.IWorkNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/7/10
 */
@RestController
@RequestMapping("/worknote")
public class WorkNoteCotroller {

    @Autowired
    private IWorkNoteService workNoteServiceImpl;

    //设置工单状态
    @RequestMapping(value = "/wornotestatus/{workNoteNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Result setWorkNote(@PathVariable String workNoteNumber) {
        Result result = workNoteServiceImpl.setWorkNote(workNoteNumber);
        System.out.println(result);
        return result;
    }

    //提交工单
    @RequestMapping(value = "/normal"
            , method = RequestMethod.POST
            , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE
            , MediaType.APPLICATION_FORM_URLENCODED_VALUE}
            , consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE
            , MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @ResponseBody
    public Result submitNormalWorkNote(@RequestBody WorkNote workNote,@RequestBody String groupId) {
        System.out.println(workNote);
        System.out.println(groupId);
        Result result =new Result();//= workNoteServiceImpl.submitNormalWorkNote(workNote,groupId);
        return result;
    }

    //提交工单
    @RequestMapping(value = "/emergent"
            , method = RequestMethod.POST
            , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE
            , MediaType.APPLICATION_FORM_URLENCODED_VALUE}
            , consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE
            , MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @ResponseBody
    public Result submitEmergentWorkNote(@RequestBody WorkNote workNote
            , @RequestBody List<Port> ports, @RequestBody List<Account> accounts) {
        Result result = workNoteServiceImpl.submitEmergentWorkNote(workNote, ports, accounts);
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
