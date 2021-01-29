package com.java2007.zhangjinnan.restaurant.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决中文乱码过滤器
 *
 * @author ghy
 * @version 1.0
 * @date 2021-01-22
 */
@WebFilter("/*")
public class CharsetEncodingFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String uri = request.getRequestURI();

        if (uri == null || uri.endsWith(".html") || uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".jpg")
                || uri.contains("backend") || uri.endsWith(".jsp")) {
            chain.doFilter(req, resp);
            return;
        }
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
