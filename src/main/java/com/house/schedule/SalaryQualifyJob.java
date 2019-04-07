package com.house.schedule;

import com.house.dao.ServicerDao;
import com.house.entity.Servicer;
import com.house.service.superadmin.QualifyServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class SalaryQualifyJob {
    @Autowired
    private QualifyServicer qualifyServicer;
    @Autowired
    private ServicerDao servicerDao;
    public void salaryQualify(){
        List<Servicer> servicerList = servicerDao.queryServicer(new Servicer());
        for (Servicer s:servicerList) {
//            System.out.print("修改人员："+s.getServicername());
            int salary = qualifyServicer.qualifySalary(s);
//            System.out.print("改前薪水："+s.getServicerprice());
            s.setServicerprice(salary);
//            System.out.println("修改后"+s.getServicerprice());
            servicerDao.updateServicer(s);
        }
    }
}
