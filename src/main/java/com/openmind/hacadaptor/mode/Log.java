package com.openmind.hacadaptor.mode;

import com.openmind.hacadaptor.sqlutil.Column;

/**
 * Created by KJB-001064 on 2017/6/27.
 */
public class Log extends BaseMode {

    @Column("workorder")
    private String workOrder;
    @Column("devicename")
    private String deviceName;
    @Column("")
    private String ip;
    private String content;
    private String optDate;
    private String remark;
}
