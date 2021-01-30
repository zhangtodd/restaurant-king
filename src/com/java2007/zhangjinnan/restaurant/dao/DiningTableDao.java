package com.java2007.zhangjinnan.restaurant.dao;

import com.java2007.zhangjinnan.restaurant.pojo.DiningTable;

import java.sql.SQLException;
import java.util.List;

public interface DiningTableDao {
    List<DiningTable> findAll() throws SQLException;

    List<DiningTable> findByName(String keyword) throws SQLException;

    int save(DiningTable diningTable) throws SQLException;

    int update(DiningTable diningTable, Integer bookStatus) throws SQLException;

    int deleteById(Integer id) throws SQLException;

}
