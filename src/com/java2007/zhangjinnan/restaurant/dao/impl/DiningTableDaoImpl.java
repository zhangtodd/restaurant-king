package com.java2007.zhangjinnan.restaurant.dao.impl;

import com.java2007.zhangjinnan.restaurant.dao.DiningTableDao;
import com.java2007.zhangjinnan.restaurant.pojo.DiningTable;
import com.java2007.zhangjinnan.restaurant.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class DiningTableDaoImpl implements DiningTableDao {
    @Override
    public List<DiningTable> findAll() throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT id , name , is_booking isBooking , booking_time bookingTime FROM dining_table";
        return runner.query(sql, new BeanListHandler<>(DiningTable.class));
    }

    @Override
    public List<DiningTable> findByName(String keyword) throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT id , name , is_booking isBooking , booking_time bookingTime FROM dining_table WHERE name LIKE ?";
        keyword = "%" + keyword + "%";
        return runner.query(sql, new BeanListHandler<>(DiningTable.class), keyword);
    }

    @Override
    public int save(DiningTable diningTable) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "INSERT INTO dining_table (name,create_time,update_time,is_booking) VALUES (?,NOW(),NOW(),0)";
        return runner.update(JdbcUtil.getConnection(), sql, diningTable.getName());
    }

    @Override
    public int update(DiningTable diningTable, Integer bookStatus) throws SQLException {
        QueryRunner runner = new QueryRunner();
        if (bookStatus.equals(0)) {
            String sql = "UPDATE dining_table SET is_booking = 0 , booking_time= null , update_time = NOW() WHERE id = ?";
            return runner.update(JdbcUtil.getConnection(), sql, diningTable.getId());
        } else {
            String sql = "UPDATE dining_table SET is_booking = 1 , booking_time = NOW() , update_time = NOW() WHERE id = ?";
            return runner.update(JdbcUtil.getConnection(), sql, diningTable.getId());
        }

    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "DELETE FROM dining_table WHERE id = ?";
        return runner.update(JdbcUtil.getConnection(), sql, id);
    }
}
