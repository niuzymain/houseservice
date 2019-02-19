package com.house.service.superadmin;

import com.house.entity.AdminMsg;
import com.house.entity.Servicer;

import java.util.List;

/*
服务人员审核service层
 */

public interface QualifyService {
    List<Servicer> qualifyList();
    Servicer getQualifyById(Long servicerid);
    int qualifyOperate(AdminMsg adminMsg, int checkstatus, boolean ispass);
}
