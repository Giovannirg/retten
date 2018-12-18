package com.example.retten.retten.database;

import com.example.retten.retten.model.User;

import java.util.List;

public class DataHolder {
    private static final DataHolder holder = new DataHolder();
    public static DataHolder getInstance(){return holder;}
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    List<Product> m_products ;
    public List<Product> getData() {
        return m_products;
    }
    public void setData(List<Product> data) {
        this.m_products = data;
    }

}
