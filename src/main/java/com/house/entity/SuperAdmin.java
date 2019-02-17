package com.house.entity;
/*
超级管理员
 */
public class SuperAdmin {
    private Long superadminid;
    private String accountname;
    private String password;

    public Long getSuperadminid() {
        return this.superadminid;
    }

    public void setSuperadminid(Long superadminid) {
        this.superadminid = superadminid;
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
}
