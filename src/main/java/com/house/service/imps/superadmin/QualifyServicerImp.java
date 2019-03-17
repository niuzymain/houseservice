package com.house.service.imps.superadmin;

import com.house.dao.AdminMsgDao;
import com.house.dao.EvaluateDao;
import com.house.dao.ReserveDao;
import com.house.dao.ServicerDao;
import com.house.dto.ServicerExecution;
import com.house.entity.*;
import com.house.enums.ServicerEnum;
import com.house.service.superadmin.QualifyServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
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
    public List<Servicer> servicerQualifyList(int checkstatus) {
        return servicerDao.queryQualify(checkstatus);
    }

    @Override
    public Servicer getServicerQualifyById(Long servicerid) {
        Servicer condition = new Servicer();
        condition.setServicerid(servicerid);
        return servicerDao.querySingleServicer(condition);
    }

    @Override
    @Transactional
    public int notPassQualifyOperate(AdminMsg adminMsg, Servicer servicer) {
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
    public ServicerExecution passQualifyOperate(Servicer servicer) {
        AdminMsg adminMsg = new AdminMsg();
        adminMsg.setAdminmsgdes("您的审核以通过，请等待我们联系您签署合同");
        adminMsg.setType(0);
        adminMsg.setServicer(servicer);
        int result = adminMsgDao.insertAdminmsg(adminMsg);
        if(result <= 0){
            throw new RuntimeException("插入消息错误");
        }
        servicer.setCheckstatus(1);
        result = servicerDao.updateServicer(servicer);
        if(result <= 0){
            throw new RuntimeException("更新服务人员错误");
        }
        else{
            return new ServicerExecution(ServicerEnum.SUCCESS);
        }
    }

    @Override
    public int qualifySalary(Servicer servicer) {
        return 0;
    }

    @Override
    public ServicerExecution uploadServicerContract(Long servicerid, InputStream inputStream, String filename) {
        return null;
    }


}
