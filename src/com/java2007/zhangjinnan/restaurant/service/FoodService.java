package com.java2007.zhangjinnan.restaurant.service;

import com.java2007.zhangjinnan.restaurant.pojo.Food;

import java.sql.SQLException;
import java.util.List;

public interface FoodService {
    List<Food> findAll() throws SQLException;

    List<Food> findByName(String name) throws SQLException;

    Food findById(Integer id) throws SQLException;

    int save(Food food) throws SQLException;

    int update(Food food) throws SQLException;

    int deleteById(Integer id) throws SQLException;

}
