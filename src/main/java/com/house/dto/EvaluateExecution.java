package com.house.dto;

import com.house.entity.Evaluate;

import java.util.List;

public class EvaluateExecution {
    private List<Evaluate> evaluateList;
    private int evaluatecount;
    public EvaluateExecution(List<Evaluate> evaluateList, int evaluatecount){
        this.evaluatecount = evaluatecount;
        this.evaluateList = evaluateList;
    }

    public List<Evaluate> getEvaluateList() {
        return this.evaluateList;
    }

    public void setEvaluateList(List<Evaluate> evaluateList) {
        this.evaluateList = evaluateList;
    }

    public int getEvaluatecount() {
        return this.evaluatecount;
    }

    public void setEvaluatecount(int evaluatecount) {
        this.evaluatecount = evaluatecount;
    }
}
