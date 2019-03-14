package com.house.service.imps.user;

import com.house.dao.AdminMsgDao;
import com.house.entity.AdminMsg;
import com.house.entity.User;
import com.house.service.user.UserMessageService;
import com.house.util.SortUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class UserMessageServiceImp implements UserMessageService {
    @Autowired
    private AdminMsgDao adminMsgDao;

    @Override
    public List<AdminMsg> getMessageList(User user) {
        List<AdminMsg> commonlist = adminMsgDao.queryUserMessageList();
        AdminMsg adminMsg = new AdminMsg();
        adminMsg.setUser(user);
        List<AdminMsg> specificlist = adminMsgDao.querySpecificList(adminMsg);
        specificlist.addAll(commonlist);
        SortUtil.sortMessageList(specificlist);
        return specificlist;
    }
}
