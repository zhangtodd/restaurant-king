package com.java2007.zhangjinnan.restaurant.pojo;

public class FoodType extends BaseClass {
    private String name;

    public FoodType() {
    }

    public FoodType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FoodType{" +
                "name='" + name + '\'' +
                '}';
    }
}
