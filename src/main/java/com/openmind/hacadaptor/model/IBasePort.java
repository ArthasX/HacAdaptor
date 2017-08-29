package com.openmind.hacadaptor.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by KJB-001064 on 2017/7/28.
 */
public interface IBasePort extends Serializable{
    List<String> getAccountId();
    String getPortId();
}
