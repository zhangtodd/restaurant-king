package com.java2007.zhangjinnan.restaurant.controller;

import com.java2007.zhangjinnan.restaurant.constant.ServiceConstant;
import com.java2007.zhangjinnan.restaurant.factory.BeanFactory;
import com.java2007.zhangjinnan.restaurant.pojo.DishesType;
import com.java2007.zhangjinnan.restaurant.service.DishesTypeService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@WebServlet("/dishes-type")
public class DishesTypeController extends BaseServlet {
    private DishesTypeService dishesTypeService =
            (DishesTypeService) BeanFactory.getBean(ServiceConstant.DISHES_TYPE);

    public List<DishesType> search(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String keyword = request.getParameter("keyword");
        List<DishesType> types = dishesTypeService.findByTypeName(keyword);
        return types;
    }

    public int delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        return dishesTypeService.deleteByTypeId(id);
    }

    public DishesType findById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        DishesType dishesType = dishesTypeService.findByTypeId(id);
        request.setAttribute("type", dishesType);
        return dishesType;
    }

    public int save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return dishesTypeService.save
                (new DishesType(request.getParameter("name").trim()));
    }

    public int update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> parameterMap = request.getParameterMap();
        DishesType dishesType = new DishesType();

        BeanUtils.populate(dishesType, parameterMap);
        return dishesTypeService.update(dishesType);
    }

}
