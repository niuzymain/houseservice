package com.house.dao;

import com.house.entity.AdminMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMsgDao {
    int insertAdminmsg(@Param("adminmsg") AdminMsg adminMsg);
    List<AdminMsg> queryUserMessageList();
    List<AdminMsg> queryServicerMessageList();
    List<AdminMsg> querySpecificList(@Param("adminmsg") AdminMsg adminMsg);
    AdminMsg querySpecificComment(@Param("adminmsg")AdminMsg adminMsg);
}
