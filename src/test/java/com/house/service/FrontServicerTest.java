package com.house.service;

import com.house.Basetest;
import com.house.dao.ServicerDao;
import com.house.entity.Servicer;
import com.house.service.user.FrontServicerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FrontServicerTest extends Basetest {
    @Autowired
    private FrontServicerService frontServicerService;

    @Test
    public void testQueryServicer(){
        Servicer servicer = new Servicer();
        servicer.setServicerage(10);
        List<Servicer> servicerList = frontServicerService.getAvailableServicer(servicer,"price",1,10);
        for (Servicer s:servicerList) {
            System.out.println("servicername:"+s.getServicername()+"   servicerprice:"+s.getServicerprice());
        }
        System.out.println("count:"+frontServicerService.ServicerCount(servicer));
    }
}
