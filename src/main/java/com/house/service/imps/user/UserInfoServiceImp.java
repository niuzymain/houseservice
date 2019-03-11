package com.house.service.imps.user;

import com.house.dao.ReserveDao;
import com.house.entity.Reserve;
import com.house.service.user.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserInfoServiceImp implements UserInfoService {

    @Autowired
    private ReserveDao reserveDao;


    @Override
    public List<Reserve> selectReservelist(Reserve reserve) {
        return reserveDao.queryReserveList(reserve);
    }

    @Override
    public Reserve selectSingleReservelist(Long reserveid) {
        return reserveDao.querySingleReserve(reserveid);
    }

}
