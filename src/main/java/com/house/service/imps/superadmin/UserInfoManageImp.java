package com.house.service.imps.superadmin;

import com.house.dao.ServicerDao;
import com.house.dao.UserDao;
import com.house.entity.Servicer;
import com.house.entity.User;
import com.house.service.superadmin.UserInfoManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserInfoManageImp implements UserInfoManage {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ServicerDao servicerDao;
    @Override
    public List<User> getUserList() {
        return userDao.queryUser();
    }

    @Override
    public User getUserById(Long userid) {
        User user = new User();
        user.setUserid(userid);
        return userDao.querySingleUser(user);
    }

    @Override
    public List<Servicer> getServicerList() {
        return servicerDao.queryServicer(new Servicer());
    }

    @Override
    public Servicer getSingleServicer(Servicer servicer) {
        return servicerDao.querySingleServicer(servicer);
    }

    @Override
    @Transactional
    public int Unemployment(Long servicerid) {
        Servicer servicer = new Servicer();
        servicer.setServicerid(servicerid);
        servicer.setEnablestatus(-1);
        int result = servicerDao.updateServicer(servicer);
        if(result <= 0){
            throw new RuntimeException("解雇操作异常");
        }
        else{
            return result;
        }
    }
}
