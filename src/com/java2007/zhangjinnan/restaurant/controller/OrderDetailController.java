package com.java2007.zhangjinnan.restaurant.controller;

import com.alibaba.fastjson.JSONObject;
import com.java2007.zhangjinnan.restaurant.constant.ServiceConstant;
import com.java2007.zhangjinnan.restaurant.factory.BeanFactory;
import com.java2007.zhangjinnan.restaurant.pojo.OrderDetail;
import com.java2007.zhangjinnan.restaurant.service.OrderDetailService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/order-detail")
public class OrderDetailController extends BaseServlet {
    private OrderDetailService orderDetailService =
            (OrderDetailService) BeanFactory.getBean(ServiceConstant.ORDER_DETAIL);

    public List<OrderDetail> getAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Long orderId = Long.valueOf(request.getParameter("order-id"));
        return orderDetailService.findByOrderId(orderId);
    }

    public int saveOrderList(HttpServletRequest request, HttpServletResponse response) {
        Long orderId = System.currentTimeMillis();


        String orderDetailList = request.getParameter("order-detail-list");
        List<OrderDetail> orderDetails = JSONObject.parseArray(orderDetailList, OrderDetail.class);


        return 0;
    }
}
