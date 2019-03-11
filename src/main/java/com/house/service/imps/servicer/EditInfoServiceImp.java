package com.house.service.imps.servicer;

import com.house.dao.ServicerDao;
import com.house.dto.ServicerExecution;
import com.house.entity.Servicer;
import com.house.enums.ServicerEnum;
import com.house.service.servicer.EditInfoService;
import com.house.util.FilesUtil;
import com.house.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;

@Service
public class EditInfoServiceImp implements EditInfoService {
    @Autowired
    private ServicerDao servicerDao;

    @Override
    public ServicerExecution getServicerInfo(Servicer servicer) {
        try {
            servicer.setAccountname(null);
            servicer.setPassword(null);
            return new ServicerExecution(ServicerEnum.SUCCESS, servicerDao.querySingleServicer(servicer));
        } catch (Exception e) {
            e.printStackTrace();
            return new ServicerExecution(ServicerEnum.ERROR);
        }
    }

    @Override
    public ServicerExecution editInfo(Servicer servicer) {
//        servicer.setCheckstatus(0);
        servicer.setLastedittime(new Date());
        int result;
        try {
            result = servicerDao.updateServicer(servicer);
            if (result <= 0) {
                throw new RuntimeException();
            } else {
                return new ServicerExecution(ServicerEnum.SUCCESS);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public ServicerExecution editInfo(Servicer servicer, InputStream inputStream, String name) {
        servicer.setCheckstatus(0);
        servicer.setLastedittime(new Date());
        int result;
        try {
            Servicer temp = servicerDao.querySingleServicer(servicer);
            String extension = FilesUtil.getExtensionname(name);
            /////////////////////////更新文件////////////////////////////////////
            if (extension.equals(".zip") || extension.equals(".rar")) {
                FilesUtil.deleteFile(PathUtil.rootPath()+temp.getServicerfile());
                String fileurl = FilesUtil.saveServicerFiles(inputStream, servicer.getServicerid(), name);
                servicer.setServicerfile(fileurl);
            }
            /////////////////////////更新图片////////////////////////////////////
            else if (extension.equals(".jpg") || extension.equals(".JPG") || extension.equals(".png") || extension.equals(".PNG") || extension.equals(".bmp") || extension.equals(".BMP")) {
                FilesUtil.deleteFile(PathUtil.rootPath()+temp.getServicerimg());
                String imgurl = FilesUtil.saveServicerImg(inputStream, servicer.getServicerid(), name);
                servicer.setServicerimg(imgurl);
            }
            ////////////////////////格式错误////////////////////////////////////
            else {
                return new ServicerExecution(ServicerEnum.ERRORFORMAT);
            }
            result = servicerDao.updateServicer(servicer);
            if (result <= 0) {
                throw new RuntimeException();
            } else {
                return new ServicerExecution(ServicerEnum.SUCCESS);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    @Transactional
    public ServicerExecution editInfo(Servicer servicer, InputStream img, String imgname, InputStream file, String filename) {
        servicer.setCheckstatus(0);
        servicer.setLastedittime(new Date());
        int result;
        try {
            Servicer temp = servicerDao.querySingleServicer(servicer);
            FilesUtil.deleteFile(PathUtil.rootPath()+temp.getServicerimg());
            String imgurl = FilesUtil.saveServicerImg(img, servicer.getServicerid(), imgname);
            servicer.setServicerimg(imgurl);
            FilesUtil.deleteFile(PathUtil.rootPath()+temp.getServicerfile());
            String fileurl = FilesUtil.saveServicerFiles(file, servicer.getServicerid(), filename);
            servicer.setServicerfile(fileurl);
            result = servicerDao.updateServicer(servicer);
            if (result <= 0) {
                throw new RuntimeException();
            } else {
                return new ServicerExecution(ServicerEnum.SUCCESS);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
