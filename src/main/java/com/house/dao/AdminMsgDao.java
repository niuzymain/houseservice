package com.house.dao;

import com.house.entity.AdminMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMsgDao {
    int insertAdminmsg(@Param("adminmsg") AdminMsg adminMsg);
    List<AdminMsg> queryMessageList(@Param("adminmsg") AdminMsg adminMsg);
}
