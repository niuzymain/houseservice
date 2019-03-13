package com.house.service.imps.superadmin;

import com.house.dao.AdminMsgDao;
import com.house.dao.EvaluateDao;
import com.house.dao.ReserveDao;
import com.house.dao.ServicerDao;
import com.house.entity.*;
import com.house.service.superadmin.QualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
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

    public static SimpleDateFormat sft = new SimpleDateFormat("yyyy年MM月dd日");

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
    public int illegalCommentOperate(long evaluateid) {
        int result;
        Evaluate evaluate = new Evaluate();
        evaluate.setEvaluateid(evaluateid);
        evaluate.setEvaluatedes("----该评论违规，已被屏蔽----");
        evaluate.setEnablestatus(-1);
        /////////////////根据id查找相关评论信息//////////////////////////////
        Evaluate specific = evaluateDao.querySingleEvaluate(evaluate);
        //////////////////////系统消息通知用户///////////////////////////////////
        AdminMsg adminMsg = new AdminMsg();
        User user = new User();
        user.setUserid(specific.getUser().getUserid());
        adminMsg.setUser(user);
        adminMsg.setType(0);
        adminMsg.setCreatetime(new Date());
        adminMsg.setAdminmsgdes("您于"+ sft.format(specific.getCreatetime())+"的评论违规，已被系统屏蔽！");
        try{
            result = evaluateDao.updateEvaluate(evaluate);
            adminMsgDao.insertAdminmsg(adminMsg);
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
    public Reserve specificReserveQualify(Long reserveid) {
        try{
            Reserve reserve = reserveDao.querySingleReserve(reserveid);
            return reserve;
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
