package com.java2007.zhangjinnan.restaurant.pojo;

import java.util.Date;

//base type : all pojo extend this class
public class BaseClass {
    //要订单UUID可以再加一个String字段
    //系统比较小就先不写了
    private Integer id;

    private Date createTime;
    private Date updateTime;

//  private Boolean isDelete;

    public BaseClass() {
    }

    public BaseClass(Integer id, Date createTime, Date updateTime) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
