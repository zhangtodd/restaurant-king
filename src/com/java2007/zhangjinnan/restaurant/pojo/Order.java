package com.java2007.zhangjinnan.restaurant.pojo;

import java.util.Date;

public class Order {
    private Long id;
    private Date createTime;
    private Date updateTime;

    private Integer diningTableId;
    private String diningTableName;
    private Integer memberId;
    private String memberName;

    //price in cents
    private Integer totalAmount;
    //0:下单状态 1:结账状态 -1:退单状态
    private Integer isPay;

    public Order() {
    }

    public Order(Integer diningTableId, String diningTableName, Integer memberId, String memberName,
                 Integer totalAmount, Integer isPay) {
        this.diningTableId = diningTableId;
        this.diningTableName = diningTableName;
        this.memberId = memberId;
        this.memberName = memberName;
        this.totalAmount = totalAmount;
        this.isPay = isPay;
    }

    public Order(Long id, Integer diningTableId, String diningTableName, Integer memberId, String memberName, Integer totalAmount, Integer isPay) {
        this.id = id;
        this.diningTableId = diningTableId;
        this.diningTableName = diningTableName;
        this.memberId = memberId;
        this.memberName = memberName;
        this.totalAmount = totalAmount;
        this.isPay = isPay;
    }

    public Order(Long id, Date createTime, Date updateTime, Integer diningTableId, String diningTableName,
                 Integer memberId, String memberName, Integer totalAmount, Integer isPay) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.diningTableId = diningTableId;
        this.diningTableName = diningTableName;
        this.memberId = memberId;
        this.memberName = memberName;
        this.totalAmount = totalAmount;
        this.isPay = isPay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", diningTableId=" + diningTableId +
                ", diningTableName='" + diningTableName + '\'' +
                ", memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", totalAmount=" + totalAmount +
                ", isPay=" + isPay +
                '}';
    }
}
