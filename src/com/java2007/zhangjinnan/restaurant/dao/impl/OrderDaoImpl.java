package com.java2007.zhangjinnan.restaurant.dao.impl;

import com.java2007.zhangjinnan.restaurant.dao.OrderDao;
import com.java2007.zhangjinnan.restaurant.pojo.Order;
import com.java2007.zhangjinnan.restaurant.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public int save(Order order) throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "INSERT INTO order_list (create_time,update_time,dining_table_id,dining_table_name,member_id " +
                ",member_name, total_amount,is_pay) VALUES (NOW(),NOW(),?,?,?,?,?,0)";
        return runner.update(JdbcUtil.getConnection(), sql, order.getDiningTableId(), order.getDiningTableName(),
                order.getMemberId(), order.getDiningTableName(), order.getTotalAmount());
    }

    @Override
    public int updateOrderStatus(Long orderId) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "UPDATE order_list SET is_pay = 1,update_time = NOW() WHERE id = ?";
        return runner.update(JdbcUtil.getConnection(), sql, orderId);
    }

    @Override
    public List<Order> findAll() throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT id,create_time createTime,update_time updateTime,dining_table_id diningTableId , " +
                "dining_table_name diningTableName,member_id memberId,member_name memberName," +
                "total_amount totalAmount,is_pay isPay FROM order_list";
        return runner.query(sql, new BeanListHandler<>(Order.class));
    }

    @Override
    public List<Order> findByMemberId(int memberId) throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT create_time createTime,update_time updateTime,dining_table_id diningTableId , " +
                "dining_table_name diningTableName,member_id memberId,member_name memberName," +
                "total_amount totalAmount,is_pay isPay FROM order_list WHERE member_id = ?";
        return runner.query(sql, new BeanListHandler<>(Order.class), memberId);
    }
}
