package com.openmind.hacadaptor.controller;

import com.alibaba.fastjson.JSON;
import com.openmind.hacadaptor.mode.Result;
import com.openmind.hacadaptor.mode.WorkNote;
import com.openmind.hacadaptor.service.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiuBin
 * @version Created on 2017/7/10
 */
@RestController
@RequestMapping("/worknote")
public class WorkNoteCotroller {

    @Autowired
    BaseServiceImp workNoteServiceImpl;

    //设置工单状态
    @RequestMapping(value = "/wornotestatus/{workNoteNumber}",method = RequestMethod.GET)
    @ResponseBody
    public Result setWorkNote(@PathVariable String workNoteNumber){
        Result result=new Result();

        WorkNote w= new WorkNote();
        w.setWorkNoteNumber(workNoteNumber);
        String s = JSON.toJSONString(result);
        System.out.println(result);
        return result;
    }

    //提交工单
    @RequestMapping(value = "/worknote"
            ,method = RequestMethod.POST
            , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE
            , MediaType.APPLICATION_FORM_URLENCODED_VALUE}
            ,consumes ={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE
            ,MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE} )
    @ResponseBody
    public Result sentWorkNote(@RequestBody WorkNote workNote){
        Result result=new Result();
        WorkNote w= workNote;
        result.setData(w);
        return result;
    }
//
//    @RequestMapping(value = "/worknote1"
//            ,method = RequestMethod.POST
//            )
//    @ResponseBody
//    public Result sentWorkNote1(@RequestBody WorkNote workNote){
//        Result result=new Result();
//        result.setData(workNote);
//        return result;
//    }
}
