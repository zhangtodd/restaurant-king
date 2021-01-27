package com.java2007.zhangjinnan.restaurant.controller;

import com.java2007.zhangjinnan.restaurant.constant.ServletConstant;

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

        //TODO 接受请求后自动调用service?
        //TODO tomcat war explore
        //TODO service deGet doPost区别

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        try {
            String methodStr = request.getParameter(ServletConstant.METHOD);

            Method method = this.getClass()
                    .getMethod(methodStr, HttpServletRequest.class, HttpServletResponse.class);
            Object object = method.invoke(this, request, response);

            // object != null repeat function with instanceof
            if (object instanceof String) {
                String result = (String) object;

                if (result.startsWith(ServletConstant.PRE_FORWARD)) {
                    String url = result.split(":")[1];
                    request.getRequestDispatcher(url).forward(request, response);
                } else if (result.startsWith(ServletConstant.PRE_REDIRECT)) {
                    String url = result.split(":")[1];
                    response.sendRedirect(request.getContextPath() + url);
                } else {
                    response.getWriter().write(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write(ServletConstant.COMMON_ERROR_MESSAGE);
        }

        super.service(req, res);
    }
}
