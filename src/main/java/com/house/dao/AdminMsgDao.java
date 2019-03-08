package com.house.dao;

import com.house.entity.AdminMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMsgDao {
    int insertAdminmsg(@Param("adminmsg") AdminMsg adminMsg);
    List<AdminMsg> queryUserMessageList(@Param("adminmsg") AdminMsg adminMsg);
    List<AdminMsg> queryServicerMessageList(@Param("adminmsg") AdminMsg adminMsg);
}
