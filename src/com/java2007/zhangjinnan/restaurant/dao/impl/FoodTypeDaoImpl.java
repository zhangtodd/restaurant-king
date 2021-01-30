package com.java2007.zhangjinnan.restaurant.dao.impl;

import com.java2007.zhangjinnan.restaurant.dao.FoodTypeDao;
import com.java2007.zhangjinnan.restaurant.pojo.FoodType;
import com.java2007.zhangjinnan.restaurant.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class FoodTypeDaoImpl implements FoodTypeDao {
    @Override
    public List<FoodType> findAll() throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT id , name FROM food_type";
        return runner.query(sql, new BeanListHandler<>(FoodType.class));
    }

    @Override
    public List<FoodType> findByTypeName(String typeName) throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT id, name FROM food_type WHERE name LIKE ?";
        typeName = "%" + typeName + "%";
        return runner.query(sql, new BeanListHandler<>(FoodType.class), typeName);
    }

    @Override
    public FoodType findByTypeId(Integer typeId) throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT id , name FROM food_type WHERE id = ?";
        return runner.query(sql, new BeanHandler<>(FoodType.class), typeId);
    }

    @Override
    public int save(FoodType foodType) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "INSERT INTO food_type (name,create_time,update_time) VALUES (?,NOW(),NOW())";
        return runner.update(JdbcUtil.getConnection(), sql, foodType.getName());
    }

    @Override
    public int update(FoodType foodType) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "UPDATE food_type SET name = ? , update_time = NOW() WHERE id = ?";
        return runner.update(JdbcUtil.getConnection(), sql, foodType.getName(), foodType.getId());
    }

    @Override
    public int deleteByTypeId(Integer typeId) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "DELETE FROM food_type WHERE id = ?";
        return runner.update(JdbcUtil.getConnection(), sql, typeId);
    }
}
