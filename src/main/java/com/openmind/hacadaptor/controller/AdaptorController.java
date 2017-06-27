package com.openmind.hacadaptor.controller;

import com.openmind.hacadaptor.service.IAdaptorService;
import com.openmind.hacadaptor.mode.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by KJB-001064 on 2017/6/22.
 */

@RestController
@RequestMapping("/Adaptor")
public class AdaptorController {

    @Autowired
    IAdaptorService adaptorService;

    @RequestMapping(value = "/devices/{deviceId}", method = RequestMethod.GET)
    @ResponseBody
    public Device getDevices(@PathVariable("deviceId") String deviceId) {
        Device d = adaptorService.getDevices(deviceId);
        return d;
    }



}
