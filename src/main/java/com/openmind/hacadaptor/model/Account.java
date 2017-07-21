package com.openmind.hacadaptor.model;

import com.openmind.hacadaptor.sqlutil.Column;
import com.openmind.hacadaptor.sqlutil.Table;

/**
 * Created by LiuBin on 2017/6/22.
 */
@Table("ACCOUNT")
public class Account extends Identity {
    @Column("accountId")
    private String accountId;
    @Column("name")
    private String name;
    @Column("manageaccount")
    private String manageAccount;
    @Column("accounttype")
    private String accountType;
    @Column("deviceid")
    private String deviceId;

    public Account() {
    }

    public Account(long id) {
        super(id);
    }

    public Account(String accountId) {
        this.accountId = accountId;
    }

    public Account(String accountId, String name, String manageAccount, String accountType, String deviceId) {
        this.accountId = accountId;
        this.name = name;
        this.manageAccount = manageAccount;
        this.accountType = accountType;
        this.deviceId = deviceId;
    }

    public Account(long id, String accountId, String name, String manageAccount, String accountType, String deviceId) {
        super(id);
        this.accountId = accountId;
        this.name = name;
        this.manageAccount = manageAccount;
        this.accountType = accountType;
        this.deviceId = deviceId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManageAccount() {
        return manageAccount;
    }

    public void setManageAccount(String manageAccount) {
        this.manageAccount = manageAccount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
