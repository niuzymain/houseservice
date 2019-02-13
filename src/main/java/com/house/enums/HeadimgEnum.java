package com.house.enums;

public enum  HeadimgEnum {
    SUCCESS(1,"success"),
    IMGNULL(0,"图片为空"),
    ERROR(-1004,"内部错误"),
    TYPENULL(-1,"非法操作");
    private int state;
    private String stateinfo;

    private HeadimgEnum(int state,String stateinfo){
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
