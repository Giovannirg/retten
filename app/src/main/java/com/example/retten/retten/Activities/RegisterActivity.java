package com.example.retten.retten.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.retten.retten.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.w3c.dom.Text;

import static android.widget.Toast.LENGTH_SHORT;

public class RegisterActivity extends AppCompatActivity {

    ImageView ImgUserPhoto;
    static int PreqCode = 1;
    static int REQUESTCODE = 1;
    Uri pickedImgUri;

    private EditText userEmail, userPassword, userPassword2, userName;
    private progressBar loadingProgress;
    private button regBtn;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //inu Views
        userEmail = findViewById(R.id.regMail);
        userPassword = findViewById(R.id.regPassword);
        userPassword2 = findViewById(R.id.regPassword2);
        userName = findViewById(R.id.regName);
        loadingProgress = findViewById(R.id.progressBar2);
        regBtn = findViewById(R.id.regBtn);

        loadingProgress.setVisibility(View.INVISIBLE);


        mAuth = FirebaseAuth.getInstance();

        regBtn.setOnClickListener(new NewOnClickListener () {
            @Override

            Public void onClick(View view) {

                regBtn.setVisibility(View.INVISIBLE);
                loadingProgress.setVisibility(View.VISIBLE);
                final String email = userEmail.getText().toString();
                final String password = userPassword.getText().toString();
                final String password2 = userPassword2.getText().toString();
                final String name = userName.getText().toString();

                if (email.isEmpty() || password.isEmpty() || password2.isEmpty() || name.isEmpty() || !password.equals(password2)) {

                    //Fehlermeldung

                    showMessage("Bitte überprufen Sie Ihre Information");

                }

            }
        });








        ImgUserPhoto = findViewById(R.id.regUserPhoto);

        ImgUserPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= 22) {

                    checkAndRequestForPermission();
                } else {
                    openGallery();
                }

            }
        });


    }

//update Profilbild und Name
    private void updateUserInfo (final String name, Uri pickedImgUri, final FirebaseUser currentUser){

        //lädt Profilbild hoch und bekommt die URL

        StorageReference_m mStorage = FirebaseStorage.getInstance().getReference().child("users_photos");
        final StorageReference imageFilePath = ((StorageReference) mStorage).child(pickedImgUri.getLastPathSegment());
        imageFilePath.putFile(pickedImgUri) .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                //Bild erfolgreich hochgeladen und URL des Bilds zeigen


                imageFilePath.getDownloadUrl().addOnSuccessListener(new onSuccessListener<Uri>(){
                    @Override
                    public void onSuccess(Uri uri) {
                        //URL enthält username

                        UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                                .setDisplayName(name)
                                .setPhotoUri(uri)
                                build();


                        currentUser.updateProfile(profileUpdate)
                                .addOnCompleteListener(new onCompleteListener<Void>(){
                                @Override
                                public void onComplete(@NonNull Task<Void> task){
                                    if (task.isSucessful()) {
                                            //Benutzer Info Updatet
                                        showMessage("Anmeldung Erfolgreich");
                                           updateUI();
                                    }
                                }

                                });


                    });


                });


            }
        })

    }

private void updateUI (){
        Intent homeActivity = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity (homeActivity);
        finish();

}


    //Toast Message fuer die Fehlermeldung
    private void showMessage(String message) {

        Toast.makeText( getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    private void openGallery() {
        //TODO: open gallery intent and

        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, REQUESTCODE);


    }

    private void checkAndRequestForPermission() {

        if (ContextCompat.checkSelfPermission(RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE))

            {


                Toast.makeText(RegisterActivity.this, "Please Accept Requested Permission", Toast.LENGTH_SHORT).show();

            } else


                ActivityCompat.requestPermissions(RegisterActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PreqCode);


        } else

            openGallery();


    }


    private void createUserAccount(String email, String name, String password ) {

    mAuth.CreateUserWithEmailAndPassword(email, password)
    .addOnCompleteListener( activity: this, new OnCompleteListener <AuthResult>() {

        @Override

        public void OnComplete(@NonNull Task<AuthResult> task){
            if (task.isSucessfull())
            {
                    //user account erzeugt
                showMessage("Konto erfolgreich erzeugt");
                //Updaten Profilbild und Name
                updateUserInfo (name, pickedImgUri, mAuth.getCurrentUser());

            }

            else {

                showMessage("Konto könnte nicht geschpeicher werden" + task.getException().getMessage());
                regBtn.setVisibility(View.VISIBLE);
                loadingProgress.setVisibility(View.Invisible);
            }




        }




    });



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUESTCODE && data != null) {
            // Bild erfolgreich ausgewählt, Referenz soll gespeichert werden
            pickedImgUri = data.getData();
            ImgUserPhoto.setImageURI(pickedImgUri);
        }

    }
}
