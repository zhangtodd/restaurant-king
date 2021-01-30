package com.java2007.zhangjinnan.restaurant.pojo;

import java.util.Date;

public class DiningTable extends BaseClass {
    private String name;
    private Integer isBooking;
    private Date bookingTime;
    private Integer memberId;

    public DiningTable() {
    }

    public DiningTable(Integer id, Date createTime, Date updateTime, String name, Integer isBooking, Date bookingTime,
                       Integer memberId) {
        super(id, createTime, updateTime);
        this.name = name;
        this.isBooking = isBooking;
        this.bookingTime = bookingTime;
        this.memberId = memberId;
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
                "name='" + name + '\'' +
                ", isBooking=" + isBooking +
                ", bookingTime=" + bookingTime +
                ", memberId=" + memberId +
                '}';
    }
}
