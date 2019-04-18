package com.house.service.imps.user;

import com.house.dao.RecommendCBDao;
import com.house.dao.RecommendDao;
import com.house.dao.ServicerDao;
import com.house.entity.*;
import com.house.service.user.RecommendService;
import com.house.util.RecommendUtil;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class RecommendServiceImp implements RecommendService {

    @Autowired
    private RecommendDao recommendDao;

    @Autowired
    private RecommendCBDao recommendCBDao;

    @Autowired
    private ServicerDao servicerDao;

    @Autowired
    private MysqlDataSource dataSource;
    @Override
    @Transactional
    public int addUserClick(Long userid, Long servicerid) {
        RecommendCB isExist = recommendCBDao.selectRecommendCB(userid, servicerid);
        int result = 0;
        if(isExist == null){
            //第一次选择
            RecommendCB recommendCB = new RecommendCB();
            recommendCB.setClickcount(1);
            recommendCB.setUserid(userid);
            recommendCB.setServicerid(servicerid);
            recommendCB.setCreatetime(new Date());
            result = recommendCBDao.insertRecommendCB(recommendCB);
        }
        else{
            //已经查看过
            result = recommendCBDao.updateClickCount(isExist.getCbid());
        }
        if(result <= 0){
            throw new RuntimeException();
        }
        else{
            return result;
        }
    }

    @Override
    public List<Servicer> RecommendServicerByUserCF(Long userid) throws Exception {
        //将数据加载到内存中，GroupLensDataModel是针对开放电影评论数据的
        Class.forName("com.mysql.cj.jdbc.Driver");
        DataModel dataModel = new MySQLJDBCDataModel(dataSource, "tb_evaluate", "user_id", "servicer_id", "evaluate_score", "create_time");
        //计算相似度，相似度算法有很多种，欧几里得、皮尔逊等等。
        UserSimilarity similarity = new EuclideanDistanceSimilarity(dataModel);
        //计算最近邻域，邻居有两种算法，基于固定数量的邻居和基于相似度的邻居，这里使用基于固定数量的邻居
        UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(100, similarity, dataModel);
        //构建推荐器，协同过滤推荐有两种，分别是基于用户的和基于物品的，这里使用基于用户的协同过滤推荐
        Recommender recommender = new GenericUserBasedRecommender(dataModel, userNeighborhood, similarity);
        //给用户推荐最多20个服务人员
        List<RecommendedItem> recommendedItemList = recommender.recommend(userid, 10);
        //查找服务人员
        List<Long> idList = new ArrayList<>();
        for (int i = 0; i < recommendedItemList.size(); i++) {
            idList.add(recommendedItemList.get(i).getItemID());
        }
        if (idList.size() == 0) {
            return null;
        } else {
            List<Servicer> servicerList = servicerDao.queryUserBaseRecommend(idList);
            return servicerList;
        }
    }

    @Override
    public List<Servicer> simpleRecommendServicer(Long servicerid) throws Exception {
        Servicer condition = new Servicer();
        condition.setServicerid(servicerid);
        Servicer servicer = servicerDao.querySingleServicer(condition);
        Servicer recommender = new Servicer();
        recommender.setServicetype(servicer.getServicetype());
        recommender.setCity(servicer.getCity());
        List<Servicer> recommendList = servicerDao.querySimpleRecommend(recommender);
        /*
        删除当前服务人员
         */
        Iterator<Servicer> iterator = recommendList.iterator();
        while (iterator.hasNext()){
            Servicer s = iterator.next();
            if(s.getServicerid() == servicerid){
                iterator.remove();
                break;
            }
        }
        return recommendList;
    }

    @Override
    public List<Servicer> RecommendServicerByCB(Long userid) throws Exception {
        List<RecommendCB> recommendCBList = recommendCBDao.queryServiceridByUser(userid);
        List<ServicerCount> servicerCounts = new ArrayList<>();
        for (RecommendCB rcb:recommendCBList) {
            //1.查找服务人员
            Servicer condition = new Servicer();
            condition.setServicerid(rcb.getServicerid());
            Servicer servicer = servicerDao.querySingleServicer(condition);
            //2.添加进封装实体类
            ServicerCount servicerCount = new ServicerCount();
            servicerCount.setServicer(servicer);
            servicerCount.setCount(rcb.getClickcount());
            servicerCounts.add(servicerCount);
        }
        Servicer condition = RecommendUtil.calculateSimilarServicer(servicerCounts);
        List<Servicer> servicerList = servicerDao.queryContentBaseRecommend(condition);
        return servicerList;
    }
}
