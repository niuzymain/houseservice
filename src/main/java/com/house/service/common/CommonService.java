package com.house.service.common;

import com.house.entity.Degree;
import com.house.entity.ServiceType;
import com.house.entity.WorkArea;

import java.util.List;

public interface CommonService {
    List<WorkArea> getCitys();

    List<ServiceType> getServicetype();

    List<Degree> getDegree();

    List<WorkArea> getLocals(Long parentid);

}
