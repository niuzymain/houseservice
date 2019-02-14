package com.house.service.imps.superadmin;

import com.house.dao.HeadimgDao;
import com.house.dto.HeadimgExecution;
import com.house.entity.Headimg;
import com.house.enums.HeadimgEnum;
import com.house.service.superadmin.HeadimgService;
import com.house.util.FilesUtil;
import com.house.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.List;

@Service
public class HeadimgServiceImp implements HeadimgService {
    @Autowired
    private HeadimgDao headimgDao;

    @Override
    @Transactional
    public HeadimgExecution AddHeadimg(Headimg headimg, InputStream inputStream, String filename) {
        int result;
        headimg.setEnablestatus(1);
        try {
            if (inputStream == null) {
                return new HeadimgExecution(HeadimgEnum.IMGNULL);
            }
            result = headimgDao.insertHeadImg(headimg);
            if (result <= 0) {
                throw new RuntimeException();
            } else {
                String url = FilesUtil.saveHeadimg(inputStream, headimg.getHeadimgid(), filename);
                headimg.setHeadimgurl(url);
                result = headimgDao.updateHeadImg(headimg);
                if (result <= 0) {
                    throw new RuntimeException();
                } else {
                    return new HeadimgExecution(HeadimgEnum.SUCCESS, headimg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    @Transactional
    public HeadimgExecution UpdataHeadimg(Headimg headimg, InputStream inputStream, String filename) {
        int result;
        try {
            //判断是否有文件流，若有则先删除旧图片
            if (inputStream != null) {
                Headimg temp = headimgDao.selectById(headimg.getHeadimgid());
                if (temp.getHeadimgurl() != null) {
                    FilesUtil.deleteFile(PathUtil.rootPath() + temp.getHeadimgurl());
                }
                String url = FilesUtil.saveHeadimg(inputStream,headimg.getHeadimgid(),filename);
                headimg.setHeadimgurl(url);
            }
            result = headimgDao.updateHeadImg(headimg);
            if (result <= 0) {
                throw new RuntimeException();
            } else {
                return new HeadimgExecution(HeadimgEnum.SUCCESS, headimg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    @Transactional
    public HeadimgExecution DeleteHeadimg(Long headimgid) {
        int result;
        try {
            //连同图片一起删除
            Headimg temp = headimgDao.selectById(headimgid);
            if (temp.getHeadimgurl() != null) {
                FilesUtil.deleteFile(PathUtil.rootPath() + temp.getHeadimgurl());
            }
            result = headimgDao.deleteHeadImg(headimgid);
            if (result <= 0) {
                throw new RuntimeException();
            } else {
                return new HeadimgExecution(HeadimgEnum.SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public HeadimgExecution QueryHeadimg() {
        return new HeadimgExecution(HeadimgEnum.SUCCESS, headimgDao.selectHeadImg());
    }

    @Override
    public HeadimgExecution getHeadimgById(Long headimgid) {
        return new HeadimgExecution(HeadimgEnum.SUCCESS, headimgDao.selectById(headimgid));
    }
}
