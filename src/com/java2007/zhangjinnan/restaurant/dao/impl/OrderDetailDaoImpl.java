package com.java2007.zhangjinnan.restaurant.dao.impl;

import com.java2007.zhangjinnan.restaurant.dao.OrderDetailDao;
import com.java2007.zhangjinnan.restaurant.pojo.OrderDetail;
import com.java2007.zhangjinnan.restaurant.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailDaoImpl implements OrderDetailDao {
    @Override
    public int save(OrderDetail orderDetail) throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "INSERT INTO order_detail (order_id,food_id,price,number,amount)" +
                " VALUES (?,?,?,?,?)";
        return runner.update(JdbcUtil.getConnection(), sql,
                orderDetail.getOrderId(), orderDetail.getFoodId(), orderDetail.getPrice(),
                orderDetail.getNumber(), orderDetail.getAmount());
    }

    @Override
    public List<OrderDetail> findByOrderId(Long orderId) throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT id,order_id orderId,food_id foodId,price,number,amount " +
                "FROM order_detail WHERE order_id = ? ";
        return runner.query(sql, new BeanListHandler<>(OrderDetail.class), orderId);
    }
}
