package com.house.service.imps.servicer;

import com.house.dao.AdminMsgDao;
import com.house.entity.AdminMsg;
import com.house.entity.Servicer;
import com.house.service.servicer.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImp implements MessageService {
    @Autowired
    private AdminMsgDao adminMsgDao;

    @Override
    public List<AdminMsg> checkMessage(Servicer servicer){
        AdminMsg adminMsg = new AdminMsg();
        adminMsg.setServicer(servicer);
        try{
            List<AdminMsg> adminMsgList = adminMsgDao.queryMessageList(adminMsg);
            return adminMsgList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
