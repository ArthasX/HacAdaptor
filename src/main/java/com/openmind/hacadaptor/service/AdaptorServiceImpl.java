package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.mapper.DeviceMapper;
import com.openmind.hacadaptor.mode.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by KJB-001064 on 2017/6/22.
 */
@Service
public class AdaptorServiceImpl implements IAdaptorService {
    @Autowired
    DeviceMapper deviceMapper;

    public Device getDevices(String deviceId) {
        Device device = new Device(deviceId);
        device = deviceMapper.select(device);
        return device;
    }
}
