package com.house.entity;

import java.util.Date;

/*
基于用户协同过滤推荐数据表，记录用户预约记录
*/
public class Recommend {
    private long recommendId;

    private long userId;

    private long servicerId;

    private int score;

    private Date createTime;

    public long getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(long recommendId) {
        this.recommendId = recommendId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getServicerId() {
        return servicerId;
    }

    public void setServicerId(long servicerId) {
        this.servicerId = servicerId;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}