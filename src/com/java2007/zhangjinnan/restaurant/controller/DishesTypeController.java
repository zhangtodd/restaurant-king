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

    public String search(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //TODO HttpServletRequest和HttpServletResponse详细定义
        //TODO GET/POST? postman 数据传输方式? 获取字符方式

        String keyword = request.getParameter("keyword");
        List<DishesType> types = dishesTypeService.findByTypeName(keyword);
        request.setAttribute("types", types);
        request.setAttribute("keyword", keyword);
        return "forward:/backend/dishes-type.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        dishesTypeService.deleteByTypeId(id);
        return "redirect:/dishes-type?method=search";
    }

    public String findById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        DishesType dishesType = dishesTypeService.findByTypeId(id);
        request.setAttribute("type", dishesType);
        return "forward:/backend/detail/dishes-type/dishes-type-update.jsp";
    }

    public String save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        dishesTypeService.save(new DishesType(request.getParameter("dishes-type-name")));
        return "redirect:/dishes-type?method=search";
    }

    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //TODO request.getParameterMap()?
        Map<String, String[]> parameterMap = request.getParameterMap();
        DishesType dishesType = new DishesType();

        BeanUtils.populate(dishesType, parameterMap);
        dishesTypeService.update(dishesType);
        return "redirect:/dishes-type?method=search";

    }

}
