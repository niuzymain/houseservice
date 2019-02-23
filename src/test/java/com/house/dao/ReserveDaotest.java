package com.house.dao;

import com.house.Basetest;
import com.house.entity.Reserve;
import com.house.entity.Servicer;
import com.house.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReserveDaotest extends Basetest {
    @Autowired
    private ReserveDao reserveDao;

    @Test
    public void ReserveListTese(){
        Reserve reserve = new Reserve();
        User user = new User();
        Servicer servicer = new Servicer();
        user.setUserid(1l);
        servicer.setServicerid(4l);
//        reserve.setUser(user);
//        reserve.setServicer(servicer);
//        List<Reserve> reserveList = reserveDao.queryReserveList(reserve);
        reserve = reserveDao.querySingleReserve(1l);
        System.out.println("success");
    }
}
