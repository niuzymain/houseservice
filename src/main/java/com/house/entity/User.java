package com.house.entity;

import java.util.Date;
import java.util.List;

/*
用户信息
 */
public class User {
    private long userid;
    private String username;
    private String usersex;
    private Integer enablestatus;
    private String userphone;
    private Date createtime;
    private Date lastedittime;
    private String accountname;
    private String password;
    private String useremail;

    public long getUserid() {
        return this.userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersex() {
        return this.usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public Integer getEnablestatus() {
        return this.enablestatus;
    }

    public void setEnablestatus(Integer enablestatus) {
        this.enablestatus = enablestatus;
    }

    public String getUserphone() {
        return this.userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
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

    public String getAccountname() {
        return this.accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUseremail() {
        return this.useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }
}
