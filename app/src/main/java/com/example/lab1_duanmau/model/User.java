package com.example.lab1_duanmau.model;

public class User {
    private String userName;
    private String password;
    private String phone;
    private String hoTen;

    public User() {
    }

    public User(String userName, String password, String phone, String hoTen) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.hoTen = hoTen;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    @Override
    public String toString() {
        return "Người dùng{ \nUserName: " + userName + "\nPassword: " + password + "\nPhone: " + phone + "\nHoTen: " + hoTen + "\n}";
    }
}
