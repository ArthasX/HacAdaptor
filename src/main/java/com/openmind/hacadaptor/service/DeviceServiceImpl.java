package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.mode.Device;
import com.openmind.hacadaptor.mode.Identity;
import com.openmind.hacadaptor.socket.hacoperation.IOperator;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LiuBin on 2017/6/22.
 */
@Service
public class DeviceServiceImpl extends BaseServiceImp<Device, Identity> {

    @Autowired
    IOperator deviceOperation;
    public void updateDevicesFromHac(){
        XMLDTO xmldto=deviceOperation.getXmldtoBack();
        List<Device> list=(List<Device>)xmldto.getResult().getBackContext().getContextDetail();



    }

    public IOperator getDeviceOperation() {
        return deviceOperation;
    }

    public void setDeviceOperation(IOperator deviceOperation) {
        this.deviceOperation = deviceOperation;
    }
}
