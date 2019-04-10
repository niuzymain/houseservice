package com.house.util;

import com.house.dao.ServicerDao;
import com.house.entity.ServiceType;
import com.house.entity.Servicer;
import com.house.entity.ServicerCount;
import com.house.entity.WorkArea;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class RecommendUtil {

    public static Servicer calculateSimilarServicer(List<ServicerCount> servicerCounts) {
        //1.构建关键词矩阵
        int[] age = {0, 0, 0, 0};//20,30,40,50年龄段
        int[] similarage = {20,30,40,50};
        int[] sex = {0, 0};//男，女
        int[] similarsex = {1,2};
//        int[] experience = {0,0,0,0,0};//3,6,12,24,36经验
        int[] servicetype = {0, 0, 0, 0, 0};//根据typeid匹配
        int[] similarst = {1,2,3,4,5};
//        int[] degree = {0,0,0,0};//根据degreeid匹配
        int[] city = {0, 0, 0, 0};//根据cityid匹配
        int[] similarcity = {1,2,3,4};
//        int[] price = {0,0,0,0,0,0};//3000,4000,5000,6000,7000,7000↑
//        int[] score = {0,0,0,0,0};//1,2,3,4,5分
        //2.计算关键词出现数量
        for (ServicerCount sc : servicerCounts) {
            if (sc.getServicer().getServicerage() >= 20 && sc.getServicer().getServicerage() < 29) {
                age[0] += sc.getCount();
            } else if (sc.getServicer().getServicerage() >= 30 && sc.getServicer().getServicerage() < 39) {
                age[1] += sc.getCount();
            } else if (sc.getServicer().getServicerage() >= 40 && sc.getServicer().getServicerage() < 49) {
                age[2] += sc.getCount();
            } else if (sc.getServicer().getServicerage() >= 50) {
                age[3] += sc.getCount();
            }
            if (sc.getServicer().getServicersex() == 1) {
                sex[0] += sc.getCount();
            } else {
                sex[1] += sc.getCount();
            }
            if (sc.getServicer().getServicetype().getServicetypeid() == 1) {
                servicetype[0] += sc.getCount();
            } else if (sc.getServicer().getServicetype().getServicetypeid() == 2) {
                servicetype[1] += sc.getCount();
            } else if (sc.getServicer().getServicetype().getServicetypeid() == 3) {
                servicetype[2] += sc.getCount();
            } else if (sc.getServicer().getServicetype().getServicetypeid() == 4) {
                servicetype[3] += sc.getCount();
            } else if (sc.getServicer().getServicetype().getServicetypeid() == 5) {
                servicetype[4] += sc.getCount();
            }
            if (sc.getServicer().getCity().getWorkareaid() == 1) {
                city[0] += sc.getCount();
            } else if (sc.getServicer().getCity().getWorkareaid() == 2) {
                city[1] += sc.getCount();
            } else if (sc.getServicer().getCity().getWorkareaid() == 3) {
                city[2] += sc.getCount();
            } else if (sc.getServicer().getCity().getWorkareaid() == 4) {
                city[3] += sc.getCount();
            }
        }
        //3.筛选出现最高作为相似条件
        int i;
        int max = 0;
        Servicer recommend_condition = new Servicer();
        for(i=1;i<age.length;i++){
            if(age[max]<age[i]){
                max = i;
            }
        }
        recommend_condition.setServicerage(similarage[max]);
        max = 0;
        for(i=1;i<sex.length;i++){
            if(sex[max]<sex[i]){
                max = i;
            }
        }
        recommend_condition.setServicersex(similarsex[max]);
        ServiceType serviceType = new ServiceType();
        max = 0;
        for(i=1;i<servicetype.length;i++){
            if(servicetype[max]<servicetype[i]){
                max = i;
            }
        }
        serviceType.setServicetypeid(similarst[max]);
        recommend_condition.setServicetype(serviceType);
        WorkArea workArea = new WorkArea();
        max = 0;
        for(i=1;i<city.length;i++){
            if(city[max]<city[i]){
                max = i;
            }
        }
        workArea.setWorkareaid(similarcity[max]);
        recommend_condition.setCity(workArea);
        return recommend_condition;
    }
}
