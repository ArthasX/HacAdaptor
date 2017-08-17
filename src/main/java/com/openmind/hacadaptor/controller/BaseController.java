package com.openmind.hacadaptor.controller;

import com.alibaba.fastjson.JSONObject;
import com.openmind.hacadaptor.model.Device;
import com.openmind.hacadaptor.model.Identity;
import com.openmind.hacadaptor.model.Result;
import com.openmind.hacadaptor.service.IBaseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author LiuBin
 * @version Created on 2017/8/14
 */
@SuppressWarnings("unchecked")
public class BaseController<S extends IBaseService,M extends Serializable>  {
    Logger logger = Logger.getLogger(BaseController.class);

    @Autowired
    private S service;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Result getAll(){
        Result result;
        try {
            result = new Result();
            result.setData(service.fuzzySelect(getModelInstance()));
        } catch (Throwable throwable) {
            logger.error("获取信息失败"+service.getClass().getTypeName(), throwable);
            result = Result.getErrResult(throwable);
        }
        return result;
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getById(@PathVariable("id") String id) {
        Result result;

        try {
            Serializable m = getModelInstance();
            result = new Result();
            result.setData(service.select(m));
        } catch (Throwable throwable) {
            logger.error("获取Id为[" + id + "]的信息失败", throwable);
            result = Result.getErrResult(throwable);
        }
        return result;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable("id") long id, @RequestBody JSONObject object) {
        Result result = new Result();
        try {
            Identity m =(Identity) object.toJavaObject(getModelClass());
            m.setId(id);
            if (service.update(m) <= 0) {
                result.setSuccess(false);
                result.setMessage("更新0条数据");
            }
        } catch (Throwable e) {
            logger.error(e.getMessage());
            result = Result.getErrResult(e);
        }
        return result;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@RequestBody JSONObject object) {
        Result result = new Result();
        try {
            Serializable m =(Serializable) object.toJavaObject(getModelClass());
            if (service.insert(m) <= 0) {
                result.setSuccess(false);
                result.setMessage("插入0条数据");
            }
        } catch (Throwable e) {
            logger.error(e.getMessage());
            result = Result.getErrResult(e);
        }
        return result;
    }

    private Class getModelClass() throws IllegalAccessException, InstantiationException {
        Type genType = this.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
        return (Class)params[1];
    }


    private Serializable getModelInstance() throws IllegalAccessException, InstantiationException {
        return (Serializable)getModelClass().newInstance();
    }
}
