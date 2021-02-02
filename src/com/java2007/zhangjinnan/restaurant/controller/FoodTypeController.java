package com.java2007.zhangjinnan.restaurant.controller;

import com.java2007.zhangjinnan.restaurant.constant.ServiceConstant;
import com.java2007.zhangjinnan.restaurant.factory.BeanFactory;
import com.java2007.zhangjinnan.restaurant.pojo.FoodType;
import com.java2007.zhangjinnan.restaurant.service.FoodTypeService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@WebServlet("/food-type")
public class FoodTypeController extends BaseServlet {
    private FoodTypeService foodTypeService =
            (FoodTypeService) BeanFactory.getBean(ServiceConstant.FOOD_TYPE);

    public List<FoodType> search(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String keyword = request.getParameter("keyword");
        List<FoodType> types = foodTypeService.findByTypeName(keyword);
        return types;
    }

    public List<FoodType> delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        foodTypeService.deleteByTypeId(id);
        return foodTypeService.findByTypeName("");
    }

    public FoodType findById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        return foodTypeService.findByTypeId(id);
    }

    public List<FoodType> save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        foodTypeService.save(new FoodType(request.getParameter("name").trim()));
        return foodTypeService.findByTypeName("");
    }

    public List<FoodType> update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> parameterMap = request.getParameterMap();
        FoodType foodType = new FoodType();
        BeanUtils.populate(foodType, parameterMap);
        System.out.println(foodType);

        foodTypeService.update(foodType);
        return foodTypeService.findByTypeName("");
    }

}
