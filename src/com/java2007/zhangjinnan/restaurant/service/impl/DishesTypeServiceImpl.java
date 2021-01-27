package com.java2007.zhangjinnan.restaurant.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.java2007.zhangjinnan.restaurant.constant.DaoConstant;
import com.java2007.zhangjinnan.restaurant.dao.DishesTypeDao;
import com.java2007.zhangjinnan.restaurant.factory.BeanFactory;
import com.java2007.zhangjinnan.restaurant.pojo.DishesType;
import com.java2007.zhangjinnan.restaurant.service.DishesTypeService;
import com.java2007.zhangjinnan.restaurant.utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

public class DishesTypeServiceImpl implements DishesTypeService {

    private DishesTypeDao dishesTypeDao =
            (DishesTypeDao) BeanFactory.getBean(DaoConstant.DISHES_TYPE);

    @Override
    public List<DishesType> findAll() throws SQLException {
        return dishesTypeDao.findAll();
    }

    @Override
    public List<DishesType> findByTypeName(String typeName) throws SQLException {
        return dishesTypeDao.findByTypeName
                (StringUtils.isEmpty(typeName) ? "" : typeName.trim());
    }

    @Override
    public DishesType findByTypeId(Integer typeId) throws SQLException {
        return dishesTypeDao.findByTypeId(typeId);
    }

    @Override
    public int save(DishesType dishesType) throws SQLException {
        try {
            JdbcUtil.begin();
            dishesTypeDao.save(dishesType);
            JdbcUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return 0;
        }
        return 1;
    }

    @Override
    public int update(DishesType dishesType) throws SQLException {
        try {
            JdbcUtil.begin();
            dishesTypeDao.update(dishesType);
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
            dishesTypeDao.deleteByTypeId(typeId);
            JdbcUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return 0;
        }
        return 1;
    }
}
