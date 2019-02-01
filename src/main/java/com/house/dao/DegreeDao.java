package com.house.dao;

import com.house.entity.Degree;

import java.util.List;

public interface DegreeDao {
    int insertDegree(Degree degree);
    int updateDegree(Degree degree);
    int deleteDegree(Long degreeid);
    List<Degree> queryDegreeList();

}
