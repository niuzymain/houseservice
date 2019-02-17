package com.house.service.imps.superadmin;

import com.house.dao.SuperAdminDao;
import com.house.entity.SuperAdmin;
import com.house.service.superadmin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceimp implements AdminService {
    @Autowired
    private SuperAdminDao superAdminDao;
    @Override
    public SuperAdmin checkLogin(SuperAdmin superAdmin) {
        SuperAdmin account = superAdminDao.queryAdmin(superAdmin);
        if(account != null){
            return account;
        }
        else{
            return null;
        }
    }
}
