package com.house.service.servicer;

import com.house.entity.Degree;
import com.house.entity.ServiceType;
import com.house.entity.Servicer;
import com.house.entity.WorkArea;

import java.io.InputStream;
import java.util.List;

public interface RegisterService {
    int addServicer(Servicer servicer, InputStream img,String imgname,InputStream file,String filename) throws Exception;
}
