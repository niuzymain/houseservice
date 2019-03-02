//package com.house.service;
//
//import com.house.Basetest;
//import com.house.dao.AdminMsgDao;
//import com.house.dao.ServicerDao;
//import com.house.entity.AdminMsg;
//import com.house.entity.Servicer;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//import java.util.List;
//
//public class UpdateServicer extends Basetest {
//    @Autowired
//    private ServicerDao servicerDao;
//    @Autowired
//    private AdminMsgDao adminMsgDao;
//    @Test
//    public void addTime(){
//        List<Servicer> servicerList = servicerDao.queryServicer(new Servicer());
//        for (Servicer s:servicerList) {
//            s.setCreatetime(new Date());
//            s.setLastedittime(new Date());
//        }
//        for(int i=0;i<servicerList.size();i++){
//            servicerDao.updateServicer(servicerList.get(i));
//        }
//    }
//    @Test
//    public void addMsg(){
//        AdminMsg adminMsg = new AdminMsg();
//        adminMsg.setAdminmsgdes("desdesdesdes");
//        adminMsgDao.insertAdminmsg(adminMsg);
//    }
//}
