package com.java2007.zhangjinnan.restaurant.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.java2007.zhangjinnan.restaurant.constant.DaoConstant;
import com.java2007.zhangjinnan.restaurant.dao.DiningTableDao;
import com.java2007.zhangjinnan.restaurant.factory.BeanFactory;
import com.java2007.zhangjinnan.restaurant.pojo.DiningTable;
import com.java2007.zhangjinnan.restaurant.service.DiningTableService;
import com.java2007.zhangjinnan.restaurant.utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

public class DiningTableServiceImpl implements DiningTableService {
    private DiningTableDao diningTableDao =
            (DiningTableDao) BeanFactory.getBean(DaoConstant.DiningTable);

    @Override
    public List<DiningTable> findAll() throws SQLException {
        return diningTableDao.findAll();
    }

    @Override
    public List<DiningTable> findByName(String keyword) throws SQLException {
        return diningTableDao.findByName
                (StringUtils.isEmpty(keyword) ? "" : keyword.trim());
    }

    @Override
    public int save(DiningTable diningTable) throws SQLException {
        try {
            JdbcUtil.begin();
            diningTableDao.save(diningTable);
            JdbcUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return 0;
        }
        return 1;
    }

    @Override
    public int update(DiningTable diningTable, Integer bookStatus) throws SQLException {
        try {
            JdbcUtil.begin();
            diningTableDao.update(diningTable, bookStatus);
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
            diningTableDao.deleteById(id);
            JdbcUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return 0;
        }
        return 1;
    }
}
