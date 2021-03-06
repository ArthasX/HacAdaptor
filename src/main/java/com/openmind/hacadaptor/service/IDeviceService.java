package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.model.Device;
import com.openmind.hacadaptor.model.Identity;
import com.openmind.hacadaptor.model.Result;

/**
 * Created by LiuBin on 2017/6/22.
 */
public interface IDeviceService extends IBaseService<Device, Identity> {
    Result getDeviceWithPortAccount(String groupName);

    int setNewDeviceGroup(long id, String groupId);
}
