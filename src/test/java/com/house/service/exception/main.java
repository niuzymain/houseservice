package com.house.service.exception;

import com.house.entity.Reserve;
import com.house.entity.Servicer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class main {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD-HH-mm-ss");
        System.out.println("date:"+new Date());
        System.out.println("time:"+simpleDateFormat.format(new Date()));
//        Servicer servicer = new Servicer();
//        servicer.setServicerid(1l);
//        Reserve reserve1 = new Reserve();
//        Reserve reserve2 = new Reserve();
//        reserve1.setServicer(servicer);
//        reserve2.setServicer(servicer);
//        System.out.println("id:"+reserve2.getServicer().getServicerid());
//        reserve1.getServicer().setServicerid(100l);
//        System.out.println("id:"+reserve2.getServicer().getServicerid());
    }
}
