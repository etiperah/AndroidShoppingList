package com.example.mysecondapplication.models;

public class User {
    private String email;
    private String phone;
    private String password;

    public User(String email, String password){

    }
    public User(String email, String phone, String password) {
        this.email = email;
        this.phone = phone;
        this.phone = password;
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

    public Object getPassword() { return this.password; }
    public void setPassword(String password) {
        this.password = password;
    }
}
