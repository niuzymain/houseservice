package com.house.dao;

import com.house.entity.Headimg;

import java.util.List;

public interface HeadimgDao {
    int insertHeadImg(Headimg headimg);
    int updateHeadImg(Headimg headimg);
    int deleteHeadImg(Long headimgid);
    List<Headimg> selectHeadImg();
    //选取轮播图前端展示,默认展示4个
    List<Headimg> selectDisplay();
    //查看特定轮播图
    Headimg selectById(Long headimgid);
}
