package com.house.dao;

import com.house.Basetest;
import com.house.entity.WorkArea;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class WorkAreaDaotest extends Basetest {
    @Autowired
    private WorkAreaDao workAreaDao;

    @Test
    public void testinsertArea(){
        WorkArea workArea = new WorkArea();
        WorkArea parentarea = new WorkArea();
        parentarea.setWorkareaid(1);
        workArea.setWorkareaname("area3");
        workArea.setParentarea(parentarea);
        int result = workAreaDao.insertArea(workArea);
        assertEquals(1,result);
    }

    @Test
    public void testupdateArea(){
        WorkArea workArea = new WorkArea();
        workArea.setWorkareaid(2);
        workArea.setWorkareaname("update area");
        int result = workAreaDao.updateArea(workArea);
        assertEquals(1,result);
    }

    @Test
    public void testdeleteArea(){
        int result = workAreaDao.deleteArea(3l);
        assertEquals(1,result);
    }

    @Test
    public void testdeleteChildArea(){
        int result = workAreaDao.deleteChildArea(1l);
        assertEquals(1,result);
    }

    @Test
    public void testqueryArea(){
        List<WorkArea> workAreas = new ArrayList<>();
        workAreas = workAreaDao.queryArea();
        assertEquals(1,workAreas.size());
        System.out.println("name:"+workAreas.get(0).getWorkareaname());
    }

    @Test
    public void testqueryAreaByParent(){
        List<WorkArea> workAreas = new ArrayList<>();
        workAreas = workAreaDao.queryAreaByParent(1l);
        assertEquals(2,workAreas.size());
        for (WorkArea w:workAreas) {
            System.out.println("name:"+w.getWorkareaname());
        }
    }
}
