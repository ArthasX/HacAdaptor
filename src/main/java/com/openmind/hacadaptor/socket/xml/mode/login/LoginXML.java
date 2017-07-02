package com.openmind.xml.mode.login;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * 获取操作人员信息
 */
public class LoginXML {
    private List<User> users;

    @XmlElement(name = "Item")

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
