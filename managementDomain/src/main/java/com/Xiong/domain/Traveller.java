package com.Xiong.domain;

import java.util.List;

public class Traveller {
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialType;
    private String credentialTypeDesc;
    private String credentialNum;
    private Integer travellerType;
    private String travellerTypeDesc;
    private List<Order> orders;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialType() {
        return credentialType;
    }

    public void setCredentialType(Integer credentialType) {
        this.credentialType = credentialType;
    }

    public String getCredentialTypeDesc() {
        if (credentialType == 0) {
            return "身份证";
        } else if (credentialType == 1) {
            return "军官证";
        } else {
            return "护照";
        }
    }

    public void setCredentialTypeDesc(String credentialTypeDesc) {
        this.credentialTypeDesc = credentialTypeDesc;
    }

    public String getCredentialNum() {
        return credentialNum;
    }

    public void setCredentialNum(String credentialNum) {
        this.credentialNum = credentialNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeDesc() {
        return travellerTypeDesc;
    }

    public void setTravellerTypeDesc(String travellerTypeDesc) {
        this.travellerTypeDesc = travellerTypeDesc;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", credentialType=" + credentialType +
                ", credentialTypeDesc='" + credentialTypeDesc + '\'' +
                ", credentialNum='" + credentialNum + '\'' +
                ", travellerType=" + travellerType +
                ", travellerTypeDesc='" + travellerTypeDesc + '\'' +
                '}';
    }
}
