package com.java2007.zhangjinnan.restaurant.pojo;

import java.util.Date;

public class DiningTable extends BaseClass {
    private String name;
    private Boolean isBooking;
    private Date bookingTime;
    private Integer memberId;

    public DiningTable() {
    }

    public DiningTable(String name, Boolean isBooking, Date bookingTime, Integer memberId) {
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

    public Boolean getBooking() {
        return isBooking;
    }

    public void setBooking(Boolean booking) {
        isBooking = booking;
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
}
