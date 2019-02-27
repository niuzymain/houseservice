package com.house.service.imps.servicer;

import com.house.dao.ServicerDao;
import com.house.dto.ServicerExecution;
import com.house.entity.Servicer;
import com.house.enums.ServicerEnum;
import com.house.service.servicer.EditInfoService;
import com.house.util.FilesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;

@Service
public class EditInfoServiceImp implements EditInfoService {
    @Autowired
    private ServicerDao servicerDao;
    @Override
    public ServicerExecution getServicerInfo(Servicer servicer) {
        try{
            return new ServicerExecution(ServicerEnum.SUCCESS,servicerDao.querySingleServicer(servicer));
        }catch (Exception e){
            e.printStackTrace();
            return new ServicerExecution(ServicerEnum.ERROR);
        }
    }

    @Override
    @Transactional
    public ServicerExecution editInfo(Servicer servicer, InputStream img, String imgname, InputStream file, String filename) {
        servicer.setCheckstatus(0);
        int result;
        try{
////////////////////////////若传过来文件，则先存储文件//////////////////////////////////
            if(img != null || file != null){
                Servicer temp = servicerDao.querySingleServicer(servicer);
                if(img != null){
                    FilesUtil.deleteFile(temp.getServicerimg());
                    String imgurl = FilesUtil.saveServicerImg(img,servicer.getServicerid(),imgname);
                }
                if(file != null){

                }
            }
            result = servicerDao.updateServicer(servicer);
            if(result <= 0){
                throw new RuntimeException();
            }
            else{
                return new ServicerExecution(ServicerEnum.SUCCESS);
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
