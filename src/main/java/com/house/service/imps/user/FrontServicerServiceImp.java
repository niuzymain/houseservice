package com.house.service.imps.user;

import com.house.dao.ReserveDao;
import com.house.dao.ServicerDao;
import com.house.entity.Reserve;
import com.house.entity.Servicer;
import com.house.service.servicer.ReserveService;
import com.house.service.user.FrontServicerService;
import com.house.util.PageIndexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FrontServicerServiceImp implements FrontServicerService {

    @Autowired
    private ServicerDao servicerDao;

    @Autowired
    private ReserveDao reserveDao;

    @Override
    public int ServicerCount(Servicer servicer) {
        return servicerDao.queryServicerCount(servicer);
    }

    @Override
    public List<Servicer> getAvailableServicer(Servicer servicer, String order, int pageindex, int pagesize) {
        int dbindex = PageIndexUtil.TranstoDBIndex(pageindex,pagesize);
        return servicerDao.queryServicerForUser(servicer,order,dbindex,pagesize);
    }

    @Override
    public Servicer getSpecificServicer(Long servicerid) {
        Servicer servicer = new Servicer();
        servicer.setServicerid(servicerid);
        return servicerDao.querySingleServicer(servicer);
    }

    @Override
    @Transactional
    public int orderServicer(Reserve reserve) {
        return 0;
    }
}

