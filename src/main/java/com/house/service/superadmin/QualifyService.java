package com.house.service.superadmin;

import com.house.entity.AdminMsg;
import com.house.entity.Evaluate;
import com.house.entity.Reserve;
import com.house.entity.Servicer;

import java.util.List;

/*
审核service层
 */

public interface QualifyService {
    /*
    服务人员审核
     */
    List<Servicer> servicerQualifyList();
    Servicer getServicerQualifyById(Long servicerid);
    int servicerQualifyOperate(AdminMsg adminMsg, Servicer servicer);

    /*
    评论审核
     */
    List<Evaluate> commentQualifyList();
    int illegalCommentOperate(long evaluateid);

    /*
    预约处理
     */
    List<Reserve> reserveQualifyList(int enablestatus);
    Reserve specificReserveQualify(Long reserveid);
    int reserveQualifyOperate(Reserve reserve);

}
