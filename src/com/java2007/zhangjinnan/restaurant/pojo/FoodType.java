package com.java2007.zhangjinnan.restaurant.pojo;

import java.util.Date;

public class FoodType {
    private Integer id;
    private Date createTime;
    private Date updateTime;
    private String name;

    public FoodType() {
    }

    public FoodType(String name) {
        this.name = name;
    }

    public FoodType(Integer id, Date createTime, Date updateTime, String name) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FoodType{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", name='" + name + '\'' +
                '}';
    }
}
