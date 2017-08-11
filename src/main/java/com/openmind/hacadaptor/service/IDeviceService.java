package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.model.Device;
import com.openmind.hacadaptor.model.Identity;
import com.openmind.hacadaptor.model.Result;

import java.util.List;

/**
 * Created by LiuBin on 2017/6/22.
 */
public interface IDeviceService extends IBaseService<Device, Identity> {
    List<Device> getDeviceWithPortAccount(String groupName)throws Throwable;

    int setNewDeviceGroup(long id, String groupId)throws Throwable;
}
