package com.house.service.user;

import com.house.entity.Reserve;

import java.util.List;

public interface UserInfoService {
    List<Reserve> selectReservelist(Reserve reserve);
    Reserve selectSingleReservelist(Long reserveid);
}
