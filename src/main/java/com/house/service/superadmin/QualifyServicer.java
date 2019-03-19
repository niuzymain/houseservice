package com.house.service.superadmin;

import com.house.dto.ServicerExecution;
import com.house.entity.AdminMsg;
import com.house.entity.Evaluate;
import com.house.entity.Reserve;
import com.house.entity.Servicer;

import java.io.InputStream;
import java.util.List;

/*
审核service层
 */

public interface QualifyServicer {
    /*
    服务人员审核
     */
    List<Servicer> servicerQualifyList(int checkstatus);
    Servicer getServicerQualifyById(Long servicerid);
    int notPassQualifyOperate(AdminMsg adminMsg, Servicer servicer);
    ServicerExecution passQualifyOperate(Servicer servicer);
    int qualifySalary(Servicer servicer);
    int qualifyInitialSalary(Servicer servicer);
    void updateExperience(Servicer servicer);
    ServicerExecution uploadServicerContract(Long servicerid,InputStream inputStream,String filename);
}
