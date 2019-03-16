package com.house.dao;

import com.house.entity.Evaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
用户评价
 */
public interface EvaluateDao {
    int insertEvaluate(@Param("evaluate")Evaluate evaluate);
    int updateEvaluate(@Param("evaluate")Evaluate evaluate);
    int deleteEvaluate(@Param("evaluate")Evaluate evaluate);
    List<Evaluate> queryEvaluate(@Param("evaluate")Evaluate evaluate);
    Evaluate querySingleEvaluate(@Param("evaluate")Evaluate evaluate);
    int averageScore(@Param("servicerid") Long servicerid);
}
