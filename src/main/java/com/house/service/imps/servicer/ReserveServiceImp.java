package com.house.service.imps.servicer;

import com.house.dao.ReserveDao;
import com.house.dao.ServicerDao;
import com.house.dto.ServicerExecution;
import com.house.entity.Reserve;
import com.house.entity.Servicer;
import com.house.enums.ServicerEnum;
import com.house.service.servicer.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReserveServiceImp implements ReserveService {
    @Autowired
    private ReserveDao reserveDao;
    @Autowired
    private ServicerDao servicerDao;

    @Override
    public List<Reserve> getReserveList(Reserve reserve) {
        try {
            return reserveDao.queryReserveList(reserve);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Reserve getSingleReserve(Long reserveid) {
        try {
            return reserveDao.querySingleReserve(reserveid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional
    public ServicerExecution operateReserve(Reserve reserve, String status) {
        int result;
        try {
            if (status.equals("accept")) {
                Servicer servicer = new Servicer();
                servicer.setServicerid(reserve.getServicer().getServicerid());
                //若状态为服务中，拦截接受操作
                Servicer servicerstatus = servicerDao.querySingleServicer(servicer);
                if(servicerstatus.getEnablestatus() == 2){
                    return new ServicerExecution(ServicerEnum.Servicing);
                }
                servicer.setEnablestatus(2);
                result = servicerDao.updateServicer(servicer);
                if (result <= 0) {
                    throw new RuntimeException();
                }
                result = reserveDao.updateReserve(reserve);
                if (result <= 0) {
                    throw new RuntimeException();
                }
                return new ServicerExecution(ServicerEnum.SUCCESS);
            } else if (status.equals("refuse")) {
                result = reserveDao.updateReserve(reserve);
                if (result <= 0) {
                    throw new RuntimeException();
                }
                return new ServicerExecution(ServicerEnum.SUCCESS);
            } else {
                return new ServicerExecution(ServicerEnum.TYPENULl);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
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
