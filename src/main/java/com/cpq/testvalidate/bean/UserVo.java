package com.cpq.testvalidate.bean;

import java.math.BigDecimal;
import java.util.List;

public class UserVo extends User {
    private String validateMessage;
    private float salaryNum;
    private Girl girl;
    private List<Dream> dreamList;
    private List<String> hobbyList;
    private BigDecimal bigNum;

    public String getValidateMessage() {
        return validateMessage;
    }

    public void setValidateMessage(String validateMessage) {
        this.validateMessage = validateMessage;
    }

    public float getSalaryNum() {
        return salaryNum;
    }

    public void setSalaryNum(float salaryNum) {
        this.salaryNum = salaryNum;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    public List<Dream> getDreamList() {
        return dreamList;
    }

    public void setDreamList(List<Dream> dreamList) {
        this.dreamList = dreamList;
    }

    public List<String> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<String> hobbyList) {
        this.hobbyList = hobbyList;
    }

    public BigDecimal getBigNum() {
        return bigNum;
    }

    public void setBigNum(BigDecimal bigNum) {
        this.bigNum = bigNum;
    }
}
