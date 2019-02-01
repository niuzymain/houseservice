package com.house.dao;

import com.house.Basetest;
import com.house.entity.ServiceType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TypeDaotest extends Basetest {
    @Autowired
    private ServiceTypeDao serviceTypeDao;

    @Test
    public void testinsertServiceType(){
        int result = 0;
        for(int i=0;i<3;i++){
            ServiceType serviceType = new ServiceType();
            serviceType.setServicetypename("type"+i);
            serviceTypeDao.insertServiceType(serviceType);
            result++;
        }
        assertEquals(3,result);
    }

    @Test
    public void testdeleteServiceType(){
        int result;
        result =serviceTypeDao.deleteServiceType(4l);
        assertEquals(1,result);
    }

    @Test
    public void testupdateServiceType(){
        int result;
        ServiceType serviceType = new ServiceType();
        serviceType.setServicetypeid(3l);
        serviceType.setServicetypename("updatetype");
        result =serviceTypeDao.updateServiceType(serviceType);
        assertEquals(1,result);
    }

    @Test
    public void testqueryServiceType(){
        List<ServiceType> serviceTypeList = new ArrayList<>();
        serviceTypeList = serviceTypeDao.queryServiceType();
        assertEquals(4,serviceTypeList.size());
    }
}
