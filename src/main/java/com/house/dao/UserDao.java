package com.house.dao;

import com.house.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
     int insertUser(User user);
     int updateUser(User user);
     List<User> queryUser(@Param("index") int index,@Param("size") int size);
     int queryUserCount();
     User querySingleUser(@Param("condition") User conditon);
}
