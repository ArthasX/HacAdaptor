package com.openmind.hacadaptor.socket.xml.mode.login;


import com.openmind.hacadaptor.socket.xml.mode.common.Context;

/**
 * 操作人员信息
 */
public class User extends Context {
    private String groupId;
    private String groupName;
    private String login;
    private String name;
    private String id;
    private String mail;

    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

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
