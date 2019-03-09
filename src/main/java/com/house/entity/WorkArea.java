package com.house.entity;

import java.util.Date;
import java.util.List;

/*
工作地点,分两级，城市和地区
 */
public class WorkArea {
    private long workareaid;
    private String workareaname;
    private Integer priority;
    private Date createtime;
    private Date lastedittime;
    private WorkArea parentarea;
    private List<Servicer> servicerList;
    private Integer level;
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

    public WorkArea getParentarea() {
        return this.parentarea;
    }

    public void setParentarea(WorkArea parentarea) {
        this.parentarea = parentarea;
    }

    public List<Servicer> getServicerList() {
        return this.servicerList;
    }

    public void setServicerList(List<Servicer> servicerList) {
        this.servicerList = servicerList;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
