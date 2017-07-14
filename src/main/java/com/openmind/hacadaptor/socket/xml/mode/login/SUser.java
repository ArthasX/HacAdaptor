package com.openmind.hacadaptor.socket.xml.mode.login;


import com.openmind.hacadaptor.socket.xml.mode.common.Context;

import javax.xml.bind.annotation.XmlElement;

/**
 * 操作人员信息
 */
public class SUser extends Context {

    private String groupId;
    private String groupName;
    private String login;//登录名
    private String name;//姓名
    private String id;//登录名对应ID
    private String mail;

    @XmlElement(name = "GroupId")
    public String getGroupId() {
        return groupId;
    }
    @XmlElement(name = "GroupName")
    public String getGroupName() {
        return groupName;
    }
    @XmlElement(name = "Login")
    public String getLogin() {
        return login;
    }
    @XmlElement(name = "Name")
    public String getName() {
        return name;
    }
    @XmlElement(name = "Id")
    public String getId() {
        return id;
    }
    @XmlElement(name = "Mail")
    public String getMail() {
        return mail;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
