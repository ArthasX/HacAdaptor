package com.openmind.hacadaptor.dao;

import com.openmind.hacadaptor.model.DeviceTmp;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/7/24
 */
@Repository
public interface DeviceTmpMapper extends IBaseMapper<DeviceTmp> {
    List<DeviceTmp> getNewDevices();
    int deleteAllDeviceTmp();
}
