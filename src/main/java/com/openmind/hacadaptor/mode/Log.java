package com.openmind.hacadaptor.mode;

import com.openmind.hacadaptor.sqlutil.Column;
import com.openmind.hacadaptor.sqlutil.Table;

/**
 * Created by KJB-001064 on 2017/6/27.
 */
@Table("LOG")
public class Log extends BaseMode {

    @Column("workorder")
    private String workOrder;
    @Column("devicename")
    private String deviceName;
    @Column("ip")
    private String ip;
    @Column("content")
    private String content;
    @Column("optDate")
    private String optDate;
    @Column("remark")
    private String remark;
}
