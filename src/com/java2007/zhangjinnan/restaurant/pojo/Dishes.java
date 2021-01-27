package com.java2007.zhangjinnan.restaurant.pojo;

public class Dishes extends BaseClass {
    private String name;
    private Integer dishesTypeId;
    private Integer dishesTypeName;

    //price in cents
    private Integer price;
    private Integer memberPrice;
    private String image;
    private String description;

    public Dishes() {
    }

    public Dishes(String name, Integer dishesTypeId, Integer dishesTypeName, Integer price, Integer memberPrice, String image, String description) {
        this.name = name;
        this.dishesTypeId = dishesTypeId;
        this.dishesTypeName = dishesTypeName;
        this.price = price;
        this.memberPrice = memberPrice;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDishesTypeId() {
        return dishesTypeId;
    }

    public void setDishesTypeId(Integer dishesTypeId) {
        this.dishesTypeId = dishesTypeId;
    }

    public Integer getDishesTypeName() {
        return dishesTypeName;
    }

    public void setDishesTypeName(Integer dishesTypeName) {
        this.dishesTypeName = dishesTypeName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(Integer memberPrice) {
        this.memberPrice = memberPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
