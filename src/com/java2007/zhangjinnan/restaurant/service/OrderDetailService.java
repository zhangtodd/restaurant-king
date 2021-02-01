package com.java2007.zhangjinnan.restaurant.service;

import com.java2007.zhangjinnan.restaurant.pojo.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailService {
    int save(OrderDetail orderDetail);

    List<OrderDetail> findByOrderId(int orderId) throws SQLException;

}
