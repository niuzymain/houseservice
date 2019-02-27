package com.house.service.servicer;

import com.house.dto.ServicerExecution;
import com.house.entity.Servicer;

import java.io.InputStream;

public interface EditInfoService {
    ServicerExecution getServicerInfo(Servicer servicer);
    ServicerExecution editInfo(Servicer servicer, InputStream img,String imgname,InputStream file,String filename);
}
