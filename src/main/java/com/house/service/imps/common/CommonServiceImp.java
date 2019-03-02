package com.house.service.imps.common;

import com.house.dao.DegreeDao;
import com.house.dao.ServiceTypeDao;
import com.house.dao.WorkAreaDao;
import com.house.entity.Degree;
import com.house.entity.ServiceType;
import com.house.entity.WorkArea;
import com.house.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonServiceImp implements CommonService {
    @Autowired
    private WorkAreaDao workAreaDao;
    @Autowired
    private ServiceTypeDao serviceTypeDao;
    @Autowired
    private DegreeDao degreeDao;


    @Override
    public List<WorkArea> getCitys() {
        return workAreaDao.queryArea();
    }

    @Override
    public List<ServiceType> getServicetype() {
        return serviceTypeDao.queryServiceType();
    }

    @Override
    public List<Degree> getDegree() {
        return degreeDao.queryDegreeList();
    }

    @Override
    public List<WorkArea> getLocals(Long parentid) {
        return workAreaDao.queryAreaByParent(parentid);
    }


}
