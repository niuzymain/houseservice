package com.house.dao;

import com.house.entity.SuperAdmin;
import org.apache.ibatis.annotations.Param;

public interface SuperAdminDao {
    SuperAdmin queryAdmin(SuperAdmin superAdmin);
}
