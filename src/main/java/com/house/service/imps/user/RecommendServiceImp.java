package com.house.service.imps.user;

import com.house.dao.RecommendDao;
import com.house.dao.ServicerDao;
import com.house.entity.Recommend;
import com.house.entity.Servicer;
import com.house.service.user.RecommendService;
import com.house.util.PageIndexUtil;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecommendServiceImp implements RecommendService {

    @Autowired
    private RecommendDao recommendDao;

    @Autowired
    private ServicerDao servicerDao;

    @Autowired
    private MysqlDataSource dataSource;

    @Override
    public int addUserClick(long userid, long servicerid) {
        Recommend recommend = recommendDao.selectRecommend(userid, servicerid);
        int result = 0;
        try {
            if (recommend != null) {
                result = recommendDao.updateRecommendCheckTimes(recommend.getRecommendId(), new Date());
            } else {
                recommend = new Recommend();
                recommend.setUserId(userid);
                recommend.setServicerId(servicerid);
                recommend.setCheckTimes(1);
                recommend.setCreateTime(new Date());
                result = recommendDao.insertRecommend(recommend);
            }
            if (result <= 0) {
                throw new RuntimeException("添加失败");
            } else {
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("出现异常");
        }
    }

    @Override
    public List<Servicer> findRecommendServicer(Long userid) throws Exception {
        //将数据加载到内存中，GroupLensDataModel是针对开放电影评论数据的
        Class.forName("com.mysql.cj.jdbc.Driver");
        DataModel dataModel = new MySQLJDBCDataModel(dataSource, "tb_recommend", "user_id", "servicer_id", "check_times", "create_time");
        //计算相似度，相似度算法有很多种，欧几里得、皮尔逊等等。
        UserSimilarity similarity = new EuclideanDistanceSimilarity(dataModel);
        //计算最近邻域，邻居有两种算法，基于固定数量的邻居和基于相似度的邻居，这里使用基于固定数量的邻居
        UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(100, similarity, dataModel);
        //构建推荐器，协同过滤推荐有两种，分别是基于用户的和基于物品的，这里使用基于用户的协同过滤推荐
        Recommender recommender = new GenericUserBasedRecommender(dataModel, userNeighborhood, similarity);
        //给用户推荐最多20个服务人员
        List<RecommendedItem> recommendedItemList = recommender.recommend(userid, 20);
        //查找服务人员
        List<Long> idList = new ArrayList<>();
        for (int i = 0; i < recommendedItemList.size(); i++) {
            idList.add(recommendedItemList.get(i).getItemID());
        }
        if (idList.size() == 0) {
            return null;
        } else {
            List<Servicer> servicerList = servicerDao.queryServicerForRecommend(idList);
            return servicerList;
        }
    }
}
