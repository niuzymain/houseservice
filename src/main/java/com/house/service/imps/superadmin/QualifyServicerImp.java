package com.house.service.imps.superadmin;

import com.house.dao.AdminMsgDao;
import com.house.dao.EvaluateDao;
import com.house.dao.ReserveDao;
import com.house.dao.ServicerDao;
import com.house.entity.AdminMsg;
import com.house.entity.Evaluate;
import com.house.entity.Reserve;
import com.house.entity.Servicer;
import com.house.service.superadmin.QualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class QualifyServicerImp implements QualifyService {
    @Autowired
    private ServicerDao servicerDao;
    @Autowired
    private AdminMsgDao adminMsgDao;
    @Autowired
    private EvaluateDao evaluateDao;
    @Autowired
    private ReserveDao reserveDao;

    @Override
    public List<Servicer> servicerQualifyList() {
        return servicerDao.queryQualify();
    }

    @Override
    public Servicer getServicerQualifyById(Long servicerid) {
        Servicer condition = new Servicer();
        condition.setServicerid(servicerid);
        return servicerDao.querySingleServicer(condition);
    }

    @Override
    @Transactional
    public int servicerQualifyOperate(AdminMsg adminMsg, Servicer servicer) {
        int msgresult = 0;
        int servicerresult = 0;
        try {
            if(adminMsg != null){
                adminMsg.setCreatetime(new Date());
                msgresult = adminMsgDao.insertAdminmsg(adminMsg);
            }
            else{
                msgresult = 1;
            }
            servicerresult = servicerDao.updateServicer(servicer);
            if(msgresult == 1 && servicerresult == 1){
                return 1;
            }
            else{
                throw new RuntimeException();
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Override
    public List<Evaluate> commentQualifyList() {
        try{
            List<Evaluate> evaluateList = evaluateDao.queryEvaluate(new Evaluate());
            return evaluateList;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int commentQualifyOperate(Evaluate evaluate) {
        int result;
        try{
            result = evaluateDao.updateEvaluate(evaluate);
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
    public List<Reserve> reserveQualifyList(int enablestatus) {
        try{
            Reserve reserve = new Reserve();
            reserve.setEnablestatus(enablestatus);
            List<Reserve> reserveList = reserveDao.queryReserveList(reserve);
            return reserveList;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int reserveQualifyOperate(Reserve reserve) {
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
}
