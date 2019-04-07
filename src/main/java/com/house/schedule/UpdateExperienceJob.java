package com.house.schedule;

import com.house.dao.ServicerDao;
import com.house.entity.Servicer;
import com.house.service.superadmin.QualifyServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class UpdateExperienceJob {
    @Autowired
    private QualifyServicer qualifyServicer;
    @Autowired
    private ServicerDao servicerDao;

    public void udateExperience(){
        List<Servicer> servicerList = servicerDao.queryServicer(new Servicer());
        for (Servicer s:servicerList) {
            qualifyServicer.updateExperience(s);
        }
    }
}
