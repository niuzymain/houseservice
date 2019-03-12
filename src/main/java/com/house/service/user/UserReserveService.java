package com.house.service.user;

import com.house.entity.Reserve;

import java.util.List;

public interface UserReserveService {
    int createReserve(Reserve reserve);
    int cancelReserve(Reserve reserve);
    List<Reserve> selectReservelist(Reserve reserve);
    Reserve selectSingleReservelist(Long reserveid);
}
