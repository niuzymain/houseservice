package com.house.service.imps.superadmin;

import com.house.dao.AdminMsgDao;
import com.house.dao.ReserveDao;
import com.house.entity.AdminMsg;
import com.house.entity.Reserve;
import com.house.service.superadmin.QualifyReserveService;
import com.house.util.FilesUtil;
import com.house.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
审核service层
 */

@Service
public class QualifyReserveServiceImp implements QualifyReserveService {
    @Autowired
    private ReserveDao reserveDao;
    @Autowired
    private AdminMsgDao adminMsgDao;

    public static SimpleDateFormat sft = new SimpleDateFormat("yyyy年MM月dd日");


    @Override
    public List<Reserve> reserveQualifyList(int enablestatus) {
        try {
            Reserve reserve = new Reserve();
            reserve.setEnablestatus(enablestatus);
            List<Reserve> reserveList = reserveDao.queryReserveList(reserve);
            return reserveList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Reserve specificReserveQualify(Long reserveid) {
        try {
            Reserve reserve = reserveDao.querySingleReserve(reserveid);
            return reserve;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional
    public int handleReserve(long reserveid) {
        int result = 0;
        Reserve currentreserve = reserveDao.querySingleReserve(reserveid);
///////////////////////////////创建消息///////////////////////////////////////////////////////
        AdminMsg adminMsg = new AdminMsg();
        adminMsg.setAdminmsgdes("您于" + sft.format(currentreserve.getCreatetime()) + "的预约已受理,请等待我们的联系");
        adminMsg.setCreatetime(new Date());
        adminMsg.setUser(currentreserve.getUser());
        adminMsg.setType(0);
////////////////////////////////////更改预约信息////////////////////////////////////////////////////////////
        currentreserve.setEnablestatus(1);
        currentreserve.setCreatetime(new Date());
        try {
            result = adminMsgDao.insertAdminmsg(adminMsg);
            if (result <= 0) {
                throw new RuntimeException();
            }
            result = reserveDao.updateReserve(currentreserve);
            if (result <= 0) {
                throw new RuntimeException();
            } else {
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    @Transactional
    public int confirmReserve(Reserve reserve, InputStream contract, String filename) {
        int result = 0;
        String url = "";
        reserve.setCreatetime(new Date());
        try {
            url = FilesUtil.saveReserveConntract(contract, reserve.getReserveid(), filename);
            reserve.setReservecontract(url);
            reserve.setEnablestatus(2);
            result = reserveDao.updateReserve(reserve);
            if (result <= 0) {
                FilesUtil.deleteFile(PathUtil.rootPath() + url);
                throw new RuntimeException();
            } else {
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            FilesUtil.deleteFile(PathUtil.rootPath() + url);
            throw new RuntimeException();
        }
    }

    @Override
    @Transactional
    public int overReserve(long reserveid) {
        int result = 0;
        Reserve currentreserve = reserveDao.querySingleReserve(reserveid);
        AdminMsg adminMsg = new AdminMsg();
        adminMsg.setCreatetime(new Date());
        adminMsg.setUser(currentreserve.getUser());
        adminMsg.setType(0);
        adminMsg.setAdminmsgdes("您于" + sft.format(currentreserve.getReservetime()) + "预约的服务已服务完成，感谢您的预约");
        currentreserve.setCreatetime(new Date());
        currentreserve.setEnablestatus(3);
        try {
            result = adminMsgDao.insertAdminmsg(adminMsg);
            if (result <= 0) {
                throw new RuntimeException("插入消息出现异常");
            }
            result = reserveDao.updateReserve(currentreserve);
            if (result <= 0) {
                throw new RuntimeException("插入消息出现异常");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("操作出现异常");
        }
    }

}
