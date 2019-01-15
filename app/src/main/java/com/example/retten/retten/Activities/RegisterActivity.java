package com.example.retten.retten.Activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retten.retten.R;
import com.example.retten.retten.database.DataHolder;
import com.example.retten.retten.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;

public class RegisterActivity extends AppCompatActivity {

    ImageView ImgUserPhoto;
    static int PreqCode = 1;
    static int REQUESCODE = 1;
    Uri pickedImgUri;

    private static final String TAG = LoginActivity.class.getSimpleName();
    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    public FirebaseAuth.AuthStateListener mAuthListener;
    private Button mRegister;
    private String email, password, passwordVerification;
   // private EditText email, password, passwordVerification;
    private EditText username, pass, passVerification, firstname, lastname;
    private boolean isRegistrationClicked = false, isSupermarkt = false;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username =  findViewById(R.id.regMail);
        pass =  findViewById(R.id.regPassword);
        passVerification = findViewById(R.id.regPassword2);
        firstname =  findViewById(R.id.regName);
        lastname = findViewById(R.id.regLName);



        setViews(true);

        progressBar = (ProgressBar) findViewById(R.id.regProgressBar2);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    String name = firstname.getText().toString() + " " + lastname.getText().toString();
                    UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder().
                            setDisplayName(name).build();
                    user.updateProfile(profileChangeRequest);

                    DatabaseReference myRef;

                    if (!isSupermarkt){
                        myRef = FirebaseDatabase.getInstance().getReference("users/").child(user.getUid());
                        myRef.child(user.getUid()).push();

                        // As firebase does not accept keys with empty values, I'm putting a dummy item with empty Strings and -1 as ints
                        // Quantity of items in cart is not realtime database quantity but the quantity the user wants
                        ArrayList<ShoppingItem> cart = new ArrayList<>();
                        cart.add(new ShoppingItem("", "", "", "", -1, -1));
                        Map<String, Object> cartItems = new HashMap<>();
                        cartItems.put("cartItems", cart);

                        // Adding a isCartEmpty State Variable for cart window display

                        Map<String, Object> cartState = new HashMap<>();
                        cartState.put("isCartEmpty", Boolean.TRUE);

                        // Updating the database for the user
                        myRef.updateChildren(cartItems);
                        myRef.updateChildren(cartState);
                    } else {
                        myRef = FirebaseDatabase.getInstance().getReference("Supermarkt").child(user.getUid());
                        myRef.child(user.getUid()).push();

//                        Dummy product sold by any seller who has 0 products
                        ArrayList<ShoppingItem> prods = new ArrayList<>();
                        prods.add(new ShoppingItem("", "", "", "", -1, -1));
                        Map<String, Object> prodslist = new HashMap<>();
                        prodslist.put("products", prods);

                        Map<String, Object> state = new HashMap<>();
                        state.put("isProdsEmpty", Boolean.TRUE);

                        // Updating the database for the seller
                        myRef.updateChildren(prodslist);
                        myRef.updateChildren(state);
                    }

                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };

        mRegister = (Button) findViewById(R.id.regBtn);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setViews(false);
             email = username.getText().toString();
             password = pass.getText().toString();
             passwordVerification = passVerification.getText().toString();
                if (password.equals(passwordVerification) && !password.equals("") && !passwordVerification.equals("")) {
                    createAccount();
                } else {
                    Snackbar.make(findViewById(R.id.regProgressBar2), "Passwords don't match", Snackbar.LENGTH_SHORT).show();
                    pass.setText("");
                    passVerification.setText("");
                    setViews(true);
                }
            }
        });
    }








    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("firstname", firstname.getText().toString());
        outState.putString("lastname", lastname.getText().toString());
        outState.putString("email", username.getText().toString());
        setViews(false);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        firstname.setText(savedInstanceState.getString("firstname"));
        lastname.setText(savedInstanceState.getString("lastname"));
        username.setText(savedInstanceState.getString("email"));
        setViews(true);
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void createAccount() {
        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                        isRegistrationClicked = true;

                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
//                            Toast.makeText(newUser.this, R.string.auth_failed, Toast.LENGTH_SHORT).show();
                            Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            setViews(true);
                            isRegistrationClicked = false;
                            progressBar.setVisibility(View.GONE);
                        }
                        // ...
                    }
                });
    }

    private void sendVerificationEmail() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        user.sendEmailVerification()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // Email sent
                            finish();
                        } else {
                            // overridePendingTransition(0, 0);
                            // finish();
                            // overridePendingTransition(0, 0);
                            // startActivity(getIntent());
                            sendVerificationEmail();
                        }
                    }
                });
    }

    @Override
    public void finish() {
        FirebaseAuth.getInstance().signOut();
        progressBar.setVisibility(View.GONE);
        if (isRegistrationClicked) {
            Toast.makeText(getApplicationContext(), "Verify Email and Login", Toast.LENGTH_LONG).show();
        }
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        super.finish();
    }

    private void setViews(boolean val) {
        username.setEnabled(val);
        pass.setEnabled(val);
        firstname.setEnabled(val);
        lastname.setEnabled(val);
        passVerification.setEnabled(val);
    }










        // update user photo and name
    private void updateUserInfo(final String name, Uri pickedImgUri, final FirebaseUser currentUser) {

        // first we need to upload user photo to firebase storage and get url

        StorageReference mStorage = FirebaseStorage.getInstance().getReference().child("users_photos");
        final StorageReference imageFilePath = mStorage.child(pickedImgUri.getLastPathSegment());
        imageFilePath.putFile(pickedImgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                // image uploaded succesfully
                // now we can get our image url

                imageFilePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {

                        // uri contain user image url


                        UserProfileChangeRequest profleUpdate = new UserProfileChangeRequest.Builder()
                                .setDisplayName(name)
                                .setPhotoUri(uri)
                                .build();


                        currentUser.updateProfile(profleUpdate)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                        if (task.isSuccessful()) {
                                            // user info updated successfully
                                            showMessage("Register Complete");
                                            updateUI();
                                        }

                                    }
                                });

                    }
                });





            }
        });






    }

    private void updateUI() {

        Intent homeActivity = new Intent(this,HomeActivity.class);
        startActivity(homeActivity);
    }

    // simple method to show toast message
    private void showMessage(String message) {

        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

    }

    private void openGallery() {
        //TODO: open gallery intent and wait for user to pick an image !

        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent,REQUESCODE);
    }

    private void checkAndRequestForPermission() {


        if (ContextCompat.checkSelfPermission(RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

                Toast.makeText(RegisterActivity.this,"Please accept for required permission",Toast.LENGTH_SHORT).show();

            }

            else
            {
                ActivityCompat.requestPermissions(RegisterActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PreqCode);
            }

        }
        else
            openGallery();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUESCODE && data != null ) {

            // the user has successfully picked an image
            // we need to save its reference to a Uri variable
            pickedImgUri = data.getData() ;
            ImgUserPhoto.setImageURI(pickedImgUri);


        }


    }
}
