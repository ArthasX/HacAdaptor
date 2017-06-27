package com.openmind.hacadaptor.sqlutil;

/**
 * Created by KJB-001064 on 2017/6/22.
 */
public interface TableFormat {
    String getColumnName(String field);
    String getTableName(String field);
    String getId();
}
