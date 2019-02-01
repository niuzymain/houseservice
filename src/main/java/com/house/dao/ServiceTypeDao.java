package com.house.dao;

import com.house.entity.ServiceType;

import java.util.List;

public interface ServiceTypeDao {
    int insertServiceType(ServiceType serviceType);
    int deleteServiceType(Long servicetypeid);
    int updateServiceType(ServiceType serviceType);
    List<ServiceType> queryServiceType();
}
