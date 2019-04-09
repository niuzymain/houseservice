package com.house.service.user;

import com.house.entity.Evaluate;
import com.house.entity.Servicer;

import java.util.List;

public interface RecommendService {
    /*
    根据评分写入推荐表
     */
    int addUserPrefer(Evaluate evaluate);

    /*
    协同过滤，基于用户推荐
     */
    List<Servicer> RecommendServicerByUser(Long userid) throws Exception;

    /*
    根据工作区域服务类别推荐相似服务人员
     */
    List<Servicer> RecommendServicerByItem(Long servicerid) throws Exception;
}
