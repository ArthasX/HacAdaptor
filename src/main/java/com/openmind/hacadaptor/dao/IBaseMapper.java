package com.openmind.hacadaptor.dao;

import com.openmind.hacadaptor.sqlutil.SqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * You can change the parameters of the functions in this class
 * TODO use @Param to make the function more effective,feasible
 * <p>
 * Created by LiuBin on 2017/6/22.
 */

@Repository
public interface IBaseMapper<T extends Serializable> {

    @InsertProvider(type = SqlProvider.class, method = "insert")
    int insert(T t);

    /**
     * The parameter marked by @Param([key]) can be packaged in the Map.
     * The corresponding parameter in SqlProvider.[method] is map.get([key]).
     * The corresponding sql query is:
     * <p>
     * insert into tablename (column1,c2,c3...)
     * values (key[0].column1,key[0].column2,...),(key[1].column1,key[1].column2,...)
     * <p>
     * See:SqlProvider.insertBatch
     *
     * @param list The list of the entity that you want to insert into the DB one-time.
     * @return
     */
    @InsertProvider(type = SqlProvider.class, method = "insertBatch")
    int insertBatch(@Param("list") List<T> list);

    @DeleteProvider(type = SqlProvider.class, method = "delete")
    int delete(T t);

    @UpdateProvider(type = SqlProvider.class, method = "update")
    int update(T t);

    @SelectProvider(type = SqlProvider.class, method = "select")
    T select(T t);

    @SelectProvider(type = SqlProvider.class, method = "fuzzySelect")
    List<T> fuzzySelect(T t);

    @SelectProvider(type = SqlProvider.class, method = "selectCount")
    int count(T t);

}
