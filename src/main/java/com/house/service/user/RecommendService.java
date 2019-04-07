package com.house.service.user;

import com.house.entity.Servicer;

import java.util.List;

public interface RecommendService {
    int addUserTimes(long userid,long servicerid);

    /*
    协同过滤，基于用户推荐
     */
    List<Servicer> RecommendServicerByUser(Long userid) throws Exception;

    /*
    根据工作区域服务类别推荐相似服务人员
     */
    List<Servicer> RecommendServicerByItem(Long servicerid) throws Exception;
}
