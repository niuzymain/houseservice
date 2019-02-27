package com.house.entity;

import java.util.Date;

/*
用户评价
 */
public class  Evaluate {
    private long evaluateid;
    private String evaluatedes;
    private Integer evaluatescore;
    private Date createtime;
    private User user;             //评论来自哪个用户
    private Servicer servicer;    //评论针对哪个servicer
    private Integer enablestatus;//0.投诉 1.正常评价

    public long getEvaluateid() {
        return this.evaluateid;
    }

    public void setEvaluateid(long evaluateid) {
        this.evaluateid = evaluateid;
    }

    public String getEvaluatedes() {
        return this.evaluatedes;
    }

    public void setEvaluatedes(String evaluatedes) {
        this.evaluatedes = evaluatedes;
    }

    public Integer getEvaluatescore() {
        return this.evaluatescore;
    }

    public void setEvaluatescore(Integer evaluatescore) {
        this.evaluatescore = evaluatescore;
    }

    public Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Servicer getServicer() {
        return this.servicer;
    }

    public void setServicer(Servicer servicer) {
        this.servicer = servicer;
    }

    public Integer getEnablestatus() {
        return this.enablestatus;
    }

    public void setEnablestatus(Integer enablestatus) {
        this.enablestatus = enablestatus;
    }
}
