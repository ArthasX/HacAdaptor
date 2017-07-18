package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.mode.Device;
import com.openmind.hacadaptor.mode.Identity;
import com.openmind.hacadaptor.mode.Result;
import org.springframework.stereotype.Service;

/**
 * Created by LiuBin on 2017/6/22.
 */
public interface IDeviceService extends IBaseService<Device, Identity> {
    Result updateDevicesFromHac() throws RuntimeException;
}
