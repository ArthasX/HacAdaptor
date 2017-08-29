package com.openmind.hacadaptor.model;

import com.openmind.hacadaptor.sqlutil.Column;
import com.openmind.hacadaptor.sqlutil.Table;

import java.io.Serializable;

/**
 * @author LiuBin
 * @version Created on 2017/7/18
 */
@Table("USERMAPPING")
public class UserMapping extends Identity{
    @Column("operator")
    String operator;
    @Column("name")
    String name;
    @Column("userId")//工号String比较方便操作
    String userId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
