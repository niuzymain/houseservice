package com.house.entity;

/*
学历信息
 */
public class Degree {
    private Long degreeid;
    private String degreename;
    private Integer priority;

    public Long getDegreeid() {
        return this.degreeid;
    }

    public void setDegreeid(Long degreeid) {
        this.degreeid = degreeid;
    }

    public String getDegreename() {
        return this.degreename;
    }

    public void setDegreename(String degreename) {
        this.degreename = degreename;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
