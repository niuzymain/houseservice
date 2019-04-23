package com.house.data;

import com.house.Basetest;
import com.house.dao.DataSimulator;
import com.house.dao.EvaluateDao;
import com.house.dao.ReserveDao;
import com.house.dao.ServicerDao;
import com.house.entity.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class CreateData extends Basetest {
    @Autowired
    private DataSimulator dataSimulator;

    @Autowired
    private ServicerDao servicerDao;

    @Autowired
    private ReserveDao reserveDao;

    @Autowired
    private EvaluateDao evaluateDao;

    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

    public Random random = new Random();


    @Test
    public void createUser() {
        for (int i = 1; i <= 1000; i++) {
            User user = new User();
            user.setCreatetime(new Date());
            user.setEnablestatus(1);
            user.setAccountname("qq" + i);
            user.setPassword("qq");
            dataSimulator.insertUser(user);
        }
    }

    @Test
    public void createServicer() {
        Long[] stid = {1l, 2l, 3l, 4l, 5l};
        Long[] did = {1l, 2l, 3l};
        Long[] cid = {1l, 2l, 3l, 4l};
        Long[] beijinglocalid = {5l, 6l, 7l, 8l};
        Long[] shanghaiocalid = {9l, 10l, 11l, 12l};
        Long[] guangzhoulocalid = {13l, 14l, 15l, 16l};
        Long[] shenzhenlocalid = {17l, 18l, 19l, 20l};
        System.out.println("start:" + simpleDateFormat.format(new Date()));
        for (int i = 0; i < 200; i++) {
            Servicer servicer = new Servicer();
            servicer.setServiceridnum("0000000000" + i);
            servicer.setServicername("服务人员" + i);
            servicer.setServicerage(random.nextInt(30) + 18);
            servicer.setServicersex(random.nextInt(2) + 1);
            servicer.setServicerphone("131111111111");
            servicer.setServicerimg("/servicerimg/servicerimg37_20190304151736.jpg");
            servicer.setServicerexperience(random.nextInt(85));
            servicer.setServicerscore(0);
            servicer.setServicerprice(random.nextInt(5000) + 3000);
            servicer.setServicerdes("这里是描述" + i);
            servicer.setServicerfile("/servicerfile/servicerfile38_20190301154558.zip");
            WorkArea city = new WorkArea();
            city.setWorkareaid(cid[random.nextInt(4)]);
            servicer.setCity(city);
            WorkArea local = new WorkArea();
            if (city.getWorkareaid() == 1l) {
                local.setWorkareaid(beijinglocalid[random.nextInt(4)]);
            } else if (city.getWorkareaid() == 2l) {
                local.setWorkareaid(shanghaiocalid[random.nextInt(4)]);
            } else if (city.getWorkareaid() == 3l) {
                local.setWorkareaid(guangzhoulocalid[random.nextInt(4)]);
            } else if (city.getWorkareaid() == 4l) {
                local.setWorkareaid(shenzhenlocalid[random.nextInt(4)]);
            }
            servicer.setLocal(local);
            servicer.setCreatetime(new Date());
            servicer.setEnablestatus(1);
            servicer.setCheckstatus(2);
            servicer.setAccountname("aa");
            servicer.setPassword("aa");
            Degree degree = new Degree();
            degree.setDegreeid(did[random.nextInt(3)]);
            servicer.setDegree(degree);
            ServiceType serviceType = new ServiceType();
            serviceType.setServicetypeid(stid[random.nextInt(5)]);
            servicer.setServicetype(serviceType);
            servicer.setServicercontract("/contract/servicercontract/servicercontract49_20190318162914.pdf");
            dataSimulator.insertServicer(servicer);
        }
        System.out.println("end:" + simpleDateFormat.format(new Date()));
    }

    @Test
    public void updateServicerAccount() {
        for (int i = 1; i <= 200; i++) {
            Servicer servicer = new Servicer();
            servicer.setServicerid(i);
            servicer.setAccountname("aa" + i);
            servicerDao.updateServicer(servicer);
        }
    }

    @Test
    public void updateServicerImg() {
        for (int i = 1; i <= 200; i++) {
            Servicer servicer = new Servicer();
            servicer.setServicerid(i);
            servicer.setServicerimg("/servicerimg/servicerimg.jpg");
            servicerDao.updateServicer(servicer);
        }
    }

    @Test
    public void createDegree() {
        List<Degree> degreeList = new ArrayList<>();
        Degree degree1 = new Degree();
        Degree degree2 = new Degree();
        Degree degree3 = new Degree();
        degree1.setDegreename("初中");
        degree1.setPriority(1);
        degree1.setLevel(1000);
        degree2.setDegreename("高中");
        degree2.setPriority(2);
        degree2.setLevel(1500);
        degree3.setDegreename("本科");
        degree3.setPriority(3);
        degree3.setLevel(2000);
        degreeList.add(degree1);
        degreeList.add(degree2);
        degreeList.add(degree3);
        for (Degree d : degreeList) {
            int result = dataSimulator.insertDegree(d);
            if (result <= 0) {
                throw new RuntimeException("插入异常");
            }
        }
        System.out.println("success");
    }

    @Test
    public void createServicetype() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        ServiceType serviceType1 = new ServiceType();
        serviceType1.setServicetypename("小时工");
        serviceType1.setCreatetime(new Date());
        serviceType1.setLevel(500);
        serviceType1.setPriority(1);
        ServiceType serviceType2 = new ServiceType();
        serviceType2.setServicetypename("育儿");
        serviceType2.setCreatetime(new Date());
        serviceType2.setLevel(700);
        serviceType2.setPriority(2);
        ServiceType serviceType3 = new ServiceType();
        serviceType3.setServicetypename("保洁");
        serviceType3.setCreatetime(new Date());
        serviceType3.setLevel(800);
        serviceType3.setPriority(3);
        ServiceType serviceType4 = new ServiceType();
        serviceType4.setServicetypename("护工");
        serviceType4.setCreatetime(new Date());
        serviceType4.setLevel(1000);
        serviceType4.setPriority(4);
        ServiceType serviceType5 = new ServiceType();
        serviceType5.setServicetypename("住家保姆");
        serviceType5.setCreatetime(new Date());
        serviceType5.setLevel(1500);
        serviceType5.setPriority(5);
        serviceTypeList.add(serviceType1);
        serviceTypeList.add(serviceType2);
        serviceTypeList.add(serviceType3);
        serviceTypeList.add(serviceType4);
        serviceTypeList.add(serviceType5);
        for (ServiceType st : serviceTypeList) {
            dataSimulator.insertServicetype(st);
        }
        System.out.println("success");
    }

    @Test
    public void createCity() {
        List<WorkArea> workAreaList = new ArrayList<>();
        WorkArea city1 = new WorkArea();
        city1.setWorkareaname("北京");
        city1.setCreatetime(new Date());
        city1.setLevel(2000);
        city1.setPriority(5);
        WorkArea city2 = new WorkArea();
        city2.setWorkareaname("上海");
        city2.setCreatetime(new Date());
        city2.setLevel(1500);
        city2.setPriority(4);
        WorkArea city3 = new WorkArea();
        city3.setWorkareaname("广州");
        city3.setCreatetime(new Date());
        city3.setLevel(1500);
        city3.setPriority(3);
        WorkArea city4 = new WorkArea();
        city4.setWorkareaname("深圳");
        city4.setCreatetime(new Date());
        city4.setLevel(1500);
        city4.setPriority(2);
        workAreaList.add(city1);
        workAreaList.add(city2);
        workAreaList.add(city3);
        workAreaList.add(city4);
        for (WorkArea w : workAreaList) {
            dataSimulator.insertWorkarea(w);
        }
    }

    @Test
    public void createLocal() {
        System.out.println("start:" + simpleDateFormat.format(new Date()));
        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 1) {
                    WorkArea local = new WorkArea();
                    local.setWorkareaname("北京-local" + j);
                    local.setPriority(j);
                    local.setCreatetime(new Date());
                    WorkArea parent = new WorkArea();
                    parent.setWorkareaid(i);
                    local.setParentarea(parent);
                    dataSimulator.insertWorkarea(local);
                } else if (i == 2) {
                    WorkArea local = new WorkArea();
                    local.setWorkareaname("上海-local" + j);
                    local.setPriority(j);
                    local.setCreatetime(new Date());
                    WorkArea parent = new WorkArea();
                    parent.setWorkareaid(i);
                    local.setParentarea(parent);
                    dataSimulator.insertWorkarea(local);
                } else if (i == 3) {
                    WorkArea local = new WorkArea();
                    local.setWorkareaname("广州-local" + j);
                    local.setPriority(j);
                    local.setCreatetime(new Date());
                    WorkArea parent = new WorkArea();
                    parent.setWorkareaid(i);
                    local.setParentarea(parent);
                    dataSimulator.insertWorkarea(local);
                } else if (i == 4) {
                    WorkArea local = new WorkArea();
                    local.setWorkareaname("深圳-local" + j);
                    local.setPriority(j);
                    local.setCreatetime(new Date());
                    WorkArea parent = new WorkArea();
                    parent.setWorkareaid(i);
                    local.setParentarea(parent);
                    dataSimulator.insertWorkarea(local);
                }
            }
        }
        System.out.println("end:" + simpleDateFormat.format(new Date()));
    }

    @Test
    public void createReserve() {
        Date starttime = new Date();
        Date t_create = new Date();
        Date t_reserve = new Date();
        t_reserve.setTime(t_create.getTime() + 3000l);
        Date t_end = new Date();
        t_end.setTime(t_create.getTime() + 6000l);
        System.out.println("start at" + simpleDateFormat.format(starttime));
        for (int i = 1; i <= 1000; i++) {
            User user = new User();
            user.setUserid(i);
            for (int j = 0; j < random.nextInt(4) + 2; j++) {
                Reserve reserve = new Reserve();
                reserve.setEnablestatus(3);
                reserve.setCreatetime(t_create);
                reserve.setReservecontract("/contract/reservecontract/reservecontract1_20190409192640.pdf");
                reserve.setReservetime(t_reserve);
                reserve.setEndtime(t_end);
                reserve.setUser(user);
                Servicer servicer = new Servicer();
                servicer.setServicerid(random.nextInt(200) + 1);
                reserve.setServicer(servicer);
                reserve.setReserveaddr("addr" + i);
                reserve.setReservedes("des" + i);
                reserve.setReservephone("111111" + i);
                dataSimulator.insertReserve(reserve);
                /*
                插入评价
                 */
                Evaluate evaluate = new Evaluate();
                evaluate.setUser(user);
                evaluate.setServicer(servicer);
                evaluate.setEvaluatescore(random.nextInt(5) + 1);
                evaluate.setEvaluatedes("eval" + i);
                evaluate.setEnablestatus(1);
                evaluate.setCreatetime(new Date());
                dataSimulator.insertEvaluate(evaluate);
                reserve.setEvaluate(evaluate);
                reserveDao.updateReserve(reserve);
            }
        }
        Date endtime = new Date();
        Date passtime = new Date();
        passtime.setTime(endtime.getTime() - starttime.getTime());
        System.out.println("time pass" + simpleDateFormat.format(passtime));
    }

    @Test
    public void createEvaluate() {
        for (long i = 3; i <= 317; i++) {
            Reserve reserve = reserveDao.querySingleReserve(i);
            Evaluate evaluate = new Evaluate();
            evaluate.setEvaluatescore(random.nextInt(5) + 1);
            evaluate.setServicer(reserve.getServicer());
            evaluate.setUser(reserve.getUser());
            evaluate.setEvaluatedes("eval" + i);
            evaluate.setEnablestatus(1);
            evaluate.setCreatetime(new Date());
            dataSimulator.insertEvaluate(evaluate);
            reserve.setEvaluate(evaluate);
            reserveDao.updateReserve(reserve);
        }
    }

    @Test
    public void createRecommend() {
        for (long i = 1; i <= 315; i++) {
            Evaluate id = new Evaluate();
            id.setEvaluateid(i);
            Evaluate evaluate = evaluateDao.querySingleEvaluate(id);
            Recommend recommend = new Recommend();
            recommend.setScore(evaluate.getEvaluatescore());
            recommend.setCreateTime(new Date());
            recommend.setUserId(evaluate.getUser().getUserid());
            recommend.setServicerId(evaluate.getServicer().getServicerid());
            dataSimulator.insertRecommend(recommend);
        }
    }

    @Test
    /*
    添加基于内容的推荐
     */
    public void createContent_Base() {
//        for(int i=1;i<=1000;i++){
//            for(int j=0;j<random.nextInt(5)+1;j++){
//                RecommendCB recommendCB = new RecommendCB();
//                recommendCB.setCreatetime(new Date());
//                recommendCB.setUserid(i);
//                recommendCB.setClickcount(random.nextInt(5)+1);
//                recommendCB.setServicerid(random.nextInt(200) + 1);
//                dataSimulator.insertRecommendCB(recommendCB);
//            }
//        }
        Date date = new Date();
        java.sql.Timestamp timestamp = new Timestamp(date.getTime());
        RecommendCB recommendCB = new RecommendCB();
        recommendCB.setCreatetime(timestamp);
        recommendCB.setUserid(1);
        recommendCB.setClickcount(random.nextInt(5) + 1);
        recommendCB.setServicerid(random.nextInt(200) + 1);
        dataSimulator.insertRecommendCB(recommendCB);
    }
}
