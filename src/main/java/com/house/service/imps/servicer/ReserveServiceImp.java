package com.house.service.imps.servicer;

import com.house.dao.ReserveDao;
import com.house.entity.Reserve;
import com.house.service.servicer.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReserveServiceImp implements ReserveService {
    @Autowired
    private ReserveDao reserveDao;
    @Override
    public List<Reserve> getReserveList(Reserve reserve) {
        try {
            return reserveDao.queryReserveList(reserve);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Reserve getSingleReserve(Long reserveid) {
        try {
            return reserveDao.querySingleReserve(reserveid);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

//    @Override
//    @Transactional
//    public int addReserve(Reserve reserve) {
//        int result;
//        try{
//            result = reserveDao.inseerReserve(reserve);
//            if(result <= 0){
//                throw new RuntimeException();
//            }
//            else{
//                return result;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException();
//        }
//    }

    @Override
    @Transactional
    public int updateReserve(Reserve reserve) {
        int result;
        try{
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

//    @Override
//    @Transactional
//    public int deleteReserve(Long reserveid) {
//        int result;
//        try{
//            result = reserveDao.deleteReserve(reserveid);
//            if(result <= 0){
//                throw new RuntimeException();
//            }
//            else{
//                return result;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException();
//        }
//    }

}
