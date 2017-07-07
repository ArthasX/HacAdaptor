package com.openmind.hacadaptor.socket.xml.mode.devices;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by LiuBin on 2017/6/28.
 */
public class Account {
    private String name;
    private String managerAccount;
    private String accountId;
    private String accountType;

    @XmlElement(name = "Name")
    public String getName() {
        return name;
    }

    @XmlElement(name = "ManagerAccount")
    public String getManagerAccount() {
        return managerAccount;
    }

    @XmlElement(name = "AccountId")
    public String getAccountId() {
        return accountId;
    }

    @XmlElement(name = "AccountType")
    public String getAccountType() {
        return accountType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManagerAccount(String managerAccount) {
        this.managerAccount = managerAccount;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
