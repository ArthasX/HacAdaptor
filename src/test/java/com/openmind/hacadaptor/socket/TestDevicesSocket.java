package com.openmind.hacadaptor.socket;

import com.openmind.hacadaptor.socket.hacoperation.DeviceOperator;
import com.openmind.hacadaptor.socket.xml.mode.devices.Device;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by KJB-001064 on 2017/7/3.
 */
public class TestDevicesSocket {
    @Test
    public void getDevices(){
        DeviceOperator deviceOperator= new DeviceOperator();
        List<Device> list = deviceOperator.getDevices();
        Assert.assertNotNull(list);
    }
}
