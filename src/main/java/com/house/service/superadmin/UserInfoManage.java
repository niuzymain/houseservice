package com.house.service.superadmin;

import com.house.dto.ServicerExecution;
import com.house.dto.UserExecution;
import com.house.entity.Servicer;
import com.house.entity.User;

import java.util.List;
/*
用户信息管理
 */
public interface UserInfoManage {
    UserExecution getUserList(int pageIndex, int pageSize);
    User getUserById(Long userid);
    ServicerExecution getServicerList(int pageIndex, int pageSize);
    Servicer getSingleServicer(Servicer servicer);
    int Unemployment(Long servicerid);
}
