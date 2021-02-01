package com.java2007.zhangjinnan.restaurant.service.impl;

import com.java2007.zhangjinnan.restaurant.constant.DaoConstant;
import com.java2007.zhangjinnan.restaurant.dao.OrderDetailDao;
import com.java2007.zhangjinnan.restaurant.factory.BeanFactory;
import com.java2007.zhangjinnan.restaurant.pojo.OrderDetail;
import com.java2007.zhangjinnan.restaurant.service.OrderDetailService;
import com.java2007.zhangjinnan.restaurant.utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {
    private OrderDetailDao orderDetailDao =
            (OrderDetailDao) BeanFactory.getBean(DaoConstant.ORDER_DETAIL);

    @Override
    public int save(OrderDetail orderDetail) {
        try {
            JdbcUtil.begin();
            orderDetailDao.save(orderDetail);
            JdbcUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return 0;
        }
        return 1;
    }

    @Override
    public List<OrderDetail> findByOrderId(Long orderId) throws SQLException {
        return orderDetailDao.findByOrderId(orderId);
    }
}
