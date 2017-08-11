package com.openmind.hacadaptor.socket;

import com.openmind.hacadaptor.socket.hacoperation.BaseOperation;
import com.openmind.hacadaptor.socket.hacoperation.DeviceOperation;
import com.openmind.hacadaptor.socket.xml.model.devices.SDevice;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by LiuBin on 2017/7/3.
 */
public class TestDevicesSocket {
    @Test
    public void getDevices(){
        BaseOperation deviceOperator= new DeviceOperation();
        List<SDevice> list =(List<SDevice>) deviceOperator.getXmldtoBack().getResult().getBackContext().getContextDetail();
        Assert.assertNotNull(list);
        Assert.assertEquals(941,list.size());
    }
}
