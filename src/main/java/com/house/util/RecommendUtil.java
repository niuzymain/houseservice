package com.house.util;

import com.house.dao.ServicerDao;
import com.house.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RecommendUtil {

    public static Servicer calculateSimilarServicer(List<ServicerCount> servicerCounts) {
        //1.构建关键词矩阵
        int[] age = {0, 0, 0, 0};//20,30,40,50年龄段
        int[] similarage = {20, 30, 40, 50};
        int[] sex = {0, 0};//男，女
        int[] similarsex = {1, 2};
        int[] experience = {0, 0, 0, 0, 0};//3,6,12,24,36经验
        int[] similarexperience = {3, 6, 12, 24, 36};
        int[] servicetype = {0, 0, 0, 0, 0};//根据typeid匹配
        int[] similarst = {1, 2, 3, 4, 5};
        int[] degree = {0, 0, 0, 0};//根据degreeid匹配
        int[] similardeg = {1, 2, 3, 4};
        int[] city = {0, 0, 0, 0};//根据cityid匹配
        int[] similarcity = {1, 2, 3, 4};
        int[] price = {0, 0, 0, 0, 0, 0};//3000⬇,3000,4000,5000,6000,7000↑
        int[] similarprice = {2999, 3000, 4000, 5000, 6000, 7000};
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

            if (sc.getServicer().getServicerexperience() >= 3 && sc.getServicer().getServicerexperience() < 6) {
                experience[0] += sc.getCount();
            } else if (sc.getServicer().getServicerexperience() >= 6 && sc.getServicer().getServicerexperience() < 9) {
                experience[1] += sc.getCount();
            } else if (sc.getServicer().getServicerexperience() >= 12 && sc.getServicer().getServicerexperience() < 12) {
                experience[2] += sc.getCount();
            } else if (sc.getServicer().getServicerexperience() >= 24 && sc.getServicer().getServicerexperience() < 24) {
                experience[3] += sc.getCount();
            } else if (sc.getServicer().getServicerexperience() >= 36) {
                experience[4] += sc.getCount();
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

            if (sc.getServicer().getDegree().getDegreeid() == 1) {
                degree[0] += sc.getCount();
            } else if (sc.getServicer().getDegree().getDegreeid() == 2) {
                degree[1] += sc.getCount();
            } else if (sc.getServicer().getDegree().getDegreeid() == 3) {
                degree[2] += sc.getCount();
            } else if (sc.getServicer().getDegree().getDegreeid() == 4) {
                degree[3] += sc.getCount();
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

            if (sc.getServicer().getServicerprice() < 3000) {
                price[0] += sc.getCount();
            } else if (sc.getServicer().getServicerprice() >= 3000 && sc.getServicer().getServicerprice() < 4000) {
                price[1] += sc.getCount();
            } else if (sc.getServicer().getServicerprice() >= 4000 && sc.getServicer().getServicerprice() < 5000) {
                price[2] += sc.getCount();
            } else if (sc.getServicer().getServicerprice() >= 5000 && sc.getServicer().getServicerprice() < 6000) {
                price[3] += sc.getCount();
            } else if (sc.getServicer().getServicerprice() >= 6000 && sc.getServicer().getServicerprice() < 7000) {
                price[4] += sc.getCount();
            } else if (sc.getServicer().getServicerprice() >= 7000) {
                price[5] += sc.getCount();
            }
        }
        //3.筛选出现最高作为相似条件
        int i;
        int maxage = 0;
        Servicer recommend_condition = new Servicer();
        for (i = 1; i < age.length; i++) {
            if (age[maxage] < age[i]) {
                maxage = i;
            }
        }
        recommend_condition.setServicerage(similarage[maxage]);

        int maxsex = 0;
        for (i = 1; i < sex.length; i++) {
            if (sex[maxsex] < sex[i]) {
                maxsex = i;
            }
        }
//        recommend_condition.setServicersex(similarsex[maxsex]);

        int maxexp = 0;
        for (i = 1; i < experience.length; i++) {
            if (experience[maxexp] < experience[i]) {
                maxexp = i;
            }
        }

        ServiceType serviceType = new ServiceType();
        int maxst = 0;
        for (i = 1; i < servicetype.length; i++) {
            if (servicetype[maxst] < servicetype[i]) {
                maxst = i;
            }
        }
        serviceType.setServicetypeid(similarst[maxst]);
        recommend_condition.setServicetype(serviceType);

        Degree degree1 = new Degree();
        int maxd = 0;
        for (i = 1; i < degree.length; i++) {
            if (degree[maxd] < degree[i]) {
                maxd = i;
            }
        }

        WorkArea workArea = new WorkArea();
        int maxc = 0;
        for (i = 1; i < city.length; i++) {
            if (city[maxc] < city[i]) {
                maxc = i;
            }
        }
        workArea.setWorkareaid(similarcity[maxc]);
        recommend_condition.setCity(workArea);

        int maxp = 0;
        for (i = 1; i < price.length; i++) {
            if (price[maxp] < price[i]) {
                maxp = i;
            }
        }
        return recommend_condition;
    }
}
