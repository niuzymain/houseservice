package com.house.dao;

import com.house.Basetest;
import com.house.entity.AdminMsg;
import com.house.entity.Servicer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class AdminMsgDaoTest extends Basetest {
    @Autowired
    private AdminMsgDao adminMsgDao;

    @Test
    public void testQueryServicer(){
        AdminMsg adminMsg = new AdminMsg();
        adminMsg.setCreatetime(new Date());
        adminMsg.setAdminmsgdes("ssssssssss");
        adminMsg.setType(3);
        adminMsgDao.insertAdminmsg(adminMsg);
    }
}
