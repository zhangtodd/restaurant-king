package com.java2007.zhangjinnan.restaurant.pojo;

public class Member extends BaseClass {
    private String name;
    private String password;
    private String email;
    private String phone;

    //role : 'admin'/'member'
    //one member has only one role but different level
    private String role;
    private Integer level;

    public Member() {
    }

    public Member(String name, String password, String email, String phone, String role, Integer level) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
