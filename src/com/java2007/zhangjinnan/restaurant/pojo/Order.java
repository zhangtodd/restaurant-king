package com.java2007.zhangjinnan.restaurant.pojo;

import java.util.Date;

public class Order extends BaseClass {
    private Integer diningTableId;
    private String diningTableName;
    private Integer memberId;
    private String memberName;

    //price in cents
    private Integer totalAmount;
    private Integer isPay;

    public Order() {
    }

    public Order(Integer id, Date createTime, Date updateTime, Integer diningTableId, String diningTableName,
                 Integer memberId, String memberName, Integer totalAmount, Integer isPay) {
        super(id, createTime, updateTime);
        this.diningTableId = diningTableId;
        this.diningTableName = diningTableName;
        this.memberId = memberId;
        this.memberName = memberName;
        this.totalAmount = totalAmount;
        this.isPay = isPay;
    }

    public Integer getDiningTableId() {
        return diningTableId;
    }

    public void setDiningTableId(Integer diningTableId) {
        this.diningTableId = diningTableId;
    }

    public String getDiningTableName() {
        return diningTableName;
    }

    public void setDiningTableName(String diningTableName) {
        this.diningTableName = diningTableName;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    @Override
    public String toString() {
        return "Order{" +
                "diningTableId=" + diningTableId +
                ", diningTableName='" + diningTableName + '\'' +
                ", memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", totalAmount=" + totalAmount +
                ", isPay=" + isPay +
                '}';
    }
}
