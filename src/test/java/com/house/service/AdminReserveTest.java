package com.house.service;

import com.house.Basetest;
import com.house.entity.Reserve;
import com.house.service.superadmin.QualifyReserveService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AdminReserveTest extends Basetest {
    @Autowired
    private QualifyReserveService qualifyReserveService;

    @Test
    public void test() throws FileNotFoundException {
        qualifyReserveService.confirmReserve(new Reserve(),new FileInputStream(new File("g:/idea.jpg")),"");
    }
}
