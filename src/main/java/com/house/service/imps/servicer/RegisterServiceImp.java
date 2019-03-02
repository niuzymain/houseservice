package com.house.service.imps.servicer;

import com.house.dao.DegreeDao;
import com.house.dao.ServiceTypeDao;
import com.house.dao.ServicerDao;
import com.house.dao.WorkAreaDao;
import com.house.entity.*;
import com.house.service.servicer.RegisterService;
import com.house.util.FilesUtil;
import com.house.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Service
public class RegisterServiceImp implements RegisterService {

    @Autowired
    private ServicerDao servicerDao;

    @Override
    @Transactional
    public int addServicer(Servicer servicer, InputStream img, String imgname, InputStream file, String filename) throws Exception {
        int result;
        try{
            ///////////////////////赋初值////////////////////////////////////
            servicer.setCreatetime(new Date());
            servicer.setLastedittime(new Date());
            servicer.setEnablestatus(1);
            servicer.setCheckstatus(0);
            result = servicerDao.insertServicer(servicer);
            if(result <= 0){
                throw new RuntimeException();
            }
            String imgurl = FilesUtil.saveServicerImg(img,servicer.getServicerid(),imgname);
            String fileurl = FilesUtil.saveServicerFiles(file,servicer.getServicerid(),filename);
            servicer.setServicerimg(imgurl);
            servicer.setServicerfile(fileurl);
            result = servicerDao.updateServicer(servicer);
            if(result <= 0){
                FilesUtil.deleteFile(PathUtil.rootPath()+imgurl);
                FilesUtil.deleteFile(PathUtil.rootPath()+fileurl);
                throw new RuntimeException();
            }
            return result;
        }catch (Exception e){
            FilesUtil.deleteFile(PathUtil.rootPath()+servicer.getServicerimg());
            FilesUtil.deleteFile(PathUtil.rootPath()+servicer.getServicerfile());
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
