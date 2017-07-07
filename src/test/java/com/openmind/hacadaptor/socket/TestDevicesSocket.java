package com.openmind.hacadaptor.socket;

import com.openmind.hacadaptor.socket.hacoperation.BaseOperation;
import com.openmind.hacadaptor.socket.hacoperation.DeviceOperator;
import com.openmind.hacadaptor.socket.xml.mode.devices.Device;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by LiuBin on 2017/7/3.
 */
public class TestDevicesSocket {
    @Test
    public void getDevices(){
        BaseOperation deviceOperator= new DeviceOperator();
        List<Device> list =(List<Device>) deviceOperator.getXmldtoBack().getResult().getBackContext().getContextDetail();
        Assert.assertNotNull(list);
        Assert.assertEquals(33,list.size());
    }
}
