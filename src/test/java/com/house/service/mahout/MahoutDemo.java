package com.house.service.mahout;

import com.house.Basetest;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.cf.taste.similarity.precompute.example.GroupLensDataModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

public class MahoutDemo extends Basetest {

    @Autowired
    private MysqlDataSource dataSource;

    /**
     * Created by ahu_lichang on 2017/6/23.
     */
    @Test
    public void testMahout() throws Exception {
        //将数据加载到内存中，GroupLensDataModel是针对开放电影评论数据的
        Class.forName("com.mysql.cj.jdbc.Driver");
        DataModel dataModel = new MySQLJDBCDataModel(dataSource, "tb_evaluate", "user_id", "servicer_id", "evaluate_score", "create_time");
        //计算相似度，相似度算法有很多种，欧几里得、皮尔逊等等。
        UserSimilarity similarity = new EuclideanDistanceSimilarity(dataModel);
//        UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
        System.out.println("distance:"+similarity.userSimilarity(1,3));
        //计算最近邻域，邻居有两种算法，基于固定数量的邻居和基于相似度的邻居，这里使用基于固定数量的邻居
        UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(100, similarity, dataModel);
        System.out.println("neighbour:");
        for (Long l:userNeighborhood.getUserNeighborhood(1)) {
            System.out.println(l+",");
        }
        //构建推荐器，协同过滤推荐有两种，分别是基于用户的和基于物品的，这里使用基于用户的协同过滤推荐
        Recommender recommender = new GenericUserBasedRecommender(dataModel, userNeighborhood, similarity);
        //给用户ID等于l的用户推荐i部电影
        List<RecommendedItem> recommendedItemList = recommender.recommend(1, 10);
        //打印推荐的结果
        System.out.println("使用基于用户的协同过滤算法");
        System.out.println("为用户推荐个商品");
        for (RecommendedItem recommendedItem : recommendedItemList) {
            System.out.println(recommendedItem);
        }
    }
}
