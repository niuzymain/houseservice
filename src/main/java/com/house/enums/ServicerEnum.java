package com.house.enums;

public enum ServicerEnum {
    SUCCESS(1,"success"),
    Servicing(0,"服务中,不可接受其他预约"),
    TYPENULl(-1,"状态为空"),
    ERRORFORMAT(-2,"格式错误"),
    ERROR(-1004,"内部错误");
    private int state;
    private String stateinfo;

    ServicerEnum(int state, String stateinfo){
        this.state = state;
        this.stateinfo = stateinfo;
    }

    public int getState() {
        return this.state;
    }

    public String getStateinfo() {
        return this.stateinfo;
    }
}
