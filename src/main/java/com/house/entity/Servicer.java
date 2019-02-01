package com.house.entity;

import java.util.Date;
import java.util.List;
/*
服务人员
 */
public class Servicer {
    private long servicerid;
    private String servicername;
    private Integer servicerage;
    private String servicersex;
    private String servicerphone;
    private String servicerimg;
    private String servicerexperience;
    private Integer servicerscore;
    private String servicerprice;
    private String servicerdes;
    private String servicerfile; //提交的申请文件，zip格式
    private Degree degree;
    List<ServiceType> serviceTypeList;
    List<WorkArea> workAreaList;
    private Date createtime;
    private Date lastedittime;
    private Account account;
    private Integer enablestatus;//-1.禁用 0.审核中 1.空闲 2.正在服务

    public long getServicerid() {
        return this.servicerid;
    }

    public void setServicerid(long servicerid) {
        this.servicerid = servicerid;
    }

    public String getServicername() {
        return this.servicername;
    }

    public void setServicername(String servicername) {
        this.servicername = servicername;
    }

    public Integer getServicerage() {
        return this.servicerage;
    }

    public void setServicerage(Integer servicerage) {
        this.servicerage = servicerage;
    }

    public String getServicersex() {
        return this.servicersex;
    }

    public void setServicersex(String servicersex) {
        this.servicersex = servicersex;
    }

    public String getServicerphone() {
        return this.servicerphone;
    }

    public void setServicerphone(String servicerphone) {
        this.servicerphone = servicerphone;
    }

    public String getServicerimg() {
        return this.servicerimg;
    }

    public void setServicerimg(String servicerimg) {
        this.servicerimg = servicerimg;
    }

    public String getServicerexperience() {
        return this.servicerexperience;
    }

    public void setServicerexperience(String servicerexperience) {
        this.servicerexperience = servicerexperience;
    }

    public Integer getServicerscore() {
        return this.servicerscore;
    }

    public String getServicerfile() {
        return this.servicerfile;
    }

    public void setServicerfile(String servicerfile) {
        this.servicerfile = servicerfile;
    }

    public void setServicerscore(Integer servicerscore) {
        this.servicerscore = servicerscore;
    }

    public String getServicerprice() {
        return this.servicerprice;
    }

    public void setServicerprice(String servicerprice) {
        this.servicerprice = servicerprice;
    }

    public String getServicerdes() {
        return this.servicerdes;
    }

    public void setServicerdes(String servicerdes) {
        this.servicerdes = servicerdes;
    }

    public List<ServiceType> getServiceTypeList() {
        return this.serviceTypeList;
    }

    public void setServiceTypeList(List<ServiceType> serviceTypeList) {
        this.serviceTypeList = serviceTypeList;
    }

    public List<WorkArea> getWorkAreaList() {
        return this.workAreaList;
    }

    public void setWorkAreaList(List<WorkArea> workAreaList) {
        this.workAreaList = workAreaList;
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

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getEnablestatus() {
        return this.enablestatus;
    }

    public void setEnablestatus(Integer enablestatus) {
        this.enablestatus = enablestatus;
    }

    public Degree getDegree() {
        return this.degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
}
