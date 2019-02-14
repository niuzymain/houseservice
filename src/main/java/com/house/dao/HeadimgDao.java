package com.house.dao;

import com.house.entity.Headimg;

import java.util.List;

public interface HeadimgDao {
    int insertHeadImg(Headimg headimg);
    int updateHeadImg(Headimg headimg);
    int deleteHeadImg(Long headimgid);
    List<Headimg> selectHeadImg();
    //选取轮播图前端展示
    List<Headimg> selectDisplay();
    Headimg selectById(Long headimgid);
}
