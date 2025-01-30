package com.example.mysecondapplication.Activities;

import java.util.HashMap;

public class User {
    private String username;
    private String password;
    private HashMap<String, DataModel> cart;

    public User() { }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.cart = new HashMap<>();
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public HashMap<String, DataModel> getCart() { return cart; }
}
