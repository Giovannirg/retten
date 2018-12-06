package com.example.retten.retten.database;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Product{

    public String uid;
    public String productname;
    public String productcategory;
    public double price;

    public Product() {
        // Default constructor required for calls to DataSnapshot.getValue(Comment.class)
    }

    public Product(String uid, String productname, String productcategory, double price) {
        this.uid = uid;
        this.productname = productname;
        this.productcategory = productcategory;
        this.price = price;
    }
}
