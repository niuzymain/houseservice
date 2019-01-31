package com.house.entity;

import java.util.Date;
/*
服务类别
 */
public class ServiceType {
    private long servicetypeid;
    private String servicetypename;
    private Integer priority;
    private Date createtime;
    private Date lastedittime;

    public long getServicetypeid() {
        return this.servicetypeid;
    }

    public void setServicetypeid(long servicetypeid) {
        this.servicetypeid = servicetypeid;
    }

    public String getServicetypename() {
        return this.servicetypename;
    }

    public void setServicetypename(String servicetypename) {
        this.servicetypename = servicetypename;
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
