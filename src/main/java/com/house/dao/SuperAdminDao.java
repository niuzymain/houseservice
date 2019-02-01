package com.house.dao;

import org.apache.ibatis.annotations.Param;

public interface SuperAdminDao {
    int insertSuperAdmin(@Param("adminname")String adminname,@Param("accountid")long accountid);
    int deleteSuperAdmin(@Param("adminid")long adminid);
}
