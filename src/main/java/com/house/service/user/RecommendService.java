package com.house.service.user;

import com.house.entity.Servicer;

import java.util.List;

public interface RecommendService {
    int addUserTimes(long userid,long servicerid);
    List<Servicer> findRecommendServicer(Long userid) throws Exception;

}
