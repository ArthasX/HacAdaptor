package com.openmind.hacadaptor.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by KJB-001064 on 2017/6/27.
 */
public interface IBaseService<T extends Serializable> {
    <T extends Serializable> T getById(T t);
    <T extends Serializable> T deleteById(T t);
    <T extends Serializable> T updateById(T t);
    <T extends Serializable> T save(T t);

    //传空的T 有SqlProvide组装 成没有
    <T extends Serializable> List<T> listAll(T t);
}
