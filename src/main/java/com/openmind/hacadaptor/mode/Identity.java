package com.openmind.hacadaptor.mode;

import com.openmind.hacadaptor.sqlutil.Column;

import java.io.Serializable;

/**
 * Created by LiuBin on 2017/6/23.
 */
public class Identity implements Serializable {
//    @Column("id")
//    private long id;
//
//    public Identity() {
//
//    }
//
//    public Identity(long id) {
//        this.id = id;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
    @Column("id")
    private String id;

    public Identity() {

    }

    public Identity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
