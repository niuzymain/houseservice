package com.house.service.imps.superadmin;

import com.house.dao.AdminMsgDao;
import com.house.dao.ServicerDao;
import com.house.entity.AdminMsg;
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

    @Override
    public List<Servicer> qualifyList() {
        return servicerDao.queryQualify();
    }

    @Override
    public Servicer getQualifyById(Long servicerid) {
        Servicer condition = new Servicer();
        condition.setServicerid(servicerid);
        return servicerDao.querySingleServicer(condition);
    }

    @Override
    @Transactional
    public int qualifyOperate(AdminMsg adminMsg,Servicer servicer) {
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
