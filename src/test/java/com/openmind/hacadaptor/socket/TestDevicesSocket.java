package com.openmind.hacadaptor.socket;

import com.openmind.hacadaptor.socket.hacoperation.BaseOperator;
import com.openmind.hacadaptor.socket.hacoperation.DeviceOperator;
import com.openmind.hacadaptor.socket.xml.mode.devices.SDevice;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by LiuBin on 2017/7/3.
 */
public class TestDevicesSocket {
    @Test
    public void getDevices(){
        BaseOperator deviceOperator= new DeviceOperator();
        List<SDevice> list =(List<SDevice>) deviceOperator.getXmldtoBack().getResult().getBackContext().getContextDetail();
        Assert.assertNotNull(list);
        Assert.assertEquals(33,list.size());
    }
}
