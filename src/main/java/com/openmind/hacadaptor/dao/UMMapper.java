package com.openmind.hacadaptor.dao;

import com.openmind.hacadaptor.model.UserMapping;
import org.springframework.stereotype.Repository;

/**
 * @author LiuBin
 * @version Created on 2017/7/21
 */
@Repository
public interface UMMapper extends IBaseMapper<UserMapping> {
    String getOperatorById(String id);
}
