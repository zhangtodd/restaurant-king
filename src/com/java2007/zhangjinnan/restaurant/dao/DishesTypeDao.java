package com.java2007.zhangjinnan.restaurant.dao;

import com.java2007.zhangjinnan.restaurant.pojo.DishesType;

import java.sql.SQLException;
import java.util.List;

public interface DishesTypeDao {

    List<DishesType> findAll() throws SQLException;

    List<DishesType> findByTypeName(String typeName) throws SQLException;

    DishesType findByTypeId(Integer typeId) throws SQLException;

    int save(DishesType dishesType) throws SQLException;

    int update(DishesType dishesType) throws SQLException;

    int deleteByTypeId(Integer typeId) throws SQLException;

}
