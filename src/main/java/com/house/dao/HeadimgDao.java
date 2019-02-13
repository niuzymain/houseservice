package com.house.dao;

import com.house.entity.Headimg;

import java.util.List;

public interface HeadimgDao {
    int insertHeadImg(Headimg headimg);
    int updateHeadImg(Headimg headimg);
    int deleteHeadImg(Long headimgid);
    List<Headimg> selectHeadImg();
    Headimg selectById(Long headimgid);
}
