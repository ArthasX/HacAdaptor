package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.model.DeviceTmp;
import com.openmind.hacadaptor.model.Identity;
import com.openmind.hacadaptor.model.Result;

import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/7/24
 */
public interface IDeviceTmpService extends IBaseService<DeviceTmp,Identity> {
    Result updateDevicesFromHac() throws RuntimeException;
    List<DeviceTmp> getNewDevices() ;
}
