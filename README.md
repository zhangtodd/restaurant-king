# 餐馆王 Restaurant King

## 简介

- Java Web项目，使用Servlet+Tomcat+JSP
- 数据库 MySQL，所有表格未加外键、拥有id，create_time，update_time字段
- web文件夹下 backend 后台页面 front 前台页面

## 表结构

|  表名         | 含义 |
|  ----         | ---- |
| dining_table  | 餐桌表，可以预定/退订 |
| dishes_type   | 菜系表 |
| dishes        | 菜品表 |
| member        | 用户表，role字段区分管理员和用户 |
| order         | 订单表 |
| oeder_detail  | 订单单项详情表 |
