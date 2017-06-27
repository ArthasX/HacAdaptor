package com.openmind.hacadaptor.mode;

import com.openmind.hacadaptor.sqlutil.Column;

/**
 * Created by KJB-001064 on 2017/6/23.
 */
public class BaseMode {
    @Column("id")
    private String id;

    public BaseMode(){

    }
    public BaseMode(String id){
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
