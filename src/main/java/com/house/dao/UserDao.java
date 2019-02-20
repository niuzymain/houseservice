package com.house.dao;

import com.house.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public int insertUser(User user);
    public int updateUser(User user);
    public List<User> queryUser();
    public User querySingleUser(@Param("condition") User conditon);
}
