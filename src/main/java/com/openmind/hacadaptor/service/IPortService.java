package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.mode.Identity;
import com.openmind.hacadaptor.mode.Port;

import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/7/17
 */
public interface IPortService extends IBaseService<Port,Identity> {
    List<Port> getPortsByGroupName(String groupName);
}
