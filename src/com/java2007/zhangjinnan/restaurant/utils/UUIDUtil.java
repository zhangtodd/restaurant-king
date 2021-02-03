package com.java2007.zhangjinnan.restaurant.utils;

import java.util.UUID;

/**
 * @author ghy
 * @version 1.0
 * @date 2021-01-22
 */
public class UUIDUtil {

    public static String getFileName(String suffixName){
        // c:\a\b\c\files\aldsofsjn6554312wer.jpg
        return UUID.randomUUID().toString().replaceAll("-","") + suffixName;
    }

}
