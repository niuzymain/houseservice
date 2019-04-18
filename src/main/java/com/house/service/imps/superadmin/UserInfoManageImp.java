package com.house.service.imps.superadmin;

import com.house.dao.ServicerDao;
import com.house.dao.UserDao;
import com.house.dto.ServicerExecution;
import com.house.dto.UserExecution;
import com.house.entity.Servicer;
import com.house.entity.User;
import com.house.enums.ServicerEnum;
import com.house.enums.UserEnum;
import com.house.service.superadmin.UserInfoManage;
import com.house.util.PageIndexUtil;
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
    public UserExecution getUserList(int pageIndex, int pageSize) {
        int index = PageIndexUtil.TranstoDBIndex(pageIndex,pageSize);
        List<User> userList= userDao.queryUser(index,pageSize);
        int usercount = userDao.queryUserCount();
        return new UserExecution(UserEnum.SUCCESS,userList,usercount);
    }

    @Override
    public User getUserById(Long userid) {
        User user = new User();
        user.setUserid(userid);
        return userDao.querySingleUser(user);
    }

    @Override
    public ServicerExecution getServicerList(int pageIndex, int pageSize) {
        int index = PageIndexUtil.TranstoDBIndex(pageIndex,pageSize);
        List<Servicer> servicerList= servicerDao.queryServicer(index,pageSize);
        int servicercount = servicerDao.queryServicerCountForAdmin();
        return new ServicerExecution(ServicerEnum.SUCCESS,servicerList,servicercount);
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
