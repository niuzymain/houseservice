package com.house.service.superadmin;

import com.house.entity.Conditions;

/*
管理员编辑功能service层
 */
public interface ItemsOperate {
    int addCondition(Conditions conditions);
    int updateCondition(Conditions conditions);
    int deleteCondition(Conditions conditions);

}
