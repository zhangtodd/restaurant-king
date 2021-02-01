package com.java2007.zhangjinnan.restaurant.controller;

import com.java2007.zhangjinnan.restaurant.constant.ServiceConstant;
import com.java2007.zhangjinnan.restaurant.factory.BeanFactory;
import com.java2007.zhangjinnan.restaurant.pojo.Order;
import com.java2007.zhangjinnan.restaurant.service.OrderDetailService;
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

    private OrderDetailService orderDetailService =
            (OrderDetailService) BeanFactory.getBean(ServiceConstant.ORDER_DETAIL);

    public List<Order> getAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        return orderService.findAll();
    }

    public List<Order> pay(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Long orderId = Long.valueOf(request.getParameter("order_id"));
        orderService.updateOrderStatus(orderId);
        return orderService.findAll();
    }

    public Long saveOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Order order = new Order();
        long orderId = System.currentTimeMillis();
        order.setId(orderId);
        order.setDiningTableId(Integer.valueOf(request.getParameter("dining-table-id")));
        order.setDiningTableName(request.getParameter("dining-table-name"));
        order.setMemberId(Integer.valueOf(request.getParameter("member-id")));
        order.setMemberName(request.getParameter("member-name"));
        order.setTotalAmount(Integer.valueOf(request.getParameter("total-amount")));

        orderService.save(order);
        String orderListStr = request.getParameter("order-list");

        //TODO

        return orderId;
    }


}
