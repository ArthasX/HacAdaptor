package com.openmind.hacadaptor.socket.xml.mode.login;

import com.openmind.hacadaptor.socket.xml.mode.common.Context;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * 获取操作人员信息
 */
public class LoginContext extends Context<List<User>> {
    private List<User> users;

    @XmlElement(name = "Item")
    public List<User> getContextDetail() {
        return users;
    }

    public void setContextDetail(List<User> users) {
        this.users = users;
    }
}
