package com.openmind.hacadaptor.controller;

import com.openmind.hacadaptor.model.Result;
import com.openmind.hacadaptor.model.UserMapping;
import com.openmind.hacadaptor.service.IBaseService;
import com.openmind.hacadaptor.service.IUserMappingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiuBin
 * @version Created on 2017/8/14
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usermappings")
public class UserMappingController extends BaseController<IUserMappingService,UserMapping> {
    Logger logger = Logger.getLogger(UserMappingController.class);
//    @Autowired
//    private IUserMappingService userMappingService;
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @ResponseBody
//    public Result getUserMappings(){
//        Result result;
//        UserMapping g = new UserMapping();
//        try {
//            result = new Result();
//            result.setData(userMappingService.fuzzySelect(g));
//        } catch (Throwable throwable) {
//            logger.error("获取完整的用户映射关系信息失败", throwable);
//            result = Result.getErrResult(throwable);
//        }
//        return result;
//    }

}
