package com.house.service.user;

import com.house.entity.User;

public interface UserService {
    int addUser(User user);
    int editUser(User user);
    User selectSingleUser(User condition);
}
