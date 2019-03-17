package com.house.service.servicer;

import com.house.dto.ServicerExecution;
import com.house.entity.Servicer;

import java.io.InputStream;

public interface EditInfoService {
    ServicerExecution getServicerInfo(Servicer servicer);
///////////////////////////////////根据传入文件不同设置三个service//////////////////////////////////////////////
    ServicerExecution editBaseInfo(Servicer servicer);//修改基本信息
    ServicerExecution editInfo(Servicer servicer);//没有文件传入
    ServicerExecution editInfo(Servicer servicer, InputStream inputStream,String name); //传入一个文件
    ServicerExecution editInfo(Servicer servicer, InputStream img,String imgname,InputStream file,String filename);//传入两个文件
}
