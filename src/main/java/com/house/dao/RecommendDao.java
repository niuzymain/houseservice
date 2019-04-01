package com.house.dao;

import com.house.entity.Recommend;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface RecommendDao {
    int insertRecommend(Recommend recommend);
    int updateRecommendCheckTimes(@Param("recommendid") long recommendid, @Param("createtime")Date createtime);
    Recommend selectRecommend(@Param("userid") long userid,@Param("servicerid") long servicerid);
}
