package com.java2007.zhangjinnan.restaurant.dao;

import com.java2007.zhangjinnan.restaurant.pojo.Food;

import java.util.List;

public interface FoodDao {

    int save(Food food);

    Food findById(Integer id);

    List<Food> findByPage();



}
