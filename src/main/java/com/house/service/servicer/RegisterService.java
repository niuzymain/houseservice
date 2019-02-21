package com.house.service.servicer;

import com.house.entity.Degree;
import com.house.entity.ServiceType;
import com.house.entity.WorkArea;

import java.util.List;

public interface RegisterService {
    List<WorkArea> getCitys();
    List<ServiceType> getServicetype();
    List<Degree> getDegree();
    List<WorkArea> getLocals(Long parentid);

}
