package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.dao.BaseMapper;
import com.openmind.hacadaptor.sqlutil.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LiuBin on 2017/6/28.
 */

public class BaseServiceImp<T extends Serializable, ID extends Serializable> implements IBaseService<T, ID> {

    @Autowired
    BaseMapper<T> baseMapper;

    @Override
    public T selectById(Class<T> clz, ID id) {
        return null;
    }

    @Override
    public T deleteById(Class<T> clz, ID id) {
        return null;
    }

    @Override
    public T select(T t) {
        return baseMapper.select(t);
    }


    @Override
    public T delete(T t) {
        return null;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public T save(T t) {
        return null;
    }

    @Override
    public List<T> selectAll(T t) {
        return baseMapper.fuzzySelect(t);
    }

    @Override
    public Page<T> pageSelect(T t) {
        Page<T> page = new Page<T>();
        page.setList(baseMapper.fuzzySelect(t));
        return page;
    }

    @Override
    public int selectCount(T t) {
        return baseMapper.count(t);
    }

    public BaseMapper<T> getBaseMapper() {
        return baseMapper;
    }

    public void setBaseMapper(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }
}
