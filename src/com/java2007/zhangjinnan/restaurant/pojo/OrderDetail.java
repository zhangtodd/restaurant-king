package com.java2007.zhangjinnan.restaurant.pojo;

public class OrderDetail extends BaseClass {
    private Integer orderId;
    private Integer dishesId;

    //price in cents
    private Integer price;
    private Integer number;
    private Integer amount;

    public OrderDetail() {
    }

    public OrderDetail(Integer orderId, Integer dishesId, Integer price, Integer number, Integer amount) {
        this.orderId = orderId;
        this.dishesId = dishesId;
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

    public Integer getDishesId() {
        return dishesId;
    }

    public void setDishesId(Integer dishesId) {
        this.dishesId = dishesId;
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
}
