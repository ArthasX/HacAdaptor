package com.openmind.hacadaptor.mode;

import com.openmind.hacadaptor.sqlutil.Column;
import com.openmind.hacadaptor.sqlutil.Table;

/**
 * @author LiuBin
 * @version Created on 2017/7/18
 */
@Table("USERMAPPING")
public class UserMapping {
    @Column("operator")
    String operator;
    @Column("name")
    String name;
    @Column("id")//数据库中定义的是自增int 次数定义String比较方便操作  当然int也可。SqlProvider中已经考虑了
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
