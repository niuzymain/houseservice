package com.house.entity;
/*
超级管理员
 */
public class SuperAdmin {
    private Long superadminid;
    private String superadminname;
    private Account account;

    public Long getSuperadminid() {
        return this.superadminid;
    }

    public void setSuperadminid(Long superadminid) {
        this.superadminid = superadminid;
    }

    public String getSuperadminname() {
        return this.superadminname;
    }

    public void setSuperadminname(String superadminname) {
        this.superadminname = superadminname;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
