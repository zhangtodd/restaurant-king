package com.java2007.zhangjinnan.restaurant.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;

/**
 * 文件工具类
 *
 * @author ghy
 * @version 1.0
 * @date 2021-01-25
 */
public class FileUtil {

    /**
     * 上传文件
     *
     * @param request
     * @throws Exception
     */
    public static String upload(HttpServletRequest request) {
        //文件上传
        try {
            Part part = request.getPart("image");
            String filename = part.getSubmittedFileName();
            String suffixName = filename.substring(filename.lastIndexOf(".")); //.jpg

            //获取files目录在服务器中的真实路径【某个具体路径下的目录】
//            String imagePath = request.getSession().getServletContext().getRealPath("/files/");
            String imagePath = "F:\\restaurant-king\\web\\files";

            String fileName = UUIDUtil.getFileName(suffixName);   //uuid.jpg
            File file = new File(imagePath, fileName);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            part.write(file.getPath());
            System.out.println(fileName);
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
