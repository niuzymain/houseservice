package com.house.service.imps.servicer;

import com.house.dao.AdminMsgDao;
import com.house.entity.AdminMsg;
import com.house.entity.Servicer;
import com.house.service.servicer.MessageService;
import com.house.util.SortUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.Comparator;
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
            /////////////////////服务人员和全用户消息//////////////////////////////////
            List<AdminMsg> adminMsgList = adminMsgDao.queryServicerMessageList();
            /////////////////////特定服务人员消息///////////////////////////////////////
            List<AdminMsg> specificList = adminMsgDao.querySpecificList(adminMsg);
            adminMsgList.addAll(specificList);
            /////////////////////////按创建日期排序/ //////////////////////////////
            SortUtil.sortMessageList(adminMsgList);
            return adminMsgList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
