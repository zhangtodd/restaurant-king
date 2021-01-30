package com.java2007.zhangjinnan.restaurant.service.impl;

import com.java2007.zhangjinnan.restaurant.pojo.DiningTable;
import com.java2007.zhangjinnan.restaurant.service.DiningTableService;

import java.sql.SQLException;
import java.util.List;

public class DiningTableServiceImpl implements DiningTableService {
    @Override
    public List<DiningTable> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<DiningTable> findByName(String keyword) throws SQLException {
        return null;
    }

    @Override
    public int save(DiningTable diningTable) throws SQLException {
        return 0;
    }

    @Override
    public int update(DiningTable diningTable, Integer bookStatus) throws SQLException {
        return 0;
    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        return 0;
    }
}
