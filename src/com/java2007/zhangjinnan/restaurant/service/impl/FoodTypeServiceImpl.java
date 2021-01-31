package com.java2007.zhangjinnan.restaurant.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.java2007.zhangjinnan.restaurant.constant.DaoConstant;
import com.java2007.zhangjinnan.restaurant.dao.FoodTypeDao;
import com.java2007.zhangjinnan.restaurant.factory.BeanFactory;
import com.java2007.zhangjinnan.restaurant.pojo.FoodType;
import com.java2007.zhangjinnan.restaurant.service.FoodTypeService;
import com.java2007.zhangjinnan.restaurant.utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

public class FoodTypeServiceImpl implements FoodTypeService {

    private FoodTypeDao foodTypeDao =
            (FoodTypeDao) BeanFactory.getBean(DaoConstant.FOOD_TYPE);

    @Override
    public List<FoodType> findAll() throws SQLException {
        return foodTypeDao.findAll();
    }

    @Override
    public List<FoodType> findByTypeName(String keyword) throws SQLException {
        return foodTypeDao.findByTypeName
                (StringUtils.isEmpty(keyword) ? "" : keyword.trim());
    }

    @Override
    public FoodType findByTypeId(Integer typeId) throws SQLException {
        return foodTypeDao.findByTypeId(typeId);
    }

    @Override
    public int save(FoodType foodType) throws SQLException {
        try {
            JdbcUtil.begin();
            foodTypeDao.save(foodType);
            JdbcUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return 0;
        }
        return 1;
    }

    @Override
    public int update(FoodType foodType) throws SQLException {
        try {
            JdbcUtil.begin();
            foodTypeDao.update(foodType);
            JdbcUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return 0;
        }
        return 1;
    }

    @Override
    public int deleteByTypeId(Integer typeId) throws SQLException {
        try {
            JdbcUtil.begin();
            foodTypeDao.deleteByTypeId(typeId);
            JdbcUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return 0;
        }
        return 1;
    }
}
