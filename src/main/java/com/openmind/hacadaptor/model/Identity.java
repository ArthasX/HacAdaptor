package com.openmind.hacadaptor.model;

import com.openmind.hacadaptor.sqlutil.Column;

import java.util.List;

/**
 * Created by LiuBin on 2017/6/23.
 */
public class Identity implements IBaseMode {
    @Column("id")
    private long id;

    public Identity() {

    }

    public Identity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
