package com.house.service.user;

import com.house.entity.Evaluate;
import com.house.entity.Servicer;

import java.util.List;

public interface RecommendService {
    /*
    根据评分写入推荐表recommend
     */
    int addUserPrefer(Evaluate evaluate);

    /*
   根据点击事件写入推荐表recommendcb
    */
    int addUserClick(Long userid,Long servicerid);

    /*
    协同过滤，基于用户推荐
     */
    List<Servicer> RecommendServicerByUserCF(Long userid) throws Exception;

    /*
    根据工作区域服务类别推荐相似服务人员
     */
    List<Servicer> simpleRecommendServicer(Long servicerid) throws Exception;

    /*
    基于内容推荐
     */
    List<Servicer> RecommendServicerByCB(Long userid) throws Exception;
}
