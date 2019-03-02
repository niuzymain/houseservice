package com.house.service.user;

import com.house.entity.Reserve;
import com.house.entity.Servicer;

import java.util.List;

public interface FrontServicerService {

    int ServicerCount(Servicer servicer);

    List<Servicer> getAvailableServicer(Servicer servicer, String order, int pageindex, int pagesize);

    Servicer getSpecificServicer(Long servicerid);

    int orderServicer(Reserve reserve);
}

