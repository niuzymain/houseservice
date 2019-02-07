package com.house.service.imps.common;

import com.house.dao.AccountDao;
import com.house.entity.Account;
import com.house.service.common.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public boolean isAccountExist(Account account) {
        Account account1 = new Account();
        account1 = accountDao.queryAccount(account);
        if(account1 != null){
            return true;
        }
        else{
            return false;
        }

    }
}
