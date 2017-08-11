package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.model.Identity;
import com.openmind.hacadaptor.model.UserMapping;

/**
 * @author LiuBin
 * @version Created on 2017/7/21
 */
//Identity 此处没什么用
public interface IUserMappingService extends IBaseService<UserMapping,Identity>{
    String getOperatorById(String id)throws Throwable;
}
