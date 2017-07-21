package com.openmind.hacadaptor.dao;

import com.openmind.hacadaptor.model.Device;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LiuBin on 2017/6/22.
 */

@Repository
public interface DeviceMapper extends IBaseMapper<Device> {
    List<Device> getDeviceWithPortAccount(String groupName);

}
