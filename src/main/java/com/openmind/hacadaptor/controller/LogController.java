package com.openmind.hacadaptor.controller;

import com.openmind.hacadaptor.model.Log;
import com.openmind.hacadaptor.service.ILogService;
import com.openmind.hacadaptor.service.LogServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiuBin
 * @version Created on 2017/8/15
 */
@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/logs")
public class LogController extends BaseController<ILogService,Log>{
    static  Logger logger = Logger.getLogger(LogController.class);
//
//    @Autowired
//    private ILogService logService;


}
