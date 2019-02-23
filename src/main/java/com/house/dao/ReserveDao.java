package com.house.dao;

import com.house.entity.Reserve;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReserveDao {
    int inseerReserve(@Param("reserve") Reserve reserve);
    int updateReserve(@Param("reserve") Reserve reserve);
    int deleteReserve(@Param("reserveid") Long reserveid);
    List<Reserve> queryReserveList(@Param("condition") Reserve condition);
    Reserve querySingleReserve(@Param("reserveid") Long reserveid);
}
