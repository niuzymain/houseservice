package com.house.entity;

import java.util.Date;

/*
基于内容推荐数据表，记录用户查看点击事件
*/
public class RecommendCB {
    private long cbid;
    private long userid;
    private long servicerid;
    private Date createtime;
    private int clickcount;

    public long getCbid() {
        return this.cbid;
    }

    public void setCbid(long cbid) {
        this.cbid = cbid;
    }

    public long getUserid() {
        return this.userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getServicerid() {
        return this.servicerid;
    }

    public void setServicerid(long servicerid) {
        this.servicerid = servicerid;
    }

    public Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getClickcount() {
        return this.clickcount;
    }

    public void setClickcount(int clickcount) {
        this.clickcount = clickcount;
    }
}
