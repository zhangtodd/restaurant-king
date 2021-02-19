package com.java2007.zhangjinnan.restaurant.controller;

import com.alibaba.druid.util.StringUtils;
import com.java2007.zhangjinnan.restaurant.constant.ServiceConstant;
import com.java2007.zhangjinnan.restaurant.factory.BeanFactory;
import com.java2007.zhangjinnan.restaurant.pojo.Food;
import com.java2007.zhangjinnan.restaurant.service.FoodService;
import com.java2007.zhangjinnan.restaurant.utils.FileUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@WebServlet("/food")
@MultipartConfig
public class FoodController extends BaseServlet {
    private FoodService foodService =
            (FoodService) BeanFactory.getBean(ServiceConstant.FOOD);

    public List<Food> search(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String keyword = request.getParameter("keyword");
        return foodService.findByName(keyword);
    }

    public List<Food> findByTypeId(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer typeId = Integer.valueOf(request.getParameter("typeId"));
        //typeId == 0 select all
        return foodService.findByTypeId(typeId);
    }

    public List<Food> delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        foodService.deleteById(id);
        return foodService.findByName("");
    }

    public List<Food> save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Food food = new Food();
        BeanUtils.populate(food, request.getParameterMap());
        String imgStr = food.getImage();
        if (!StringUtils.isEmpty(imgStr)) {
            imgStr = imgStr.substring(1, imgStr.length() - 1);
        }
        food.setImage(imgStr);

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

    public String saveImage(HttpServletRequest request, HttpServletResponse response) {
        String fileName = FileUtil.upload(request);
        if (StringUtils.isEmpty(fileName)) {
            //文件上传错误
            return "文件上传错误";
        }
        String imageUrl = "/files/" + fileName;
        System.out.println();
        return imageUrl;
    }

}