package com.house.service.user;

import com.house.entity.AdminMsg;
import com.house.entity.User;

import java.util.List;

public interface UserMessageService {
    List<AdminMsg> getMessageList(User user);
}
