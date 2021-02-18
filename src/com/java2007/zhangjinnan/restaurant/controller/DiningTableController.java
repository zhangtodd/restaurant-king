package com.java2007.zhangjinnan.restaurant.controller;

import com.java2007.zhangjinnan.restaurant.constant.ServiceConstant;
import com.java2007.zhangjinnan.restaurant.factory.BeanFactory;
import com.java2007.zhangjinnan.restaurant.pojo.DiningTable;
import com.java2007.zhangjinnan.restaurant.service.DiningTableService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@WebServlet("/dining-table")
public class DiningTableController extends BaseServlet {
    private DiningTableService diningTableService =
            (DiningTableService) BeanFactory.getBean(ServiceConstant.DINING_TABLE);

    public List<DiningTable> search(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String keyword = request.getParameter("keyword");
        return diningTableService.findByName(keyword);
    }

    public List<DiningTable> delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        diningTableService.deleteById(id);
        return diningTableService.findByName("");
    }

    public List<DiningTable> save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> parameterMap = request.getParameterMap();
        DiningTable diningTable = new DiningTable();
        BeanUtils.populate(diningTable, request.getParameterMap());

        diningTableService.save(diningTable);
        return diningTableService.findByName("");
    }

    public List<DiningTable> update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> parameterMap = request.getParameterMap();
        DiningTable diningTable = new DiningTable();
        BeanUtils.populate(diningTable, parameterMap);

        diningTableService.update(diningTable, diningTable.getIsBooking());
        return diningTableService.findByName("");
    }

    public List<DiningTable> payBill(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer diningTableId = Integer.valueOf(request.getParameter("dining_table_id"));
        Long orderId = Long.valueOf(request.getParameter("order_id"));
        Integer payStatus = Integer.valueOf(request.getParameter("pay_status"));
        diningTableService.payBill(diningTableId, orderId, payStatus);
        return diningTableService.findByName("");
    }

}
