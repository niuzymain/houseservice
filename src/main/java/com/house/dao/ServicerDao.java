package com.house.dao;

import com.house.entity.Servicer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServicerDao {
    int insertServicer(Servicer servicer);

    int updateServicer(@Param("servicer") Servicer servicer);

    List<Servicer> queryQualify();

    Servicer querySingleServicer(@Param("condition") Servicer condition);

    List<Servicer> queryServicer(@Param("condition") Servicer condition);

    List<Servicer> queryServicerForUser(@Param("condition") Servicer condition,@Param("order") String order,@Param("index") int dbindex,@Param("size") int dbsize);

    int queryServicerCount(@Param("condition") Servicer servicer);
}
