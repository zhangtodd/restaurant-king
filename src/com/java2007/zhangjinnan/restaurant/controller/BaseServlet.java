package com.java2007.zhangjinnan.restaurant.controller;

import com.alibaba.druid.util.StringUtils;
import com.java2007.zhangjinnan.restaurant.constant.ServletConstant;
import com.java2007.zhangjinnan.restaurant.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        try {
            String methodStr = request.getParameter(ServletConstant.METHOD);
            if (StringUtils.isEmpty(methodStr)) methodStr = "search";
            Method method = this.getClass().getMethod(methodStr, HttpServletRequest.class, HttpServletResponse.class);

            Object object = method.invoke(this, request, response);
            JsonUtil.returnObjectJson(request, response, object);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write(ServletConstant.COMMON_ERROR_MESSAGE);
        }

    }
}
