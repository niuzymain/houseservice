package com.house.dao;

import com.house.entity.AdminMsg;
import org.apache.ibatis.annotations.Param;

public interface AdminMsgDao {
    int insertAdminmsg(@Param("adminmsg") AdminMsg adminMsg);
}
