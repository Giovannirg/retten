package com.example.retten.retten.Activities;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.retten.retten.R;
import com.example.retten.retten.database.DataHolder;
import com.example.retten.retten.model.Supermarkt;

public class SupermarktActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supermarkt);



      //  if (DataHolder.getInstance().getUser() instanceof Supermarkt) {

            findViewById(R.id.Icon_Produkt_Liste).setVisibility(View.VISIBLE);
            findViewById(R.id.Icon_Reserviert).setVisibility(View.VISIBLE);
            findViewById(R.id.Icon_VkBestaetigung).setVisibility(View.VISIBLE);
            findViewById(R.id.text_Icon_Produkt_Liste).setVisibility(View.VISIBLE);
            findViewById(R.id.text_Icon_Reserviert).setVisibility(View.VISIBLE);
            findViewById(R.id.text_Icon_VkBestaetigung).setVisibility(View.VISIBLE);


            ImageView produkliste = findViewById(R.id.Icon_Produkt_Liste);
            produkliste.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), seller_page.class);
                    startActivity(intent);
                }
            });
            ImageView res_Produkt = findViewById(R.id.Icon_Reserviert);
            res_Produkt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), search.class);
                    startActivity(intent);
                }
            });

            ImageView Verkaufsbestaetigung = findViewById(R.id.Icon_VkBestaetigung);
            Verkaufsbestaetigung.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), SaleConfirm.class);
                    startActivity(intent);
                }
            });

     //   } else {


            /* ImageView produkten = findViewById(R.id.Icon_Produkten);

            produkten.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), search.class);
                    startActivity(intent);
                }
            });
            ImageView Maerten = findViewById(R.id.Icon_Maerten);
            Maerten.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), search.class);
                    startActivity(intent);
                }
            });*/

     //   }

    }

}