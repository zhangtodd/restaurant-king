package com.java2007.zhangjinnan.restaurant.service;

import com.java2007.zhangjinnan.restaurant.pojo.DiningTable;

import java.sql.SQLException;
import java.util.List;

public interface DiningTableService {
    List<DiningTable> findAll() throws SQLException;

    List<DiningTable> findByName(String keyword) throws SQLException;

    int save(DiningTable diningTable) throws SQLException;

    int update(DiningTable diningTable, Integer bookStatus) throws SQLException;

    int deleteById(Integer id) throws SQLException;

    int payBill(Integer id, Long orderId, Integer payStatus) throws SQLException;
}
