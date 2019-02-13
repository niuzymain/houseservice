package com.house.service.superadmin;

import com.house.dto.HeadimgExecution;
import com.house.entity.Headimg;

import java.io.InputStream;
import java.util.List;

public interface HeadimgService {
    HeadimgExecution AddHeadimg(Headimg headimg, InputStream inputStream, String filename);
    HeadimgExecution UpdataHeadimg(Headimg headimg, InputStream inputStream, String filename);
    HeadimgExecution DeleteHeadimg(Long headimgid);
    HeadimgExecution QueryHeadimg();
    HeadimgExecution getHeadimgById(Long headimgid);
}
