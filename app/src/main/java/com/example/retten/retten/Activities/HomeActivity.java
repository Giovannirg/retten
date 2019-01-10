package com.example.retten.retten.Activities;


import com.example.retten.retten.database.DataHolder;
import com.example.retten.retten.model.Supermarkt;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.example.retten.retten.database.Product;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toolbar;

import com.example.retten.retten.R;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {

      //  private DatabaseReference mDatabase;





        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);






                findViewById(R.id.Icon_Produkten).setVisibility(View.VISIBLE);
                findViewById(R.id.Icon_Maerten).setVisibility(View.VISIBLE);
                findViewById(R.id.text_Icon_Produkten).setVisibility(View.VISIBLE);
                findViewById(R.id.text_Icon_Maerten).setVisibility(View.VISIBLE);

                ImageView produkten =findViewById(R.id.Icon_Produkten);

                produkten.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(view.getContext(),search.class);
                        startActivity(intent);
                    }
                });
                ImageView Maerten =findViewById(R.id.Icon_Maerten);
                Maerten.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(view.getContext(),search.class);
                        startActivity(intent);
                    }
                });

            //}

        }



            }
