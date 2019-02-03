package com.house.service.imps.superadmin;

import com.house.dao.DegreeDao;
import com.house.dao.ServiceTypeDao;
import com.house.dao.WorkAreaDao;
import com.house.entity.Conditions;
import com.house.service.superadmin.typeOperate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class typeOperateImp implements typeOperate {
    @Autowired
    private DegreeDao degreeDao;
    @Autowired
    private ServiceTypeDao serviceTypeDao;
    @Autowired
    private WorkAreaDao workAreaDao;

    @Transactional
    @Override
    public int addCondition(Conditions conditions) {
        int result;
        try{
            if(conditions.getDegree() != null){
                result = degreeDao.insertDegree(conditions.getDegree());
                if(result <= 0){
                    throw new RuntimeException();
                }
                else{
                    return 1;
                }
            }
            else if(conditions.getServiceType() != null){
                result = serviceTypeDao.insertServiceType(conditions.getServiceType());
                if(result <= 0){
                    throw new RuntimeException();
                }
                else{
                    return 1;
                }
            }
            else if(conditions.getWorkArea() != null){
                result = workAreaDao.insertArea(conditions.getWorkArea());
                if(result <= 0){
                    throw new RuntimeException();
                }
                else{
                    return 1;
                }
            }
            else{
                return -1;
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Transactional
    @Override
    public int updateCondition(Conditions conditions) {
        int result;
        try{
            if(conditions.getDegree() != null){
                result = degreeDao.updateDegree(conditions.getDegree());
                if(result <= 0){
                    throw new RuntimeException();
                }
                else{
                    return 1;
                }
            }
            else if(conditions.getServiceType() != null){
                result = serviceTypeDao.updateServiceType(conditions.getServiceType());
                if(result <= 0){
                    throw new RuntimeException();
                }
                else{
                    return 1;
                }
            }
            else if(conditions.getWorkArea() != null){
                result = workAreaDao.updateArea(conditions.getWorkArea());
                if(result <= 0){
                    throw new RuntimeException();
                }
                else{
                    return 1;
                }

            }
            else{
                return -1;
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Transactional
    @Override
    public int deleteCondition(Conditions conditions) {
        int result;
        int childresult;
        try{
            if(conditions.getDegree() != null){
                result = degreeDao.deleteDegree(conditions.getDegree().getDegreeid());
                if(result <= 0){
                    throw new RuntimeException();
                }
                else{
                    return 1;
                }
            }
            else if(conditions.getServiceType() != null){
                result = serviceTypeDao.deleteServiceType(conditions.getServiceType().getServicetypeid());
                if(result <= 0){
                    throw new RuntimeException();
                }
                else{
                    return 1;
                }
            }
            else if(conditions.getWorkArea() != null){
                //若删除城市，先删除所有子区域
                if(conditions.getWorkArea().getParentarea() == null){
                    childresult = workAreaDao.deleteChildArea(conditions.getWorkArea().getWorkareaid());
                    result = workAreaDao.deleteArea(conditions.getWorkArea().getWorkareaid());
                }
                else{
                    childresult = 1;
                    result = workAreaDao.deleteArea(conditions.getWorkArea().getWorkareaid());
                }
                if(result <= 0 || childresult <= 0){
                    throw new RuntimeException();
                }
                else{
                    return 1;
                }

            }
            else{
                return -1;
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
