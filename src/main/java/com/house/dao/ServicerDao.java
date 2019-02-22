package com.house.dao;

import com.house.entity.Servicer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServicerDao {
    public int insertServicer(Servicer servicer);
    public int updateServicer(@Param("servicer") Servicer servicer);
    public List<Servicer> queryServicer(@Param("condition") Servicer condition);
    public List<Servicer> queryQualify();
    public Servicer querySingleServicer(@Param("condition")Servicer condition);
}
