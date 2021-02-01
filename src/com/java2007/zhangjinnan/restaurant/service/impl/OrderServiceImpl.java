package com.java2007.zhangjinnan.restaurant.service.impl;

import com.java2007.zhangjinnan.restaurant.constant.DaoConstant;
import com.java2007.zhangjinnan.restaurant.dao.OrderDao;
import com.java2007.zhangjinnan.restaurant.factory.BeanFactory;
import com.java2007.zhangjinnan.restaurant.pojo.Order;
import com.java2007.zhangjinnan.restaurant.service.OrderService;
import com.java2007.zhangjinnan.restaurant.utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao =
            (OrderDao) BeanFactory.getBean(DaoConstant.ORDER);

    @Override
    public int save(Order order) throws SQLException {
        try {
            JdbcUtil.begin();
            orderDao.save(order);
            JdbcUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return 0;
        }
        return 1;
    }

    @Override
    public int updateOrderStatus(Long orderId) throws SQLException {
        try {
            JdbcUtil.begin();
            orderDao.updateOrderStatus(orderId);
            JdbcUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return 0;
        }
        return 1;
    }

    @Override
    public List<Order> findAll() throws SQLException {
        return orderDao.findAll();
    }

    @Override
    public List<Order> findByMemberId(int memberId) throws SQLException {
        return orderDao.findByMemberId(memberId);
    }
}
