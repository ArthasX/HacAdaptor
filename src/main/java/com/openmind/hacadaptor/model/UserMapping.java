package com.openmind.hacadaptor.model;

import com.openmind.hacadaptor.sqlutil.Column;
import com.openmind.hacadaptor.sqlutil.Table;

import java.io.Serializable;

/**
 * @author LiuBin
 * @version Created on 2017/7/18
 */
@Table("USERMAPPING")
public class UserMapping implements Serializable{
    @Column("operator")
    String operator;
    @Column("name")
    String name;
    @Column("id")//工号String比较方便操作
    String id;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
