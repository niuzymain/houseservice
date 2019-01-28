package com.house.entity;

import org.springframework.stereotype.Component;

@Component
public class Account {
    private int accountid;
    private String username;
    private String password;

    public int getAccountid() {
        return this.accountid;
    }

    public void setAccountid(int accountid) {
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
}
