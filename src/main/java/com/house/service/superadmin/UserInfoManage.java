package com.house.service.superadmin;

import com.house.entity.Servicer;
import com.house.entity.User;

import java.util.List;

public interface UserInfoManage {
    List<User> getUserList();
    User getUserById(Long userid);
    List<Servicer> getServicerList();
    Servicer getServicerById(Long servicerid);
}
