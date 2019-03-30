package com.house.dao;

import com.house.entity.Recommend;
import org.apache.ibatis.annotations.Param;

public interface RecommendDao {
    int insertRecommend(Recommend recommend);
    int updateRecommendCheckTimes(@Param("recommendid") long recommendid);
    Recommend selectRecommend(@Param("userid") long userid,@Param("servicerid") long servicerid);
}
