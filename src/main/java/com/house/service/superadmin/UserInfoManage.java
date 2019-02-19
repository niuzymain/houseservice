package com.house.service.superadmin;

import com.house.entity.Servicer;
import com.house.entity.User;

import java.util.List;
/*
用户信息管理
 */
public interface UserInfoManage {
    List<User> getUserList();
    User getUserById(Long userid);
    List<Servicer> getServicerList();
    Servicer getSingleServicer(Servicer servicer);
}
