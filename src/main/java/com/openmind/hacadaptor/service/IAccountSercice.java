package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.mode.Account;
import com.openmind.hacadaptor.mode.Identity;

import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/7/17
 */
public interface IAccountSercice extends IBaseService<Account,Identity> {
    List<Account> getAccountsByGroupName(String groupName);
}
