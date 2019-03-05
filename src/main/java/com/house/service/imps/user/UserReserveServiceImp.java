package com.house.service.imps.user;

import com.house.dao.ReserveDao;
import com.house.entity.Reserve;
import com.house.service.user.UserReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserReserveServiceImp implements UserReserveService {
    @Autowired
    private ReserveDao reserveDao;

    @Override
    public int createReserve(Reserve reserve) {
        int result=0;
        try{
            //////////////////////////////////////开启定时任务///////////////////////////////////////////
            /*

             */
            //////////////////////////////////////添加预约信息//////////////////////////////////////////
            reserve.setEnablestatus(0);
            result = reserveDao.inseerReserve(reserve);
            if(result <= 0){
                throw  new RuntimeException();
            }
            else{
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
