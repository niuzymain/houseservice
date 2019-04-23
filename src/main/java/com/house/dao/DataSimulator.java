package com.house.dao;

import com.house.entity.*;
import org.apache.ibatis.annotations.Param;

/*
添加模拟数据
 */
public interface DataSimulator {
    int insertUser(User user);

    int insertServicer(Servicer servicer);

    int insertDegree(Degree degree);

    int insertServicetype(ServiceType serviceType);

    int insertWorkarea(WorkArea workArea);

    int insertReserve(@Param("reserve") Reserve reserve);

    int insertEvaluate(@Param("evaluate") Evaluate evaluate);

    int insertRecommend(Recommend recommend);

    int insertRecommendCB(RecommendCB recommendCB);
}
