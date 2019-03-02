package com.house.service.imps.user;

import com.house.dao.HeadimgDao;
import com.house.dto.HeadimgExecution;
import com.house.enums.HeadimgEnum;
import com.house.service.user.FrontHeadimgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrontHeadimgServiceImp implements FrontHeadimgService {
    @Autowired
    private HeadimgDao headimgDao;

    @Override
    public HeadimgExecution checkHeadimg(){
        try{
            return new HeadimgExecution(HeadimgEnum.SUCCESS,headimgDao.selectDisplay());
        }catch (Exception e){
            e.printStackTrace();
            return new HeadimgExecution(HeadimgEnum.ERROR);
        }
    }

    @Override
    public HeadimgExecution checkSpecificHeadimg(long headimgid){
        try{
            return new HeadimgExecution(HeadimgEnum.SUCCESS,headimgDao.selectById(headimgid));
        }catch (Exception e){
            e.printStackTrace();
            return new HeadimgExecution(HeadimgEnum.ERROR);
        }
    }
}
