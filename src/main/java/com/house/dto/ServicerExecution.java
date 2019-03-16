package com.house.dto;

import com.house.entity.Servicer;
import com.house.enums.ServicerEnum;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.sql.SQLException;
import java.util.List;

public class ServicerExecution {
    private int state;
    private String stateinfo;
    private Servicer servicer;
    private List<Servicer> servicerList;
    public ServicerExecution(){

    }
    //操作失败
    public ServicerExecution(ServicerEnum servicerEnum){
        this.state = servicerEnum.getState();
        this.stateinfo = servicerEnum.getStateinfo();
    }
    //操作成功
    public ServicerExecution(ServicerEnum servicerEnum, Servicer servicer){
        this.state = servicerEnum.getState();
        this.stateinfo = servicerEnum.getStateinfo();
        this.servicer = servicer;
    }

    public ServicerExecution(ServicerEnum servicerEnum, List<Servicer> servicerList){
        this.state = servicerEnum.getState();
        this.stateinfo = servicerEnum.getStateinfo();
        this.servicerList = servicerList;
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

    public Servicer getServicer() {
        return this.servicer;
    }

    public void setServicer(Servicer servicer) {
        this.servicer = servicer;
    }

    public List<Servicer> getServicerList() {
        return this.servicerList;
    }

    public void setServicerList(List<Servicer> servicerList) {
        this.servicerList = servicerList;
    }
}
