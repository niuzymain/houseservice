package com.house.entity;

import java.util.Date;
/*
工作地点
 */
public class WorkArea {
    private long workareaid;
    private String workareaname;
    private Integer priority;
    private Date createtime;
    private Date lastedittime;

    public long getWorkareaid() {
        return this.workareaid;
    }

    public void setWorkareaid(long workareaid) {
        this.workareaid = workareaid;
    }

    public String getWorkareaname() {
        return this.workareaname;
    }

    public void setWorkareaname(String workareaname) {
        this.workareaname = workareaname;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastedittime() {
        return this.lastedittime;
    }

    public void setLastedittime(Date lastedittime) {
        this.lastedittime = lastedittime;
    }
}
