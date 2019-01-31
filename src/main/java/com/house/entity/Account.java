package com.house.entity;

/*
账户信息
 */
public class Account {
    private long accountid;
    private String username;
    private String password;
    private int accounttype; //1.用户 2.服务人员 3.管理员

    public long getAccountid() {
        return this.accountid;
    }

    public void setAccountid(long accountid) {
        this.accountid = accountid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccounttype() {
        return this.accounttype;
    }

    public void setAccounttype(int accounttype) {
        this.accounttype = accounttype;
    }
}
