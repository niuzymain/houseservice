package com.house.entity;

/*
封装所有管理员可编辑条件
 */
public class Conditions {
    private Degree degree;
    private ServiceType servicetype;
    private WorkArea workarea;

    public Degree getDegree() {
        return this.degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public ServiceType getServicetype() {
        return this.servicetype;
    }

    public void setServicetype(ServiceType servicetype) {
        this.servicetype = servicetype;
    }

    public WorkArea getWorkarea() {
        return this.workarea;
    }

    public void setWorkarea(WorkArea workarea) {
        this.workarea = workarea;
    }
}
