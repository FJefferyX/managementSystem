package com.Xiong.domain;

import com.Xiong.utils.DateUtils;

import java.sql.Timestamp;
import java.util.Date;

public class Product {
    private String id;  //主键
    private String productNum;//编号 唯一
    private String productName;//产品名称
    private String cityName;//出发城市
    private Date departureTime;//出发时间
    private String depatureTimeStr;//出发时间字符串表示
    private double productPrice;//产品价格
    private String productDesc;//产品描述
    private Integer productStatus;//状态 0关闭 1开启
    private String productStatusStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepatureTime() {
        return departureTime;
    }

    public void setDepatureTime(Date depatureTime) {
        this.departureTime = depatureTime;
    }

    public String getDepatureTimeStr() {
        if (this.departureTime != null) {
            return DateUtils.dateToString(departureTime, "yyyy-MM-dd HH:mm:ss");
        } else {
            return null;
        }
    }

    public void setDepatureTimeStr(String depatureTimeStr) {
        this.depatureTimeStr = depatureTimeStr;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if (this.productStatus == 0) {
            return "关闭";
        } else {
            return "开启";
        }
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", depatureTime=" + departureTime +
                ", depatureTimeStr='" + depatureTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }
}
