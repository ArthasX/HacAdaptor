package com.openmind.hacadaptor.bl;

import com.alibaba.fastjson.JSONObject;
import com.openmind.hacadaptor.mode.Device;
import org.springframework.stereotype.Service;

/**
 * Created by KJB-001064 on 2017/6/22.
 */
public interface IAdaptorService {
    Device getDevices(String deviceId);
}
