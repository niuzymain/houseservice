package com.house.service.servicer;

import com.house.dto.ServicerExecution;
import com.house.entity.Reserve;

import java.util.List;

public interface ReserveService {
    List<Reserve> getReserveList(Reserve reserve);
    Reserve getSingleReserve(Long reserveid);
    /*
    status:接受状态，拒绝或接受
    若接受则servicer状态值为服务中
     */
    ServicerExecution operateReserve(Reserve reserve, String status);
//    int addReserve(Reserve reserve);
//    int deleteReserve(Long reserveid);
}
