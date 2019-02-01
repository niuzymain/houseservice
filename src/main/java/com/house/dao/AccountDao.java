package com.house.dao;

import com.house.entity.Account;

public interface AccountDao {
    int insertAccount(Account account);
//    只可修改密码
    int updateAccount(Account account);
//    只可管理员删除
    int deleteAccount(long accountid);
//    判断账户是否存在
    Account queryAccount(Account account);

}
