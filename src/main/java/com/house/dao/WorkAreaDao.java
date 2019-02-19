package com.house.dao;

import com.house.entity.WorkArea;

import java.util.List;

public interface WorkAreaDao {
//    添加地区
    int insertArea(WorkArea workArea);
//    修改地区 ,只能修改区域
    int updateArea(WorkArea workArea);
//    删除地区
    int deleteArea(Long workareaid);
//    删除城市下的区域信息
    int deleteChildArea(Long parentareaid);
//    选择所有城市
    List<WorkArea> queryArea();
//    选择某城市下的所有区域
    List<WorkArea> queryAreaByParent(Long parentareaid);

    String queryParentArea(Long areaid);
}
