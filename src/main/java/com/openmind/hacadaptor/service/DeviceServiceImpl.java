package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.dao.DeviceMapper;
import com.openmind.hacadaptor.model.*;
import com.openmind.hacadaptor.socket.hacoperation.IOperator;
import com.openmind.hacadaptor.socket.xml.model.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.model.devices.SAccount;
import com.openmind.hacadaptor.socket.xml.model.devices.SDevice;
import com.openmind.hacadaptor.socket.xml.model.devices.SPort;
import com.openmind.hacadaptor.sqlutil.IdWorker;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuBin on 2017/6/22.
 */
@Service
public class DeviceServiceImpl extends BaseServiceImp<Device, Identity> implements IDeviceService {
    Logger logger = Logger.getLogger(DeviceServiceImpl.class);

    @Autowired
    private DeviceMapper deviceMapper;


    /**
     * @return All the devices in the certain group with ports and accounts
     */
    public List<Device> getDeviceWithPortAccount(String groupName) throws Throwable {
        return deviceMapper.getDeviceWithPortAccount(groupName);
    }

    /**
     * @param id      ID column of device table.Not deviceId.
     * @param groupId
     * @return
     */
    public int setNewDeviceGroup(long id, String groupId) throws Throwable {
        Device device = new Device(id);
        device.setGroupId(groupId);
        return deviceMapper.update(device);
    }

}
