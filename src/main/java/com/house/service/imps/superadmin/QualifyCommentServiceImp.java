package com.house.service.imps.superadmin;

import com.house.dao.AdminMsgDao;
import com.house.dao.EvaluateDao;
import com.house.dao.ServicerDao;
import com.house.dto.EvaluateExecution;
import com.house.entity.AdminMsg;
import com.house.entity.Evaluate;
import com.house.entity.Servicer;
import com.house.entity.User;
import com.house.service.superadmin.QualifyCommentService;
import com.house.util.PageIndexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
审核service层
 */

@Service
public class QualifyCommentServiceImp implements QualifyCommentService {
    @Autowired
    private AdminMsgDao adminMsgDao;
    @Autowired
    private EvaluateDao evaluateDao;
    @Autowired
    private ServicerDao servicerDao;

    public static SimpleDateFormat sft = new SimpleDateFormat("yyyy年MM月dd日");


    @Override
    public EvaluateExecution commentQualifyList(int pageindex, int pagesize) {
        int index = PageIndexUtil.TranstoDBIndex(pageindex,pagesize);
        List<Evaluate> evaluateList = evaluateDao.queryEvaluateForAdmin(index,pagesize);
        int evaluatecount = evaluateDao.queryEvaluateCountForAdmin();
        return new EvaluateExecution(evaluateList,evaluatecount);
    }

    @Override
    @Transactional
    public int illegalCommentOperate(long evaluateid) {
        int result;
        Evaluate evaluate = new Evaluate();
        evaluate.setEvaluateid(evaluateid);
        evaluate.setEvaluatedes("----该评论违规，已被屏蔽----");
        evaluate.setEnablestatus(-1);
        evaluate.setEvaluatescore(-1);
        /////////////////根据id查找相关评论信息//////////////////////////////
        Evaluate specific = evaluateDao.querySingleEvaluate(evaluate);
        //////////////////////系统消息通知用户///////////////////////////////////
        AdminMsg adminMsg = new AdminMsg();
        User user = new User();
        user.setUserid(specific.getUser().getUserid());
        adminMsg.setUser(user);
        adminMsg.setType(0);
        adminMsg.setCreatetime(new Date());
        adminMsg.setAdminmsgdes("您于" + sft.format(specific.getCreatetime()) + "的评论违规，已被系统屏蔽！");
        try {
            result = evaluateDao.updateEvaluate(evaluate);
            adminMsgDao.insertAdminmsg(adminMsg);
///////////////////////////////更新服务人员评分///////////////////////////////////////////////
            int score = evaluateDao.averageScore(specific.getServicer().getServicerid());
            Servicer servicer = new Servicer();
            servicer.setServicerid(specific.getServicer().getServicerid());
            servicer.setServicerscore(score);
            servicerDao.updateServicer(servicer);
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

}
