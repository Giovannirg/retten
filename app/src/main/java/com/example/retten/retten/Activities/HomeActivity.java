package com.example.retten.retten.Activities;


import com.example.retten.retten.database.DataHolder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.example.retten.retten.database.Product;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toolbar;

import com.example.retten.retten.R;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {

        private DatabaseReference mDatabase;


        public final String TAG = HomeActivity.class.getSimpleName();
        ListView shoppingItemView;
        ShoppingListAdapter adapter;
        EditText toolbar;

        FirebaseDatabase database;
        TextView ifSellerListEmpty;
        Button addProduct;

        private Boolean exit = false;
        private ArrayList<ShoppingItem> shoppingItems;


       /* @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);


            mDatabase = FirebaseDatabase.getInstance().getReference();
            addNewProduct("ID1", "product1", "category1", 13.50);
        }
        */


        private void addNewProduct(String productId, String productname, String productcategory, double price) {
            Product product = new Product(productId, productname, productcategory, price );

            mDatabase.child("products").child(productId).setValue(product);

        }



        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            if(getIntent().getExtras().getBoolean("isuserseller"))
            {
                setContentView(R.layout.activity_seller_page);
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                toolbar.setTitle("Supermarkt");
                setSupportActionBar(toolbar);
                final EditText searchbar = (EditText)findViewById(R.id.searchBar);
                final ProgressBar progressBar = (ProgressBar) findViewById(R.id.sellerPageProgressBar);
                progressBar.setVisibility(View.VISIBLE);
                addProduct = (Button) findViewById(R.id.sellerAddProduct);
                shoppingItemView = (ListView) findViewById(R.id.sellerProductList);
                ifSellerListEmpty = (TextView) findViewById(R.id.ifSellerListEmpty);
                addProduct = (Button) findViewById(R.id.sellerAddProduct);
                DatabaseReference myref = database.getReference("sellers/" +
                        FirebaseAuth.getInstance().getCurrentUser().getUid());
                myref.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(Boolean.valueOf(dataSnapshot.child("isProdsEmpty").getValue().toString())){
                            shoppingItemView.setVisibility(View.GONE);
                            searchbar.setVisibility(View.GONE);
                            ifSellerListEmpty.setVisibility(View.VISIBLE);
                        } else {
                            shoppingItemView.setVisibility(View.VISIBLE);
                            ifSellerListEmpty.setVisibility(View.GONE);

                            shoppingItems = setupList(dataSnapshot.child("products"));
                            adapter = new ShoppingListAdapter(getApplicationContext(), shoppingItems);
                            shoppingItemView.setAdapter(adapter);

                            shoppingItemView.setTextFilterEnabled(true);
                            searchbar.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                }

                                @Override
                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                    int textlength = charSequence.length();
                                    ArrayList<ShoppingItem> tempShoppingItems = new ArrayList<>();
                                    for(ShoppingItem x: shoppingItems){
                                        if (textlength <= x.getTitle().length()) {
                                            if (x.getTitle().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                                                tempShoppingItems.add(x);
                                            }
                                        }
                                    }
                                    shoppingItemView.setAdapter(new ShoppingListAdapter(getApplicationContext(), tempShoppingItems));
                                }

                                @Override
                                public void afterTextChanged(Editable editable) {

                                }
                            });
                        }
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }


                });
            }
        }

    public static ArrayList<ShoppingItem> setUpList(DataSnapshot dataSnapshot) {

        ArrayList<ShoppingItem> items  = new ArrayList<ShoppingItem>();

        for (DataSnapshot snap : dataSnapshot.getChildren()){

            int itemPrice = -1, quantity = 0;

            try{
                itemPrice = Integer.valueOf(NumberFormat.getCurrencyInstance()
                        .parse(String.valueOf(snap.child("price").getValue()))
                        .toString());
            } catch (ParseException e){
                e.printStackTrace();
            }

            quantity = Integer.valueOf(snap.child("quantity").getValue().toString());
            items.add(new ShoppingItem(
                    snap.child("productID").getValue().toString(),
                    snap.child("title").getValue().toString(),
                    snap.child("type").getValue().toString(),
                    snap.child("description").getValue().toString(),
                    itemPrice,
                    quantity
            ));
        }

        return items;

    }


    private void setSupportActionBar(Toolbar toolbar) {
    }

}