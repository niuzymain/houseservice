package com.house.service.superadmin;

import com.house.entity.Conditions;
import com.house.entity.WorkArea;

import java.util.List;

/*
展示可编辑类别
 */
public interface typeDisplay {
//     传入待展示类别名称，由前端规定
    List<Conditions> Display(String type);
//    展示城市下子区域
    List<WorkArea> displayChildArea(Long parentid);
}
