package com.house.dto;

import com.house.entity.Headimg;
import com.house.enums.HeadimgEnum;

import java.util.List;

public class HeadimgExecution {
    private int state;
    private String stateinfo;
    private Headimg headimg;
    private List<Headimg> headimgList;
    public HeadimgExecution(){

    }
    //操作失败
    public HeadimgExecution(HeadimgEnum headimgEnum){
        this.state = headimgEnum.getState();
        this.stateinfo = headimgEnum.getStateinfo();
    }
    //操作成功
    public HeadimgExecution(HeadimgEnum headimgEnum,Headimg headimg){
        this.state = headimgEnum.getState();
        this.stateinfo = headimgEnum.getStateinfo();
        this.headimg = headimg;
    }

    public HeadimgExecution(HeadimgEnum headimgEnum,List<Headimg> headimgList){
        this.state = headimgEnum.getState();
        this.stateinfo = headimgEnum.getStateinfo();
        this.headimgList = headimgList;
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

    public Headimg getHeadimg() {
        return this.headimg;
    }

    public void setHeadimg(Headimg headimg) {
        this.headimg = headimg;
    }

    public List<Headimg> getHeadimgList() {
        return this.headimgList;
    }

    public void setHeadimgList(List<Headimg> headimgList) {
        this.headimgList = headimgList;
    }
}
