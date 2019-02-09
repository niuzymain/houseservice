package com.house.service.imps.superadmin;

import com.house.dao.DegreeDao;
import com.house.dao.ServiceTypeDao;
import com.house.dao.WorkAreaDao;
import com.house.entity.Conditions;
import com.house.service.superadmin.ItemsOperate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemsOperateImp implements ItemsOperate {
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
            else if(conditions.getServicetype() != null){
                result = serviceTypeDao.insertServiceType(conditions.getServicetype());
                if(result <= 0){
                    throw new RuntimeException();
                }
                else{
                    return 1;
                }
            }
            else if(conditions.getWorkarea() != null){
                result = workAreaDao.insertArea(conditions.getWorkarea());
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
            else if(conditions.getServicetype() != null){
                result = serviceTypeDao.updateServiceType(conditions.getServicetype());
                if(result <= 0){
                    throw new RuntimeException();
                }
                else{
                    return 1;
                }
            }
            else if(conditions.getWorkarea() != null){
                result = workAreaDao.updateArea(conditions.getWorkarea());
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
            else if(conditions.getServicetype() != null){
                result = serviceTypeDao.deleteServiceType(conditions.getServicetype().getServicetypeid());
                if(result <= 0){
                    throw new RuntimeException();
                }
                else{
                    return 1;
                }
            }
            else if(conditions.getWorkarea() != null){
                //若删除城市，先删除所有子区域
                if(conditions.getWorkarea().getParentarea() == null){
                    childresult = workAreaDao.deleteChildArea(conditions.getWorkarea().getWorkareaid());
                    result = workAreaDao.deleteArea(conditions.getWorkarea().getWorkareaid());
                }
                else{
                    childresult = 1;
                    result = workAreaDao.deleteArea(conditions.getWorkarea().getWorkareaid());
                }
                if(result <= 0 || childresult < 0){
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
