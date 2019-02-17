package com.house.service.imps.user;

import com.house.dao.UserDao;
import com.house.entity.User;
import com.house.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public int editUser(User user) {
        try{
            int result = userDao.updateUser(user);
            if(result <= 0){
                throw new RuntimeException();
            }
            else{
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
}
