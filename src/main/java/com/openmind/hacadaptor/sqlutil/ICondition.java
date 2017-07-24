package com.openmind.hacadaptor.sqlutil;

/**
 * 预留 以后 扩展 splProvider
 * @author LiuBin
 * @version Created on 2017/7/7
 */
public interface ICondition {
    ICondition asc();
    ICondition desc();
    ICondition groupBy();
    ICondition orderBy();
    String getCondString();
}
