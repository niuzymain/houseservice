package com.house.entity;

import java.util.Date;

/*
首页轮转图
 */
public class Headimg {
    private Long headimgid;
    private String headimgtitle;
    private String headimgdetails;
    private String headimgurl;
    private Integer priority;
    private Integer enablestatus;//0禁用 1可用
    private Date createtime;
    private Date lastedittime;

    public Long getHeadimgid() {
        return this.headimgid;
    }

    public void setHeadimgid(Long headimgid) {
        this.headimgid = headimgid;
    }

    public String getHeadimgtitle() {
        return this.headimgtitle;
    }

    public void setHeadimgtitle(String headimgtitle) {
        this.headimgtitle = headimgtitle;
    }

    public String getHeadimgdetails() {
        return this.headimgdetails;
    }

    public void setHeadimgdetails(String headimgdetails) {
        this.headimgdetails = headimgdetails;
    }

    public String getHeadimgurl() {
        return this.headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getEnablestatus() {
        return this.enablestatus;
    }

    public void setEnablestatus(Integer enablestatus) {
        this.enablestatus = enablestatus;
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
