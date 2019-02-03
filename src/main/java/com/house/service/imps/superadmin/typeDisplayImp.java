package com.house.service.imps.superadmin;

import com.house.dao.DegreeDao;
import com.house.dao.ServiceTypeDao;
import com.house.dao.WorkAreaDao;
import com.house.entity.Conditions;
import com.house.entity.Degree;
import com.house.entity.ServiceType;
import com.house.entity.WorkArea;
import com.house.service.superadmin.typeDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class typeDisplayImp implements typeDisplay {
    @Autowired
    private DegreeDao degreeDao;
    @Autowired
    private ServiceTypeDao serviceTypeDao;
    @Autowired
    private WorkAreaDao workAreaDao;
    @Override
    public List<Conditions> Display(String type) {
        List<Conditions> conditionsList = new ArrayList<>();
        if(type.equals("服务类别")){
            List<ServiceType> serviceTypeList = new ArrayList<>();
            serviceTypeList = serviceTypeDao.queryServiceType();
            for (int i=0;i<serviceTypeList.size();i++) {
                Conditions conditions = new Conditions();
                conditions.setServiceType(serviceTypeList.get(i));
                conditionsList.add(conditions);
            }
        }
        else if(type.equals("学历")){
            List<Degree> degreeList = new ArrayList<>();
            degreeList = degreeDao.queryDegreeList();
            for (int i=0;i<degreeList.size();i++) {
                Conditions conditions = new Conditions();
                conditions.setDegree(degreeList.get(i));
                conditionsList.add(conditions);
            }
        }
        else if(type.equals("城市")){
            List<WorkArea> workAreaList = new ArrayList<>();
            workAreaList = workAreaDao.queryArea();
            for (int i=0;i<workAreaList.size();i++) {
                Conditions conditions = new Conditions();
                conditions.setWorkArea(workAreaList.get(i));
                conditionsList.add(conditions);
            }
        }
        return conditionsList;
    }

    @Override
    public List<WorkArea> displayChildArea(Long parentid) {
        return workAreaDao.queryAreaByParent(parentid);
    }
}
