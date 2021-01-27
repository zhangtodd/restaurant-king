package com.java2007.zhangjinnan.restaurant.factory;

public class BeanFactory {

    public static Object getBean(String className) {
        try {
            return Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
