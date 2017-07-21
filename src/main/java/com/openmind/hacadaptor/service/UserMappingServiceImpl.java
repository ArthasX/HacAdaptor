package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.dao.UMMapper;
import com.openmind.hacadaptor.model.Identity;
import com.openmind.hacadaptor.model.UserMapping;
import com.openmind.hacadaptor.sqlutil.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/7/21
 */
@Service
public class UserMappingServiceImpl extends BaseServiceImp<UserMapping, Identity> implements IUserMappingService {
    @Autowired
    UMMapper umMapper;

    @Override
    public String getOperatorById(String id) {
        return umMapper.getOperatorById(id);
    }
}
