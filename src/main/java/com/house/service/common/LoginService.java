package com.house.service.common;

import com.house.dao.AccountDao;
import com.house.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;

public interface LoginService {
    boolean isAccountExist(Account account);
}
