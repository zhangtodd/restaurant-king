package com.java2007.zhangjinnan.restaurant.service;

import com.java2007.zhangjinnan.restaurant.pojo.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {

    int save(Order order) throws SQLException;

    int updateOrderStatus(int orderId) throws SQLException;

    List<Order> findAll() throws SQLException;

    List<Order> findByMemberId(int memberId) throws SQLException;

}
