package com.shop.dao;

import com.house.dao.AccountDao;
import com.house.entity.Account;
import com.shop.Basetest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class AccountDaotest extends Basetest {
    @Autowired
    private AccountDao accountDao;
    @Test
    public void testinsertAccount(){
        Account account = new Account();
        account.setUsername("testusername");
        account.setPassword("testpassword");
        int effect = accountDao.insertAccount(account);
        assertEquals(1,effect);
    }
}
