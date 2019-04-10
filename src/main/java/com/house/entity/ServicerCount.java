package com.house.entity;

/*
封装服务人员被查看次数，供CB推荐使用
 */
public class ServicerCount {
    private Servicer servicer;
    private int count;

    public Servicer getServicer() {
        return this.servicer;
    }

    public void setServicer(Servicer servicer) {
        this.servicer = servicer;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
