package com.java2007.zhangjinnan.restaurant.service;

import java.sql.SQLException;

public interface MemberService {
    int findByName(String name, String password, String role) throws SQLException;
}
