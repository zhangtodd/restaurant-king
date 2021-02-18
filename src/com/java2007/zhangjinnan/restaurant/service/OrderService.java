package com.java2007.zhangjinnan.restaurant.service;

import com.java2007.zhangjinnan.restaurant.pojo.Order;
import com.java2007.zhangjinnan.restaurant.pojo.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {

    int saveOrderAndDetail(Order order, List<OrderDetail> orderDetailList);

    int save(Order order) throws SQLException;

    int updateOrderStatus(Long orderId, Integer isPay) throws SQLException;

    List<Order> findAll() throws SQLException;

    List<Order> findByMemberId(int memberId) throws SQLException;

}
