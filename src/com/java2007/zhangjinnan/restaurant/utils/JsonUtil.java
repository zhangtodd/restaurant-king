package com.java2007.zhangjinnan.restaurant.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonUtil {
    public static void returnObjectJson(HttpServletRequest request, HttpServletResponse response, Object object)
            throws IOException {
        PrintWriter writer = response.getWriter();
        String json = JSON.toJSONString(object);
        writer.write(json);
    }
}
