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
@CrossOrigin(origins = "*")
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
    public Result getByDeviceId(@PathVariable("deviceId") String deviceId) {
        Result result;
        Device d = new Device(deviceId);
        try {
            result = new Result();
            result.setData(deviceService.select(d));
        } catch (Throwable throwable) {
            logger.error("获取deviceId为[" + deviceId + "]的信息失败", throwable);
            result = Result.getErrResult(throwable);
        }
        return result;
    }

    /**
     * @param groupName
     * @return
     */
    @RequestMapping(value = "/group/{groupName}", method = RequestMethod.GET)
    @ResponseBody
    public Result getDeviceWithPortAccount(@PathVariable("groupName") String groupName) {
        Result result;
        try {
            result = new Result();
            String s = new String(groupName.getBytes("ISO-8859-1"), "UTF-8");
            result.setData(deviceService.getDeviceWithPortAccount(s));
        } catch (Throwable throwable) {
            logger.error("获取[" + groupName + "]所包含的device、account、port信息失败", throwable);
            result = Result.getErrResult(throwable);
        }
        return result;
    }

    /**
     * @return all the devices
     */

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Result getDevices() {
        Result result;
        Device d = new Device();
        try {
            result = new Result();
            result.setData(deviceService.fuzzySelect(d));
        } catch (Throwable throwable) {
            logger.error("获取完整的device信息失败", throwable);
            result = Result.getErrResult(throwable);
        }
        return result;
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
            if (deviceService.update(device) <= 0) {
                result.setSuccess(false);
                result.setMessage("更新0条数据");
            }
        } catch (Throwable e) {
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
            if (deviceService.insert(device) <= 0) {
                result.setSuccess(false);
                result.setMessage("更新0条数据");
            }
        } catch (Throwable e) {
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
        } catch (Throwable e) {
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
                result.setMessage("更新0条数据");
            }
        } catch (Throwable e) {
            logger.error(e.getMessage());
            result = Result.getErrResult(e);
        }
        return result;
    }

}
