package com.house.dao;

import com.house.entity.Servicer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServicerDao {
    int insertServicer(Servicer servicer);

    int updateServicer(@Param("servicer") Servicer servicer);

    int updateServiceCount(Long servicerid);

    List<Servicer> queryQualify(@Param("checkstatus") int checkstatus);

    Servicer querySingleServicer(@Param("condition") Servicer condition);

    List<Servicer> queryServicer(@Param("condition") Servicer condition);

    List<Servicer> queryServicerForUser(@Param("condition") Servicer condition,@Param("order") String order,@Param("index") int dbindex,@Param("size") int dbsize);

    List<Servicer> queryServicerForRecommend(@Param("idlist") List<Long> idList);

    int queryServicerCount(@Param("condition") Servicer servicer);
}
