package com.java2007.zhangjinnan.restaurant.service;

import com.java2007.zhangjinnan.restaurant.pojo.FoodType;

import java.sql.SQLException;
import java.util.List;

public interface FoodTypeService {
    List<FoodType> findAll() throws SQLException;

    List<FoodType> findByTypeName(String typeName) throws SQLException;

    FoodType findByTypeId(Integer typeId) throws SQLException;

    int save(FoodType foodType) throws SQLException;

    int update(FoodType foodType) throws SQLException;

    int deleteByTypeId(Integer typeId) throws SQLException;

}
