package com.java2007.zhangjinnan.restaurant.pojo;

import java.util.Date;

public class OrderDetail extends BaseClass {
    private Integer orderId;
    private Integer foodId;
    //price in cents
    private Integer price;
    private Integer number;
    private Integer amount;

    public OrderDetail() {
    }

    public OrderDetail(Integer id, Date createTime, Date updateTime, Integer orderId, Integer foodId, Integer price, Integer number, Integer amount) {
        super(id, createTime, updateTime);
        this.orderId = orderId;
        this.foodId = foodId;
        this.price = price;
        this.number = number;
        this.amount = amount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderId=" + orderId +
                ", foodId=" + foodId +
                ", price=" + price +
                ", number=" + number +
                ", amount=" + amount +
                '}';
    }
}
