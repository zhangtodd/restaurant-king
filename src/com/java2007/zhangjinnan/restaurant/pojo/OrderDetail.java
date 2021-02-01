package com.java2007.zhangjinnan.restaurant.pojo;

public class OrderDetail {
    private Integer id;
    private Long orderId;
    private Integer foodId;
    private String foodName;
    //price in cents
    private Integer price;
    private Integer number;
    private Integer amount;

    public OrderDetail() {
    }

    public OrderDetail(Long orderId, Integer foodId, String foodName, Integer price, Integer number, Integer amount) {
        this.orderId = orderId;
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
        this.number = number;
        this.amount = amount;
    }

    public OrderDetail(Integer id, Long orderId, Integer foodId, String foodName, Integer price, Integer number, Integer amount) {
        this.id = id;
        this.orderId = orderId;
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
        this.number = number;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
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
                "id=" + id +
                ", orderId=" + orderId +
                ", foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", amount=" + amount +
                '}';
    }
}
