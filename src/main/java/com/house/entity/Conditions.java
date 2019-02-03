package com.house.entity;

/*
封装所有管理员可编辑条件
 */
public class Conditions {
    private Degree degree;
    private ServiceType serviceType;
    private WorkArea workArea;

    public Degree getDegree() {
        return this.degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public ServiceType getServiceType() {
        return this.serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public WorkArea getWorkArea() {
        return this.workArea;
    }

    public void setWorkArea(WorkArea workArea) {
        this.workArea = workArea;
    }
}
