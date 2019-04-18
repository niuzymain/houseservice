package com.house.service.superadmin;

import com.house.dto.EvaluateExecution;
import com.house.entity.AdminMsg;
import com.house.entity.Evaluate;
import com.house.entity.Reserve;
import com.house.entity.Servicer;

import java.util.List;

/*
审核service层
 */

public interface QualifyCommentService {
    /*
    评论审核
     */
    EvaluateExecution commentQualifyList(int pageindex,int pagesize);
    int illegalCommentOperate(long evaluateid);
}
