package com.openmind.hacadaptor.model;

import com.openmind.hacadaptor.sqlutil.Table;

/**
 * Temp table to store the data from the hac ,
 * then we can compare to the DEVICE table to find out
 * which device is the new one by the GROUP column.
 * @author LiuBin
 * @version Created on 2017/7/24
 */
@Table("DEVICETMP")
public class DeviceTmp extends Device {
    public DeviceTmp(Long id){

        super(id);
    }
}
