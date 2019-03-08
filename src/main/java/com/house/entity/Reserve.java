package com.house.entity;

import java.util.Date;

/*
预定信息
 */
public class Reserve {
    private long reserveid;
    private Date createtime;
    private Date reservetime;
    private Date endtime;
    private String reserveaddr;
    private String reservecontract;
    private String reservedes;
    private String reservephone;
    private String reservemsg;//预约留言，服务人员编辑
    private User user;
    private Servicer servicer;
    private Integer enablestatus;//预约状态  -1.取消 0.等待 1.已受理 2.已确认 3.已完成

    public long getReserveid() {
        return this.reserveid;
    }

    public void setReserveid(long reserveid) {
        this.reserveid = reserveid;
    }

    public Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getReserveaddr() {
        return this.reserveaddr;
    }

    public void setReserveaddr(String reserveaddr) {
        this.reserveaddr = reserveaddr;
    }

    public String getReservedes() {
        return this.reservedes;
    }

    public void setReservedes(String reservedes) {
        this.reservedes = reservedes;
    }

    public String getReservephone() {
        return this.reservephone;
    }

    public void setReservephone(String reservephone) {
        this.reservephone = reservephone;
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

    public String getReservemsg() {
        return this.reservemsg;
    }

    public void setReservemsg(String reservemsg) {
        this.reservemsg = reservemsg;
    }

    public Integer getEnablestatus() {
        return this.enablestatus;
    }

    public void setEnablestatus(Integer enablestatus) {
        this.enablestatus = enablestatus;
    }

    public Date getReservetime() {
        return this.reservetime;
    }

    public void setReservetime(Date reservetime) {
        this.reservetime = reservetime;
    }

    public Date getEndtime() {
        return this.endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getReservecontract() {
        return this.reservecontract;
    }

    public void setReservecontract(String reservecontract) {
        this.reservecontract = reservecontract;
    }
}
