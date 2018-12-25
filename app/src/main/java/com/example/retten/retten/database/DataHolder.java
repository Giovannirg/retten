package com.example.retten.retten.database;

import com.example.retten.retten.model.Supermarkt;
import com.example.retten.retten.model.User;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
import java.util.UUID;

public class DataHolder {
    private static final DataHolder holder = new DataHolder();
    public static DataHolder getInstance(){return holder;}
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    List<Product> m_products ;
    public List<Product> getData() {
        return m_products;
    }
    public void setData(List<Product> data) {
        this.m_products = data;
    }

    private static DatabaseReference userRef;


    public boolean setSupermarktinData (FirebaseUser user , Supermarkt supermarkt) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        userRef = database.getReference("/User");

        try {
            String n = UUID.randomUUID().toString();
            userRef.child(n).push();
            userRef.child(n).child("address").setValue(supermarkt.get_addresse().get_streetName());
            userRef.child(n).child("hausnummer").setValue(supermarkt.get_addresse().get_housNumber());
            userRef.child(n).child("hausstage").setValue(supermarkt.get_Hausetage());
            userRef.child(n).child("name").setValue(supermarkt.get_vorname());
            userRef.child(n).child("closedtime").setValue(supermarkt.get_Schließzeit());
            userRef.child(n).child("opentime").setValue(supermarkt.get_Öffnungszeit());
            userRef.child(n).child("opendays").setValue(supermarkt.get_Öffnungstage());
            userRef.child(n).child("phone").setValue(supermarkt.get_phone());
            return true;





        }

        catch (Exception e){

            return false;
        }
    }
}
