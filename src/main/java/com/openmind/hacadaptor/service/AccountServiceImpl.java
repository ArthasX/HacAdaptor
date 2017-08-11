package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.dao.AccountMapper;
import com.openmind.hacadaptor.model.Account;
import com.openmind.hacadaptor.model.Identity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/7/12
 */
@Service
public class AccountServiceImpl extends BaseServiceImp<Account, Identity> implements IAccountSercice {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public List<Account> getAccountsByGroupName(String groupName)throws Throwable {
        return accountMapper.getAccountsByGroupName(groupName);
    }
}
