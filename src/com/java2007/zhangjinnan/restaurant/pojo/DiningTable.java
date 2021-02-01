package com.java2007.zhangjinnan.restaurant.pojo;

import java.util.Date;

public class DiningTable {
    private Integer id;
    private Date createTime;
    private Date updateTime;

    private String name;
    private Integer isBooking;
    private Date bookingTime;
    private Integer memberId;

    public DiningTable() {
    }

    public DiningTable(String name, Integer isBooking, Date bookingTime, Integer memberId) {
        this.name = name;
        this.isBooking = isBooking;
        this.bookingTime = bookingTime;
        this.memberId = memberId;
    }

    public DiningTable(Integer id, Date createTime, Date updateTime, String name, Integer isBooking, Date bookingTime,
                       Integer memberId) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.name = name;
        this.isBooking = isBooking;
        this.bookingTime = bookingTime;
        this.memberId = memberId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsBooking() {
        return isBooking;
    }

    public void setIsBooking(Integer isBooking) {
        this.isBooking = isBooking;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "DiningTable{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", name='" + name + '\'' +
                ", isBooking=" + isBooking +
                ", bookingTime=" + bookingTime +
                ", memberId=" + memberId +
                '}';
    }
}
