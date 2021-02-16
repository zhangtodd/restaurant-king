package com.java2007.zhangjinnan.restaurant.dao.impl;

import com.java2007.zhangjinnan.restaurant.dao.MemberDao;
import com.java2007.zhangjinnan.restaurant.pojo.Member;
import com.java2007.zhangjinnan.restaurant.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class MemberDaoImpl implements MemberDao {
    @Override
    public Member findByName(String name, String role) throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT id ,name, password , role FROM member_list where name = ? and role = ?";
        return runner.query(sql, new BeanHandler<>(Member.class), name, role);
    }
}
