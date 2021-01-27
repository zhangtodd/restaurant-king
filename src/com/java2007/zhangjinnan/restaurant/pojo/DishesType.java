package com.java2007.zhangjinnan.restaurant.pojo;

public class DishesType extends BaseClass {
    private String name;

    public DishesType() {
    }

    public DishesType(String name) {
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
        return "DishesType{" +
                "name='" + name + '\'' +
                '}';
    }
}
