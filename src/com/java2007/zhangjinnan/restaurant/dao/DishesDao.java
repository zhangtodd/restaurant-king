package com.java2007.zhangjinnan.restaurant.dao;

import com.java2007.zhangjinnan.restaurant.pojo.Dishes;

import java.util.List;

public interface DishesDao {

    int save(Dishes dishes);

    Dishes findById(Integer id);

    //TODO 为什么传Dishes类
    List<Dishes> findByPage();


}
