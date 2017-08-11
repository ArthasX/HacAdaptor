package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.dao.PortMapper;
import com.openmind.hacadaptor.model.Identity;
import com.openmind.hacadaptor.model.Port;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/7/12
 */
@Service
public class PortServiceImpl extends BaseServiceImp<Port,Identity> implements IPortService{
    @Autowired
    PortMapper portMapper;
    @Override
    public List<Port> getPortsByGroupName(String groupName)throws Throwable {
        return portMapper.getPortsByGroupName(groupName);
    }

    @Override
    public List<Port> getPortsAccountsByGroupName(String groupName)throws Throwable {
        return portMapper.getPortsAccountsByGroupName(groupName);
    }
}
