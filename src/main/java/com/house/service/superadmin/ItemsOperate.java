package com.house.service.superadmin;

import com.house.dao.AccountDao;
import com.house.dao.ServiceTypeDao;
import com.house.entity.Conditions;
import org.springframework.beans.factory.annotation.Autowired;

/*
管理员编辑功能service层
 */
public interface ItemsOperate {
    int addCondition(Conditions conditions);
    int updateCondition(Conditions conditions);
    int deleteCondition(Conditions conditions);

}
