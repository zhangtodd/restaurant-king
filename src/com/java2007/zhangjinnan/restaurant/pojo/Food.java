package com.java2007.zhangjinnan.restaurant.pojo;

import java.util.Date;

public class Food extends BaseClass {
    private String name;
    private Integer foodTypeId;
    private Integer foodTypeName;
    //price in cents
    private Integer price;
    private Integer memberPrice;
    private String image;
    private String description;

    public Food() {
    }

    public Food(Integer id, Date createTime, Date updateTime, String name, Integer foodTypeId, Integer foodTypeName,
                Integer price, Integer memberPrice, String image, String description) {
        super(id, createTime, updateTime);
        this.name = name;
        this.foodTypeId = foodTypeId;
        this.foodTypeName = foodTypeName;
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

    public Integer getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(Integer foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    public Integer getFoodTypeName() {
        return foodTypeName;
    }

    public void setFoodTypeName(Integer foodTypeName) {
        this.foodTypeName = foodTypeName;
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

    @Override
    public String toString() {
        return "Food2{" +
                "name='" + name + '\'' +
                ", foodTypeId=" + foodTypeId +
                ", foodTypeName=" + foodTypeName +
                ", price=" + price +
                ", memberPrice=" + memberPrice +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
