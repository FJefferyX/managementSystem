package com.Xiong.domain;

import com.Xiong.utils.DateUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Order {
    private String id;
    private String orderNum;
    private Timestamp orderTime;
    private String orderTimeDesc;
    private Integer peopleCount;
    private String orderDesc;
    private Integer payType;
    private String payTypeDesc;
    private Integer orderStatus;
    private String orderStatusDesc;
    private String productId;
    private String memberId;
    private Member member;
    private Product product;
    private List<Traveller> travellers;

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeDesc() {
        if (this.orderTime != null) {
            return DateUtils.dateToString(orderTime, "yyyy-MM-dd HH:mm:ss");
        } else {
            return orderTimeDesc;
        }
    }

    public void setOrderTimeDesc(String orderTimeDesc) {
        this.orderTimeDesc = orderTimeDesc;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeDesc() {
        if (this.payType == 0) {
            return "微信";
        } else if (this.payType == 1) {
            return "支付宝";
        } else {
            return "其他";
        }
    }

    public void setPayTypeDesc(String payTypeDesc) {
        this.payTypeDesc = payTypeDesc;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusDesc() {
        if (this.orderStatus == 0) {
            return "关闭";
        } else {
            return "开启";
        }
    }

    public void setOrderStatusDesc(String orderStatusDesc) {
        this.orderStatusDesc = orderStatusDesc;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeDesc='" + orderTimeDesc + '\'' +
                ", peopleCount=" + peopleCount +
                ", orderDesc='" + orderDesc + '\'' +
                ", payType=" + payType +
                ", payTypeDesc='" + payTypeDesc + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusDesc='" + orderStatusDesc + '\'' +
                ", productId='" + productId + '\'' +
                ", memberId='" + memberId + '\'' +
                '}';
    }
}
