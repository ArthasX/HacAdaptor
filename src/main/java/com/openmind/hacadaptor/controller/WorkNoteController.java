package com.openmind.hacadaptor.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.openmind.hacadaptor.model.Account;
import com.openmind.hacadaptor.model.Port;
import com.openmind.hacadaptor.model.Result;
import com.openmind.hacadaptor.model.WorkNote;
import com.openmind.hacadaptor.service.IWorkNoteService;
import com.openmind.hacadaptor.socket.xml.model.devices.SPort;
import org.apache.log4j.Logger;
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
    static Logger  logger = Logger.getLogger(WorkNoteController.class);
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
        Result result;
        try {
            result = workNoteServiceImpl.setWorkNote(workNoteNumber);
        } catch (Throwable throwable) {
            logger.error("关闭工单:"+workNoteNumber+"失败",throwable);
            result=Result.getErrResult(throwable);
        }
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
        Result result;
        try {
            result = workNoteServiceImpl.submitNormalWorkNote(workNote, groupNames);
        } catch (Throwable throwable) {
            logger.error("发起常规变更工单:"+workNote.getWorkNoteNumber()+"失败",throwable);
            result=Result.getErrResult(throwable);
        }
        return result;
    }

    /**
     * Submit the emergent work note. 紧急变更
     *
     * @param jsonObject should be like this :
     *                   {"workNote":{xxx},"prot":[{"portId":"xx","protocol":"yy","accountId":["aa","bb"]},....]
     *                   ,"groupname":["xxx","yyy"]}
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
        JSONArray portArray = jsonObject.getJSONArray("port");
        List<SPort> sPorts = portArray.toJavaList(SPort.class);
        List<String> groupNames = jsonObject.getObject("groupname", ArrayList.class);
        Result result;
        try {
            result = workNoteServiceImpl.submitEmergentWorkNote(workNote, sPorts, groupNames);
        } catch (Throwable throwable) {
            logger.error("发起紧急变更工单:"+workNote.getWorkNoteNumber()+"失败",throwable);
            result=Result.getErrResult(throwable);
        }
        return result;
    }

    @RequestMapping(value = "/closeable/{workNoteNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Result closeable(@PathVariable String workNoteNumber){
        Result result;
        try {
           result= workNoteServiceImpl.closeable(workNoteNumber);
        } catch (Throwable throwable) {
            logger.error("查询变更工单是否可关闭:"+workNoteNumber+"失败",throwable);
            result=Result.getErrResult(throwable);
        }
        return result;
    }
}
