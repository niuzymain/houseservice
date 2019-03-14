package com.house.service.imps.superadmin;

import com.house.dao.AdminMsgDao;
import com.house.dao.EvaluateDao;
import com.house.dao.ReserveDao;
import com.house.dao.ServicerDao;
import com.house.entity.*;
import com.house.service.superadmin.QualifyServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class QualifyServicerImp implements QualifyServicer {
    @Autowired
    private ServicerDao servicerDao;
    @Autowired
    private AdminMsgDao adminMsgDao;

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

}
