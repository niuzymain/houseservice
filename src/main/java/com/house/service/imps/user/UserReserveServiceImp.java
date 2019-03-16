package com.house.service.imps.user;

import com.house.dao.EvaluateDao;
import com.house.dao.ReserveDao;
import com.house.dao.ServicerDao;
import com.house.entity.Evaluate;
import com.house.entity.Reserve;
import com.house.entity.Servicer;
import com.house.service.user.UserReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserReserveServiceImp implements UserReserveService {
    @Autowired
    private ReserveDao reserveDao;

    @Autowired
    private EvaluateDao evaluateDao;

    @Autowired
    private ServicerDao servicerDao;

    @Override
    public int createReserve(Reserve reserve) {
        int result=0;
        try{
            //////////////////////////////////////开启定时任务///////////////////////////////////////////
                    /*


                     */
            //////////////////////////////////////添加预约信息//////////////////////////////////////////
            reserve.setEnablestatus(0);
            reserve.setCreatetime(new Date());
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

    @Override
    @Transactional
    public int writeEvaluate(Evaluate evaluate,long reserveid) {
        int result = 0;
        int score;
        try{
            Reserve currentreserve = reserveDao.querySingleReserve(reserveid);
            evaluate.setCreatetime(new Date());
            evaluate.setServicer(currentreserve.getServicer());
            result = evaluateDao.insertEvaluate(evaluate);
            if(result <= 0){
                throw new RuntimeException("添加评论出现异常");
            }
/////////////////////////////关联相应预约信息//////////////////////////////////////
            Reserve reserve = new Reserve();
            reserve.setReserveid(reserveid);
            reserve.setEvaluate(evaluate);
            result = reserveDao.updateReserve(reserve);
            if(result <= 0){
                throw new RuntimeException("关联预约信息出现异常");
            }
////////////////////////////////////更新服务人员评分//////////////////////////////////////////////
            score = evaluateDao.averageScore(evaluate.getServicer().getServicerid());
            Servicer servicer = currentreserve.getServicer();
            servicer.setServicerscore(score);
            result = servicerDao.updateServicer(servicer);
            if(result <= 0){
                throw new RuntimeException("更新服务人员评分出现异常");
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("出现异常");
        }
    }

    @Override
    public Evaluate getEvaluate(long evaluateid) {
        Evaluate evaluate = new Evaluate();
        evaluate.setEvaluateid(evaluateid);
        return evaluateDao.querySingleEvaluate(evaluate);
    }

}
