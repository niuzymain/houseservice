package com.house.service.imps.user;

import com.house.dao.ReserveDao;
import com.house.entity.Reserve;
import com.house.service.user.UserReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Override
    public int cancelReserve(Reserve reserve) {
        int result;
        try{
            reserve.setCreatetime(new Date());
            result = reserveDao.updateReserve(reserve);
            if(result <= 0){
                throw new RuntimeException();
            }
            else{
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public List<Reserve> selectReservelist(Reserve reserve) {
        return reserveDao.queryReserveList(reserve);
    }

    @Override
    public Reserve selectSingleReservelist(Long reserveid) {
        return reserveDao.querySingleReserve(reserveid);
    }

}
