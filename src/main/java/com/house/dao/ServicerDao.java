package com.house.dao;

import com.house.entity.Servicer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServicerDao {
    public int insertServicer(Servicer servicer);
    public int updateServicer(Servicer servicer);
    public List<Servicer> queryServicer();
    public Servicer queryServicerById(Long servicerid);
    public Servicer queryServicerByAccount(@Param("accountname")String accountname, @Param("password")String password);
}
