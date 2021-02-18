package com.java2007.zhangjinnan.restaurant.service.impl;

import com.java2007.zhangjinnan.restaurant.constant.DaoConstant;
import com.java2007.zhangjinnan.restaurant.dao.DiningTableDao;
import com.java2007.zhangjinnan.restaurant.dao.OrderDao;
import com.java2007.zhangjinnan.restaurant.dao.OrderDetailDao;
import com.java2007.zhangjinnan.restaurant.factory.BeanFactory;
import com.java2007.zhangjinnan.restaurant.pojo.DiningTable;
import com.java2007.zhangjinnan.restaurant.pojo.Order;
import com.java2007.zhangjinnan.restaurant.pojo.OrderDetail;
import com.java2007.zhangjinnan.restaurant.service.OrderService;
import com.java2007.zhangjinnan.restaurant.utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao =
            (OrderDao) BeanFactory.getBean(DaoConstant.ORDER);

    private OrderDetailDao orderDetailDao =
            (OrderDetailDao) BeanFactory.getBean(DaoConstant.ORDER_DETAIL);

    private DiningTableDao diningTableDao =
            (DiningTableDao) BeanFactory.getBean(DaoConstant.DINING_TABLE);

    public int saveOrderAndDetail(Order order, List<OrderDetail> orderDetailList) {
        try {
            JdbcUtil.begin();
            //保存订单
            orderDao.save(order);
            //修改餐桌状态
            DiningTable diningTable = new DiningTable();
            diningTable.setId(order.getDiningTableId());
            diningTableDao.update(diningTable, 1);
            //保存订单详情
            for (OrderDetail orderDetail : orderDetailList) {
                orderDetail.setOrderId(order.getId());
                orderDetailDao.save(orderDetail);
            }
            JdbcUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return 0;
        }
        return 1;
    }

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
    public int updateOrderStatus(Long orderId, Integer isPay) throws SQLException {
        try {
            JdbcUtil.begin();
            orderDao.updateOrderStatus(orderId, isPay);
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
