package com.java2007.zhangjinnan.restaurant.dao;

import com.java2007.zhangjinnan.restaurant.pojo.FoodType;

import java.sql.SQLException;
import java.util.List;

public interface FoodTypeDao {

    List<FoodType> findAll() throws SQLException;

    List<FoodType> findByTypeName(String typeName) throws SQLException;

    FoodType findByTypeId(Integer typeId) throws SQLException;

    int save(FoodType foodType) throws SQLException;

    int update(FoodType foodType) throws SQLException;

    int deleteByTypeId(Integer typeId) throws SQLException;

}
