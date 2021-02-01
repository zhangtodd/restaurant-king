package com.java2007.zhangjinnan.restaurant.controller;

import com.java2007.zhangjinnan.restaurant.constant.ServiceConstant;
import com.java2007.zhangjinnan.restaurant.factory.BeanFactory;
import com.java2007.zhangjinnan.restaurant.pojo.Order;
import com.java2007.zhangjinnan.restaurant.service.OrderService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/order")
public class OrderController extends BaseServlet {
    private OrderService orderService =
            (OrderService) BeanFactory.getBean(ServiceConstant.ORDER);

    public List<Order> getAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        return orderService.findAll();
    }

    public List<Order> pay(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int orderId = Integer.parseInt(request.getParameter("order_id"));
        orderService.updateOrderStatus(orderId);
        return orderService.findAll();
    }

}
