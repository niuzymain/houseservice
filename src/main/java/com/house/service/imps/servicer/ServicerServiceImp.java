package com.house.service.imps.servicer;

import com.house.dao.ServicerDao;
import com.house.entity.Servicer;
import com.house.service.servicer.ServicerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicerServiceImp implements ServicerService {
    @Autowired
    private ServicerDao servicerDao;

    @Override
    @Transactional
    public int editServicer(Servicer servicer) {
        try{
            int result = servicerDao.updateServicer(servicer);
            if(result <= 0){
                throw new RuntimeException();
            }
            else{
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
}
