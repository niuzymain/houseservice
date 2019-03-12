package com.house.service.imps.servicer;

import com.house.dao.AdminMsgDao;
import com.house.entity.AdminMsg;
import com.house.entity.Servicer;
import com.house.service.servicer.MessageService;
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
            Collections.sort(adminMsgList, new Comparator<AdminMsg>(){
                /*
                 * int compare(Person p1, Person p2) 返回一个基本类型的整型，
                 * 返回负数表示：p1 小于p2，
                 * 返回0 表示：p1和p2相等，
                 * 返回正数表示：p1大于p2
                 */
                @Override
                public int compare(AdminMsg o1, AdminMsg o2) {
                    if(o1.getCreatetime().getTime() < o2.getCreatetime().getTime()){
                        return 1;
                    }
                    if(o1.getCreatetime().getTime() == o2.getCreatetime().getTime()){
                        return 0;
                    }
                    return -1;
                }
            });
            return adminMsgList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
