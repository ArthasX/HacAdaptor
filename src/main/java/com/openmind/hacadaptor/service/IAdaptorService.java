package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.mode.Device;

/**
 * Created by KJB-001064 on 2017/6/22.
 */
public interface IAdaptorService extends IBaseService{
    Device getDevices(String deviceId);
}
