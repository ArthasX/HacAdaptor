package com.openmind.hacadaptor.model;

import com.openmind.hacadaptor.sqlutil.Column;
import com.openmind.hacadaptor.sqlutil.Table;

/**
 * @author LiuBin
 * @version Created on 2017/8/11
 */
@Table("GROUPS")
public class Group extends Identity{
    @Column("groupname")
    private String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
