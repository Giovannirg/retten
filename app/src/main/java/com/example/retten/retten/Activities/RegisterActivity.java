package com.example.retten.retten.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

import org.w3c.dom.Text;

import static android.widget.Toast.LENGTH_SHORT;

public class RegisterActivity extends AppCompatActivity {

    ImageView ImgUserPhoto;
             static int PreqCode = 1;
    static int REQUESTCODE = 1;
    Uri pickedImgUri;

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

        Intent galleryIntent =  new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, REQUESTCODE);


    }

    private void checkAndRequestForPermission() {

        if (ContextCompat.checkSelfPermission ( RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(  RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE )){

                Toast.makeText( RegisterActivity.this,  "Please Accept Requested Permission", Toast.LENGTH_SHORT).show();

            }
            else
            {

                ActivityCompat.requestPermissions( RegisterActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    PreqCode);

            }

            {openGallery();}
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode ==REQUESTCODE && data != null)
            // Bild erfolgreich ausgewählt, Referenz soll gespeichert werden
            pickedImgUri = data.getData();
            ImgUserPhoto.setImageURI(pickedImgUri);

    }
}
