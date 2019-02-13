package com.house.service;

import com.house.Basetest;
import com.house.dto.HeadimgExecution;
import com.house.entity.Headimg;
import com.house.service.superadmin.HeadimgService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class HeadimgServicetest extends Basetest {
    @Autowired
    private HeadimgService headimgService;

    @Test
    public void testuodate() throws Exception {
        Headimg headimg = new Headimg();
        headimg.setHeadimgid(11l);
        InputStream inputStream = new FileInputStream(new File("g:/idea.jpg"));
        headimgService.UpdataHeadimg(headimg,inputStream,"idea.jpg");
    }
}
