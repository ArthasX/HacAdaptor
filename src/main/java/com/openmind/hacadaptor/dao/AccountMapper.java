package com.openmind.hacadaptor.dao;


import com.openmind.hacadaptor.mode.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LiuBin on 2017/6/27.
 */
@Repository
public interface AccountMapper extends IBaseMapper<Account> {
    List<Account> getAccountsByGroupName(String groupName);
}
