package com.example.retten.retten.Activities;


import com.example.retten.retten.database.DataHolder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.example.retten.retten.database.Product;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toolbar;

import com.example.retten.retten.R;



    public class HomeActivity extends AppCompatActivity {

        private DatabaseReference mDatabase;


        public final String TAG = MainAppPage.class.getSimpleName();
        ListView shoppingItemView;
        ShoppingListAdapter adapter;
        EditText toolbar;

        TextView ifSellerListEmpty;
        Button addProduct;

        private Boolean exit = false;
        private ArrayList<ShoppingItem> shoppingItems;


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



        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            if(getIntent().getExtras().getBoolean("isuserseller")){
                setContentView(R.layout.activity_seller_main_page);

                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                toolbar.setTitle("Supermarkt");
                setSupportActionBar(toolbar);

                searchbar = (EditText)findViewById(R.id.searchBar);

                progressBar = (ProgressBar) findViewById(R.id.sellerPageProgressBar);
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

                            shoppingItems = setUpList(dataSnapshot.child("products"));
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





    }
