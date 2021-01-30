package com.java2007.zhangjinnan.restaurant.controller;

import com.java2007.zhangjinnan.restaurant.constant.ServiceConstant;
import com.java2007.zhangjinnan.restaurant.factory.BeanFactory;
import com.java2007.zhangjinnan.restaurant.pojo.Food;
import com.java2007.zhangjinnan.restaurant.service.FoodService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@WebServlet("/food")
public class FoodController extends BaseServlet {
    private FoodService foodService =
            (FoodService) BeanFactory.getBean(ServiceConstant.FOOD);

    public List<Food> search(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String keyword = request.getParameter("keyword");
        List<Food> foods = foodService.findByName(keyword);
        return foods;
    }

    public int delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        return foodService.deleteById(id);
    }

    public List<Food> save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Food food = new Food();
        BeanUtils.populate(food, request.getParameterMap());

        foodService.save(food);
        return foodService.findByName("");
    }

    public List<Food> update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Food food = new Food();
        BeanUtils.populate(food, parameterMap);

        foodService.update(food);
        return foodService.findByName("");
    }


}
