package com.openmind.hacadaptor.controller;


import com.openmind.hacadaptor.model.Device;
import com.openmind.hacadaptor.model.Result;

import com.openmind.hacadaptor.service.IDeviceService;
import com.openmind.hacadaptor.service.IDeviceTmpService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
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
    @Autowired
    private IDeviceTmpService deviceTmpService;

    /**
     * @param deviceId
     * @return simple device with id
     */
    @RequestMapping(value = "/{deviceId}", method = RequestMethod.GET)
    @ResponseBody
    public Device getByDeviceId(@PathVariable("deviceId") String deviceId) {
        Device d = new Device(deviceId);
        return deviceService.select(d);
    }

    /**
     *
     * @param groupName
     * @return
     */
    @RequestMapping(value = "/group/{groupName}", method = RequestMethod.GET)
    @ResponseBody
    public Result getDeviceWithPortAccount(@PathVariable("groupName") String groupName) {
        try {
            String s = new String(groupName.getBytes("ISO-8859-1"), "UTF-8");
            return deviceService.getDeviceWithPortAccount(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Result.getErrResult(e);
        }
    }

    /**
     * @return all the devices
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<Device> getDevices() {
        Device d = new Device();
        List<Device> list = deviceService.fuzzySelect(d);
        return list;
    }

    /**
     * update a device
     *
     * @param deviceId
     * @return
     */
    @RequestMapping(value = "/{deviceId}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateDevice(@PathVariable("deviceId") String deviceId, @RequestBody Device device) {
        Result result = new Result();
        try {
            device.setDeviceId(deviceId);
            if (deviceService.update(device) <= 0)
                result.setSuccess(false);
        } catch (Exception e) {
            logger.error(e.getMessage());
            result = Result.getErrResult(e);
        }
        return result;
    }

    /**
     * insert a device
     *
     * @param device
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Result insertDevice(@RequestBody Device device) {
        Result result = new Result();
        try {
            if (deviceService.insert(device) <= 0)
                result.setSuccess(false);
        } catch (Exception e) {
            logger.error(e.getMessage());
            result = Result.getErrResult(e);
        }
        return result;
    }

    /**
     * refresh devices tmp from hac
     *
     * @return
     */
    @RequestMapping(value = "/refreshDevices", method = RequestMethod.GET)
    @ResponseBody
    public Result updateDeviceTmpFromHac() {
        Result result;
        try {
            result = deviceTmpService.updateDeviceTmpFromHac();
        } catch (Exception e) {
            logger.error(e.getMessage());
            result = Result.getErrResult(e);
        }
        return result;
    }

    /**
     * First invoke the updateDeviceTmpFromHac() function.
     * <p>
     * Then invoke this one to filter the new devices which haven't been set up GroupId.
     * <p>
     * Finally,choose one device and invoke insertDevice() function to add a new device to DEVICE table.
     *
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    @ResponseBody
    public Result getNewDevices() {
        Result result = new Result();
        try {
            result.setData(deviceTmpService.getNewDevices());
        } catch (Exception e) {
            logger.error(e.getMessage());
            result = Result.getErrResult(e);
        }
        return result;
    }

    /**
     * Use updateDevice may be better
     *
     * @param id
     * @param groupId
     * @return
     */
    @RequestMapping(value = "/{id}/group/{groupId}", method = RequestMethod.PUT)
    @ResponseBody
    public Result setNewDeviceGroup(@PathVariable("id") long id, @PathVariable("groupId") String groupId) {
        Result result = new Result();
        try {
            if (deviceService.setNewDeviceGroup(id, groupId) <= 0) {
                result.setSuccess(false);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            result = Result.getErrResult(e);
        }
        return result;
    }

}
