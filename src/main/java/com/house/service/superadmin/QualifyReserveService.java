package com.house.service.superadmin;

import com.house.entity.AdminMsg;
import com.house.entity.Evaluate;
import com.house.entity.Reserve;
import com.house.entity.Servicer;

import java.io.InputStream;
import java.util.List;

/*
审核service层
 */

public interface QualifyReserveService {
    /*
    预约处理
     */
    List<Reserve> reserveQualifyList(int enablestatus);
    Reserve specificReserveQualify(Long reserveid);
    int handleReserve(long reserveid);
    int confirmReserve(Reserve reserve, InputStream contract,String filename);
    int overReserve(long reserveid);
}
