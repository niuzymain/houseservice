package com.house.entity;

import java.util.Date;

/*
服务人员
 */
public class Servicer {
    private long servicerid;
    private String serviceridnum;
    private String servicername;
    private Integer servicerage;
    private Integer servicersex; //1.男 2.女
    private String servicerphone;
    private String servicerimg;
    private Integer servicerexperience; //月为单位
    private Integer servicerscore;
    private Integer servicerprice;
    private String servicerdes;
    private String servicerfile; //提交的申请文件，zip格式
    private Degree degree;
    private ServiceType servicetype;
    private WorkArea city;
    private WorkArea local;
    private Date createtime;
    private Date lastedittime;
    private Integer enablestatus;// -1.离职 0.禁用 1.可用 2.服务中
    private Integer checkstatus; //0.审核 1.待签合同 2.通过 -1.未通过
    private String accountname;
    private String password;
    private String servicercontract;
    private Integer servicecount;

    public Integer getServicecount() {
        return this.servicecount;
    }

    public void setServicecount(Integer servicecount) {
        this.servicecount = servicecount;
    }

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

    public Integer getServicersex() {
        return this.servicersex;
    }

    public void setServicersex(Integer servicersex) {
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

    public Integer getServicerexperience() {
        return this.servicerexperience;
    }

    public void setServicerexperience(Integer servicerexperience) {
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

    public Integer getServicerprice() {
        return this.servicerprice;
    }

    public void setServicerprice(Integer servicerprice) {
        this.servicerprice = servicerprice;
    }

    public String getServicerdes() {
        return this.servicerdes;
    }

    public void setServicerdes(String servicerdes) {
        this.servicerdes = servicerdes;
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

    public ServiceType getServicetype() {
        return this.servicetype;
    }

    public void setServicetype(ServiceType servicetype) {
        this.servicetype = servicetype;
    }

    public WorkArea getCity() {
        return this.city;
    }

    public void setCity(WorkArea city) {
        this.city = city;
    }

    public Integer getCheckstatus() {
        return this.checkstatus;
    }

    public void setCheckstatus(Integer checkstatus) {
        this.checkstatus = checkstatus;
    }

    public WorkArea getLocal() {
        return this.local;
    }

    public void setLocal(WorkArea local) {
        this.local = local;
    }

    public String getServiceridnum() {
        return this.serviceridnum;
    }

    public void setServiceridnum(String serviceridnum) {
        this.serviceridnum = serviceridnum;
    }

    public String getServicercontract() {
        return this.servicercontract;
    }

    public void setServicercontract(String servicercontract) {
        this.servicercontract = servicercontract;
    }

}

