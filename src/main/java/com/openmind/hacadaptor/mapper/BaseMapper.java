package com.openmind.hacadaptor.mapper;

import com.openmind.hacadaptor.sqlutil.SqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.util.List;

/**
 * Created by KJB-001064 on 2017/6/22.
 */


public interface BaseMapper<T extends Serializable> {

    @InsertProvider(type = SqlProvider.class, method = "insert")
    @Options(useGeneratedKeys = true)
    int insert(T t);

    @DeleteProvider(type = SqlProvider.class, method = "delete")
    int delete(T t);

    @UpdateProvider(type = SqlProvider.class, method = "update")
    int update(T t);


    @SelectProvider(type = SqlProvider.class, method = "select")
    T select(T t);

    @SelectProvider(type = SqlProvider.class, method = "fuzzySelect")
    List<T> fuzzySelect(T t);

//    @SelectProvider(type = SqlProvider.class,method = "pageSelect")
//    List<T> pageSelect(T t);

    @SelectProvider(type = SqlProvider.class, method = "selectAll")
    List<T> findAll(T t);
}
