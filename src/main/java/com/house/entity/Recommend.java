package com.house.entity;
import java.util.Date;

public class Recommend {
    private long recommendId;

    private long userId;

    private long servicerId;

    private long checkTimes;//点击次数

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

    public long getCheckTimes() {
        return checkTimes;
    }

    public void setCheckTimes(long checkTimes) {
        this.checkTimes = checkTimes;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}