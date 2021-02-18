package com.java2007.zhangjinnan.restaurant.dao;

import com.java2007.zhangjinnan.restaurant.pojo.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    int save(Order order) throws SQLException;

    int updateOrderStatus(Long orderId, Integer isPay) throws SQLException;

    List<Order> findAll() throws SQLException;

    List<Order> findByMemberId(int memberId) throws SQLException;

}
