package com.house.service.servicer;

import com.house.entity.AdminMsg;
import com.house.entity.Servicer;

import java.util.List;

public interface MessageService {
    List<AdminMsg> checkMessage(Servicer servicer);
}
