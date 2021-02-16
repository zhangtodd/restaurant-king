package com.java2007.zhangjinnan.restaurant.dao;

import com.java2007.zhangjinnan.restaurant.pojo.Member;

import java.sql.SQLException;

public interface MemberDao {
    Member findByName(String name, String role) throws SQLException;
}
