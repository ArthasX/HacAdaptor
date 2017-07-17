package com.openmind.hacadaptor.controller;


import com.openmind.hacadaptor.mode.Device;
import com.openmind.hacadaptor.mode.Result;
import com.openmind.hacadaptor.service.DeviceServiceImpl;

import com.openmind.hacadaptor.service.IDeviceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by LiuBin on 2017/6/22.
 */

@RestController
@RequestMapping("/devices")
public class DeviceController {
    Logger logger = Logger.getLogger(DeviceController.class);
    @Autowired
    private IDeviceService deviceService;

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
        List<Device> list = deviceService.fuzzySelect(d);
        return list;
    }

    //PUT 对应Update
    @RequestMapping(value = "/{deviceId}", method = RequestMethod.PUT)
    @ResponseBody
    public Device updateDevice(@PathVariable("deviceId") String deviceId) {

        return null;
    }

    //POST对应insert
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Result getDevices(@RequestBody Device device) {
        Result result = new Result();
        result.setData(device);
        return result;
    }


    @RequestMapping(value = "/updateDevices", method = RequestMethod.GET)
    @ResponseBody
    public Result updateDevicesFromHac() {
        Result result = new Result();
        try {
            result=deviceService.updateDevicesFromHac();
        } catch (Exception e) {
            logger.error(e.getMessage());
            result.setErrorMessage(e.getMessage());
            result.setSuccess(false);
            result.setErrorCode(1);
        }
        return result;
    }
}
