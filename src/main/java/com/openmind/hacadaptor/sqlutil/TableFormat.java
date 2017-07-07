package com.openmind.hacadaptor.sqlutil;

/**
 * Created by LiuBin on 2017/6/22.
 */
public interface TableFormat<T> {
    String getColumnName(String field);

    String getTableName(String className);

    String getId();
}
