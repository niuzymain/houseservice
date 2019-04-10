package com.house.dao;

import com.house.entity.RecommendCB;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecommendCBDao {
    int insertRecommendCB(RecommendCB recommendCB);
    int updateClickCount(Long cbid);
    RecommendCB selectRecommendCB(@Param("userid") long userid,@Param("servicerid") long servicerid);
    List<RecommendCB> queryServiceridByUser(Long userid);
}
