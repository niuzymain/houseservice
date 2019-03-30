package com.house.dao;

import com.house.Basetest;
import com.house.entity.Recommend;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class RecommendDaoTest extends Basetest {
    @Autowired
    private RecommendDao recommendDao;

    @Test
    public void testInsert(){
        Recommend recommend = new Recommend();
        recommend.setUserId(1l);
        recommend.setServicerId(35l);
        recommend.setCheckTimes(1);
        recommend.setCreateTime(new Date());
        recommendDao.insertRecommend(recommend);
    }

    @Test
    public void testUpdate(){
        recommendDao.updateRecommendCheckTimes(2l);
    }

    @Test
    public void testSelect(){
        Recommend recommend = recommendDao.selectRecommend(3l,35l);
        System.out.println(recommend);
    }

}
