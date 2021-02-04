package com.java2007.zhangjinnan.restaurant.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.java2007.zhangjinnan.restaurant.constant.DaoConstant;
import com.java2007.zhangjinnan.restaurant.dao.FoodDao;
import com.java2007.zhangjinnan.restaurant.factory.BeanFactory;
import com.java2007.zhangjinnan.restaurant.pojo.Food;
import com.java2007.zhangjinnan.restaurant.service.FoodService;
import com.java2007.zhangjinnan.restaurant.utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

public class FoodServiceImpl implements FoodService {

    private FoodDao foodDao =
            (FoodDao) BeanFactory.getBean(DaoConstant.FOOD);

    @Override
    public List<Food> findAll() throws SQLException {
        return foodDao.findAll();
    }

    @Override
    public List<Food> findByName(String name) throws SQLException {
        return foodDao.findByName
                (StringUtils.isEmpty(name) ? "" : name.trim());
    }

    @Override
    public Food findById(Integer id) throws SQLException {
        return foodDao.findById(id);
    }

    @Override
    public List<Food> findByTypeId(Integer typeId) throws SQLException {
        return foodDao.findByTypeId(typeId);
    }

    @Override
    public int save(Food food) throws SQLException {
        try {
            JdbcUtil.begin();
            foodDao.save(food);
            JdbcUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return 0;
        }
        return 1;
    }

    @Override
    public int update(Food food) throws SQLException {
        try {
            JdbcUtil.begin();
            foodDao.update(food);
            JdbcUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return 0;
        }
        return 1;
    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        try {
            JdbcUtil.begin();
            foodDao.deleteById(id);
            JdbcUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return 0;
        }
        return 1;
    }
}
