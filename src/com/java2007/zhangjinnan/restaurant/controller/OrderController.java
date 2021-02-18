package com.java2007.zhangjinnan.restaurant.controller;

import com.alibaba.fastjson.JSON;
import com.java2007.zhangjinnan.restaurant.constant.ServiceConstant;
import com.java2007.zhangjinnan.restaurant.factory.BeanFactory;
import com.java2007.zhangjinnan.restaurant.pojo.Order;
import com.java2007.zhangjinnan.restaurant.pojo.OrderDetail;
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
        Long orderId = Long.valueOf(request.getParameter("order_id"));
        Integer payStatus = Integer.valueOf(request.getParameter("pay_status"));
        orderService.updateOrderStatus(orderId, payStatus);
        return orderService.findAll();
    }

    public Long saveOrder(HttpServletRequest request, HttpServletResponse response) {
        long orderId = System.currentTimeMillis();

        Order order = new Order();
        order.setId(orderId);
        order.setDiningTableId(Integer.valueOf(request.getParameter("tableId")));
        order.setDiningTableName(request.getParameter("tableName"));
        order.setMemberId(Integer.valueOf(request.getParameter("memberId")));
        order.setMemberName(request.getParameter("memberName"));
        order.setTotalAmount(Integer.valueOf(request.getParameter("totalAmount")));

        String orderListStr = request.getParameter("cart");
        List<OrderDetail> orderDetailList = JSON.parseArray(orderListStr, OrderDetail.class);

        try {
            orderService.saveOrderAndDetail(order, orderDetailList);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
        return orderId;
    }


}
