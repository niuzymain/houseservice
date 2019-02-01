package com.house.dao;

import com.house.Basetest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class AdminDaotest extends Basetest {
    @Autowired
    private SuperAdminDao superAdminDao;

    @Test
    public void testinsert(){
        int result = superAdminDao.insertSuperAdmin("admin1",5);
        assertEquals(1,result);
    }
}
