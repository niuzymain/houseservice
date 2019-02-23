package com.house.service.servicer;

import com.house.entity.Reserve;

import java.util.List;

public interface ReserveService {
    List<Reserve> getReserveList(Reserve reserve);
    Reserve getSingleReserve(Long reserveid);
//    int addReserve(Reserve reserve);
    int updateReserve(Reserve reserve);
//    int deleteReserve(Long reserveid);
}
