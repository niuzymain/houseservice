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
}
