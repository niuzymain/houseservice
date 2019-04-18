package com.house.dto;

import com.house.entity.Servicer;
import com.house.entity.User;
import com.house.enums.UserEnum;

import java.util.List;

public class UserExecution {
    private int state;
    private String stateinfo;
    private User user;
    private List<User> userList;
    private int usercount;

    public UserExecution(){
    }

    public UserExecution(UserEnum userEnum){
        this.state = userEnum.getState();
        this.stateinfo = userEnum.getStateinfo();
    }
    public UserExecution(UserEnum userEnum,User user){
        this.state = userEnum.getState();
        this.stateinfo = userEnum.getStateinfo();
        this.user = user;
    }
    public UserExecution(UserEnum userEnum, List<User> userList,int usercount){
        this.state = userEnum.getState();
        this.stateinfo = userEnum.getStateinfo();
        this.userList = userList;
        this.usercount = usercount;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateinfo() {
        return this.stateinfo;
    }

    public void setStateinfo(String stateinfo) {
        this.stateinfo = stateinfo;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return this.userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getUsercount() {
        return this.usercount;
    }

    public void setUsercount(int usercount) {
        this.usercount = usercount;
    }
}
