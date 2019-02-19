package com.house.service.imps.superadmin;

import com.house.dao.ServicerDao;
import com.house.entity.AdminMsg;
import com.house.entity.Servicer;
import com.house.service.superadmin.QualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QualifyServicerImp implements QualifyService {
    @Autowired
    private ServicerDao servicerDao;

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
    public int qualifyOperate(AdminMsg adminMsg,int checkstatus,boolean ispass) {
        return 0;
    }
}
