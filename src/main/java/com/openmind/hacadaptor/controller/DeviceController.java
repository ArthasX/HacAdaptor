package com.openmind.hacadaptor.controller;


import com.openmind.hacadaptor.mode.Device;
import com.openmind.hacadaptor.service.DeviceServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by LiuBin on 2017/6/22.
 */

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    DeviceServiceImpl deviceService;

    @RequestMapping(value = "/{deviceId}", method = RequestMethod.GET)
    @ResponseBody
    public Device getByDeviceId(@PathVariable("deviceId") String deviceId) {
        Device d = new Device(deviceId);
        d = deviceService.select(d);
        return d;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<Device> getDevices() {
        Device d = new Device();
        List<Device> list = deviceService.selectAll(d);
        return list;
    }

}
