package com.example.retten.retten.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.retten.retten.R;

public class RegisterActivity extends AppCompatActivity {

    ImageView ImgUserPhoto

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //inu Views

        ImgUserPhoto = findViewById(R.id.regUserPhoto);

        ImgUserPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= 22) {

                    checkAndRequestforPermission();
                }

                else
                {
                    openGallery();
                }

            }
        });


    }

    private void openGallery(){
        //TODO: open gallery intent and

    }

    private void checkAndRequestforPermission(){
            if (ContextCompat.checkSelfPermission( context: RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE )
        != PackageManager.PERMISSION_GRANTED){
                if (ActivityCompat.shouldShowRequestPermissionRationale( activity: RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE )){

                Toast.makeText( context: RegisterActivity.this, text: "Please accept for required Permission", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
