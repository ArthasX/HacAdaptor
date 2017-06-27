package com.openmind.hacadaptor.mapper;

import com.openmind.hacadaptor.sqlutil.SqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by KJB-001064 on 2017/6/22.
 */


public interface BaseMapper<T> {

    @InsertProvider(type = SqlProvider.class, method = "insert")
    @Options(useGeneratedKeys = true)
    int insert(T t);

    @DeleteProvider(type = SqlProvider.class, method = "delete")
    int delete(T t);

    @UpdateProvider(type = SqlProvider.class, method = "update")
    int update(T t);

    //List<T> findAll(T t,int start,int pageSize);
    @SelectProvider(type = SqlProvider.class, method = "select")
    T select(T t);

    @SelectProvider(type = SqlProvider.class, method = "select")
    List<T> selectAll(T t, int start, int pageSize);
}
