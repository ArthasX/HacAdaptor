package com.openmind.hacadaptor.sqlutil;

import java.util.List;

/**
 * Created by LiuBin on 2017/6/29.
 * startIndex=pageSize*(currentPage-1)
 */
public class Page<T> {
    private List<T> list;
    private int startIndex;
    private int pageSize;
    private int currentPage;
    private int totalCount;
    private Class<T> modeClz;
    private ICondition condition;
    private T t;

    public Page() {

    }

    public Page(Class<T> modeClz) {

        this.modeClz = modeClz;
    }

    public Page(List<T> list, int startIndex, int pageSize, int currentPage, int totalCount, Class<T> modeClz) {
        this.list = list;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.modeClz = modeClz;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }


    public Class<T> getModeClz() {
        return modeClz;
    }

    public void setModeClz(Class<T> modeClz) {
        this.modeClz = modeClz;
    }

    public ICondition getCondition() {
        return condition;
    }

    public void setCondition(ICondition condition) {
        this.condition = condition;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
