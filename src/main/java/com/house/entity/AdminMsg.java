package com.house.entity;


import java.util.Date;

/*
管理员消息
 */
public class AdminMsg {
    private Long adminmsgid;
    private String adminmsgdes;
    private Date createtime;
    private User user;
    private Servicer servicer;
    private Integer type; //0.特定对象 1.面向用户 2.面向服务人员 3.面向所有用户

    public Long getAdminmsgid() {
        return this.adminmsgid;
    }

    public void setAdminmsgid(Long adminmsgid) {
        this.adminmsgid = adminmsgid;
    }

    public String getAdminmsgdes() {
        return this.adminmsgdes;
    }

    public void setAdminmsgdes(String adminmsgdes) {
        this.adminmsgdes = adminmsgdes;
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

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
