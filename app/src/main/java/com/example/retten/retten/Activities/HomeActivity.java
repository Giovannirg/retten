/*package com.example.retten.retten.Activities;


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
import java.util.ArrayList;*/

package com.example.retten.retten.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.retten.retten.R;
import com.example.retten.retten.database.DataHolder;
import com.example.retten.retten.model.Supermarkt;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.CountDownLatch;


public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAuth=FirebaseAuth.getInstance();
        DataHolder.getInstance().getUserData(mAuth.getCurrentUser().getEmail(),"jhghcfgh");
        if (DataHolder.getInstance().getUser() instanceof Supermarkt) {


            Intent inent = new Intent(getApplicationContext(), SupermarktActivity.class);
            startActivity(inent);


        }


         else{


                Intent intent = new Intent(getApplicationContext(), CustomerActivity.class);
                startActivity(intent);
            }




    }
}











