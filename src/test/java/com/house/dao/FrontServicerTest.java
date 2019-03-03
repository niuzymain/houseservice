package com.house.dao;

import com.house.Basetest;
import com.house.entity.Servicer;
import com.house.entity.WorkArea;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FrontServicerTest extends Basetest {
    @Autowired
    private ServicerDao servicerDao;

    @Test
    public void testQueryServicer(){
        Servicer servicer = new Servicer();
        servicer.setServicerprice(6000);
        List<Servicer> servicerList = servicerDao.queryServicerForUser(servicer,"price",0,3);
        for (Servicer s:servicerList) {
            System.out.println("servicername:"+s.getServicername()+"   servicerprice:"+s.getServicerprice());
        }
        System.out.println("count:"+servicerDao.queryServicerCount(servicer));
    }
}
