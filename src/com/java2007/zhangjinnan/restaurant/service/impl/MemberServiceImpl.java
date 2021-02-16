package com.java2007.zhangjinnan.restaurant.service.impl;

import com.java2007.zhangjinnan.restaurant.constant.DaoConstant;
import com.java2007.zhangjinnan.restaurant.dao.MemberDao;
import com.java2007.zhangjinnan.restaurant.factory.BeanFactory;
import com.java2007.zhangjinnan.restaurant.pojo.Member;
import com.java2007.zhangjinnan.restaurant.service.MemberService;

import java.sql.SQLException;

public class MemberServiceImpl implements MemberService {
    private MemberDao memberDao =
            (MemberDao) BeanFactory.getBean(DaoConstant.MEMBER);

    @Override
    public int findByName(String name, String password, String role) throws SQLException {
        Member member = memberDao.findByName(name, role);
        if (null != member) {
            String dbPassword = member.getPassword();
            if (null != dbPassword && dbPassword.equals(password)) {
                return member.getId();
            }
        }
        return -1;
    }
}
