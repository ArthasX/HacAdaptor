package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.sqlutil.Page;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by KJB-001064 on 2017/6/27.
 */
@Service("baseService")
public interface IBaseService<T,ID extends Serializable> {
    T selectById(Class<T> clz,ID id);

    T deleteById(Class<T> clz,ID id);

    T select(T t);

    T delete(T t);

    T update(T t);

    T save(T t);

    List<T> selectAll(T t);

    Page<T> pageSelect(T t);

    int selectCount(T t);
}
