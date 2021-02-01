package com.java2007.zhangjinnan.restaurant.dao;

import com.java2007.zhangjinnan.restaurant.pojo.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDao {

    int save(OrderDetail orderDetail) throws SQLException;

    List<OrderDetail> findByOrderId(Long orderId) throws SQLException;

}
