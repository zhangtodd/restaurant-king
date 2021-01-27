package com.java2007.zhangjinnan.restaurant.dao.impl;

import com.java2007.zhangjinnan.restaurant.dao.DishesTypeDao;
import com.java2007.zhangjinnan.restaurant.pojo.DishesType;
import com.java2007.zhangjinnan.restaurant.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class DishesTypeDaoImpl implements DishesTypeDao {
    @Override
    public List<DishesType> findAll() throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT id , name FROM dishes_type";
        return runner.query(sql, new BeanListHandler<>(DishesType.class));
    }

    @Override
    public List<DishesType> findByTypeName(String typeName) throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT id, name FROM dishes_type WHERE name LIKE ?";
        typeName = '%' + typeName + '%';
        return runner.query(sql, new BeanListHandler<>(DishesType.class), typeName);
    }

    @Override
    public DishesType findByTypeId(Integer typeId) throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT id , name FROM dishes_type WHERE id = ?";
        return runner.query(sql, new BeanHandler<>(DishesType.class), typeId);
    }

    @Override
    public int save(DishesType dishesType) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "INSERT INTO dishes_type (name,create_time,update_time) VALUES (?,NOW(),NOW())";
        return runner.update(JdbcUtil.getConnection(), sql, dishesType.getName());
    }

    @Override
    public int update(DishesType dishesType) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "UPDATE dishes_type SET name = ? , update_time = NOW()  WHERE id = ?";
        return runner.update(JdbcUtil.getConnection(), sql, dishesType.getName(), dishesType.getId());
    }

    @Override
    public int deleteByTypeId(Integer typeId) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "DELETE FROM dishes_type WHERE id = ?";
        return runner.update(JdbcUtil.getConnection(), sql, typeId);
    }
}
