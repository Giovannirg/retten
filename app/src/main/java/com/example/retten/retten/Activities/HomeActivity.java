package com.example.retten.retten.Activities;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.example.retten.retten.database.Product;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.retten.retten.R;



    public class HomeActivity extends AppCompatActivity {

        private DatabaseReference mDatabase;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            mDatabase = FirebaseDatabase.getInstance().getReference();
            addNewProduct("ID1", "product1", "category1", 13.50);
        }


        private void addNewProduct(String productId, String productname, String productcategory, double price) {
            Product product = new Product(productId, productname, productcategory, price );

            mDatabase.child("products").child(productId).setValue(product);

        }
    }
