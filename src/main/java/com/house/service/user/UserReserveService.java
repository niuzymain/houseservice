package com.house.service.user;

import com.house.entity.Evaluate;
import com.house.entity.Reserve;

import java.util.List;

public interface UserReserveService {
    int createReserve(Reserve reserve);
    int cancelReserve(Reserve reserve);
    List<Reserve> selectReservelist(Reserve reserve);
    Reserve selectSingleReservelist(Long reserveid);
    int writeEvaluate(Evaluate evaluate,long reserveid);
    Evaluate getEvaluate(long evaluateid);
}
