package com.openmind.hacadaptor.dao;

import com.openmind.hacadaptor.model.Port;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LiuBin on 2017/6/27.
 */
@Repository
public interface PortMapper extends IBaseMapper<Port> {
    List<Port> getPortsByGroupName(String groupName);
}
