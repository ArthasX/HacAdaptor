package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.mode.Identity;
import com.openmind.hacadaptor.mode.Port;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/7/12
 */
@Service
public class PortServiceImpl extends BaseServiceImp<Port,Identity> implements IPortService{
    @Override
    public List<Port> getPortsByGroupName(String groupName) {
        return null;
    }
}
