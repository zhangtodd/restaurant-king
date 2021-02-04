package com.java2007.zhangjinnan.restaurant.dao;

import com.java2007.zhangjinnan.restaurant.pojo.Food;

import java.sql.SQLException;
import java.util.List;

public interface FoodDao {

    List<Food> findAll() throws SQLException;

    List<Food> findByName(String foodName) throws SQLException;

    Food findById(Integer id) throws SQLException;

    List<Food> findByTypeId(Integer typeId) throws SQLException;

    int save(Food food) throws SQLException;

    int update(Food food) throws SQLException;

    int deleteById(Integer id) throws SQLException;

    List<Food> findByPage();

}
