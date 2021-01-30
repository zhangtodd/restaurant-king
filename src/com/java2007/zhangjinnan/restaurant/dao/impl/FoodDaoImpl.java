package com.java2007.zhangjinnan.restaurant.dao.impl;

import com.java2007.zhangjinnan.restaurant.dao.FoodDao;
import com.java2007.zhangjinnan.restaurant.pojo.Food;
import com.java2007.zhangjinnan.restaurant.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    String sqlFile = " id , name , food_type_id foodTypeId , food_type_name foodTypeName , price , " +
            "member_price memberPrice , image , description ";

    @Override
    public List<Food> findAll() throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT " + sqlFile + " FROM food";
        return runner.query(sql, new BeanListHandler<>(Food.class));
    }

    @Override
    public List<Food> findByName(String foodName) throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT " + sqlFile + " FROM food WHERE name LIKE ?";
        foodName = "%" + foodName + "%";
        return runner.query(sql, new BeanListHandler<>(Food.class), foodName);
    }

    @Override
    public Food findById(Integer id) throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT " + sqlFile + "FROM food WHERE id = ?";
        return runner.query(sql, new BeanHandler<>(Food.class), id);
    }

    @Override
    public int save(Food food) throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "INSERT INTO food (name,create_time,update_time,food_type_id,food_type_name,price,member_price," +
                "image,description) VALUES (?,NOW(),NOW(),?,?,?,?,?,?)";
        return runner.update(JdbcUtil.getConnection(), sql, food.getName(), food.getFoodTypeId(), food.getFoodTypeName(),
                food.getPrice(), food.getMemberPrice(), food.getImage(), food.getDescription());
    }

    @Override
    public int update(Food food) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "UPDATE food SET name = ?, food_type_id = ?,food_type_name = ?,price = ?,member_price = ?," +
                "image = ?,description = ?,update_time = NOW() WHERE id = ?";
        return runner.update(JdbcUtil.getConnection(), sql, food.getName(), food.getFoodTypeId(), food.getFoodTypeName(),
                food.getPrice(), food.getMemberPrice(), food.getImage(), food.getDescription(), food.getId());
    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "DELETE FROM food WHERE id = ?";
        return runner.update(JdbcUtil.getConnection(), sql, id);
    }

    @Override
    public List<Food> findByPage() {
        return null;
    }
}
