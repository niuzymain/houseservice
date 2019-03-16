package com.house.service;

import com.house.Basetest;
import com.house.entity.Evaluate;
import com.house.entity.Servicer;
import com.house.entity.User;
import com.house.service.user.UserReserveService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EvaluateTest extends Basetest {
    @Autowired
    private UserReserveService userReserveService;

    @Test
    public void test(){
        Evaluate evaluate = new Evaluate();
        User user = new User();
        user.setUserid(3l);
        evaluate.setUser(user);
        Servicer servicer = new Servicer();
        servicer.setServicerid(36l);
        evaluate.setServicer(servicer);
        evaluate.setEvaluatedes("tttttteeeeeeesssssssttttttt");
        evaluate.setEvaluatescore(5);
        userReserveService.writeEvaluate(evaluate,22);
    }
}
