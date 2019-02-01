package com.house.dao;

import com.house.Basetest;
import com.house.entity.Account;
import com.house.entity.ServiceType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AccountDaotest extends Basetest {
    @Autowired
    private AccountDao accountDao;

    @Test
    public void testinsertAccount(){
        int result = 0;
        for(int i=0;i<3;i++){
            Account account = new Account();
            account.setUsername("username"+i);
            account.setPassword("password"+i);
            account.setAccounttype(1);
            accountDao.insertAccount(account);
            result++;
        }
        assertEquals(3,result);
    }

    @Test
    public void testupdateAccount(){
        int result;
        Account account = new Account();
        account.setAccountid(1);
        account.setPassword("updatepass");
        result =accountDao.updateAccount(account);
        assertEquals(1,result);
    }

    @Test
    public void testdeleteAccount(){
        int result;
        result =accountDao.deleteAccount(2);
        assertEquals(1,result);
    }

    @Test
    public void testqueryAccount(){
        Account input = new Account();
        input.setUsername("11");
        input.setPassword("22");
        Account account = new Account();
        account = accountDao.queryAccount(input);
        if(account == null){
            System.out.println("result null");
        }
        else{
            System.out.println("result:"+account.getAccountid());

        }
    }
}
