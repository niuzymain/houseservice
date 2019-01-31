package com.house.entity;

import java.util.Date;

/*
预定信息
 */
public class Reserve {
    private long reserveid;
    private Date reservetime;
    private String reserveaddr;
    private String reservedes;
    private String reservephone;
    private User user;
    private Servicer servicer;

    public long getReserveid() {
        return this.reserveid;
    }

    public void setReserveid(long reserveid) {
        this.reserveid = reserveid;
    }

    public Date getReservetime() {
        return this.reservetime;
    }

    public void setReservetime(Date reservetime) {
        this.reservetime = reservetime;
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
}
