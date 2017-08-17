package com.openmind.hacadaptor.controller;

import com.openmind.hacadaptor.model.Device;
import com.openmind.hacadaptor.model.Group;
import com.openmind.hacadaptor.model.Result;
import com.openmind.hacadaptor.service.IGroupService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiuBin
 * @version Created on 2017/8/11
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/groups")
public class GroupController extends BaseController<IGroupService,Group> {

    Logger logger = Logger.getLogger(GroupController.class);
//    @Autowired
//    private IGroupService groupService;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @ResponseBody
//    public Result getGroups(){
//        Result result;
//        Group g = new Group();
//        try {
//            result = new Result();
//            result.setData(groupService.fuzzySelect(g));
//        } catch (Throwable throwable) {
//            logger.error("获取完整的group信息失败", throwable);
//            result = Result.getErrResult(throwable);
//        }
//        return result;
//    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    @ResponseBody
//    public Result updateDevice(@PathVariable("id") long id, @RequestBody Group group) {
//        Result result = new Result();
//        try {
//            group.setId(id);
//            if (groupService.update(group) <= 0) {
//                result.setSuccess(false);
//                result.setMessage("更新0条数据");
//            }
//        } catch (Throwable e) {
//            logger.error(e.getMessage());
//            result = Result.getErrResult(e);
//        }
//        return result;
//    }
}
