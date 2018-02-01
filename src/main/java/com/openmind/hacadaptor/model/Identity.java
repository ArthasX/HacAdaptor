package com.openmind.hacadaptor.model;

import com.openmind.hacadaptor.sqlutil.Column;

import java.util.List;

/**
 * Created by LiuBin on 2017/6/23.
 */
public class Identity implements IBaseMode {
    @Column("id")
    private Long id;

    public Identity() {

    }

    public Identity(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
