package com.example.retten.retten.database;

import android.support.annotation.NonNull;

import com.example.retten.retten.model.Addresse;
import com.example.retten.retten.model.Supermarkt;
import com.example.retten.retten.model.User;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

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
            userRef.child(n).child("isSupermarkt").setValue(true);
            userRef.child(n).child("address").setValue(supermarkt.get_addresse().get_streetName());
            userRef.child(n).child("hausnummer").setValue(supermarkt.get_addresse().get_houseNumber());
            userRef.child(n).child("hausstage").setValue(supermarkt.get_Hausetage());
            userRef.child(n).child("name").setValue(supermarkt.get_vorname());
            userRef.child(n).child("closedtime").setValue(supermarkt.get_Schließzeit());
            userRef.child(n).child("opentime").setValue(supermarkt.get_Öffnungszeit());
            userRef.child(n).child("opendays").setValue(supermarkt.get_Öffnungstage());
            userRef.child(n).child("phone").setValue(supermarkt.get_phone());
            userRef.child(n).child("pzl").setValue(supermarkt.get_addresse().get_postNumber());
            userRef.child(n).child("City").setValue(supermarkt.get_addresse().get_city());
            userRef.child(n).child("email").setValue(user.getEmail());
            userRef.child(n).child("Password").setValue(user.getUid());
            return true;





        }

        catch (Exception e){

            return false;
        }
    }



   /* public boolean setAdmininData (FirebaseUser user , Admin admin) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        userRef = database.getReference("/User");

        try {
            String n = UUID.randomUUID().toString();
            userRef.child(n).push();
            userRef.child(n).child("isAdmin").setValue(true);
            userRef.child(n).child("name").setValue(admin.get_vorname());
            userRef.child(n).child("email").setValue(user.getEmail());
            userRef.child(n).child("Password").setValue(user.getUid());
            return true;





        }

        catch (Exception e){

            return false;
        }
    }*/




    public boolean getUserData (String email,String password) {
        try {
            Query query = FirebaseDatabase.getInstance().getReference("/User").orderByChild("email").equalTo(email);
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot d: dataSnapshot.getChildren()) {
                        if(d.child("isSupermarkt").getValue()==true)
                        {
                            DataHolder.getInstance().setUser(new Supermarkt());
                            DataHolder.getInstance().getUser().set_vorname((String) d.child("name").getValue());
                            DataHolder.getInstance().getUser().set_phone((String)d.child("phone").getValue());
                            DataHolder.getInstance().getUser().set_UID((String)d.child("password").getValue());
                            DataHolder.getInstance().getUser().set_email((String)d.child("email").getValue());
                            Addresse addresse =new Addresse();
                            addresse.set_streetName((String)d.child("address").getValue());
                            addresse.set_city((String)d.child("city").getValue());
                            addresse.set_postNumber((String)d.child("pzl").getValue());
                            addresse.set_houseNumber((String)d.child("hausnummer").getValue());
                            DataHolder.getInstance().getUser().set_addresse(addresse);
                            DataHolder.getInstance().getUser().setAdmin((boolean)d.child("isAdmin").getValue());
                            DataHolder.getInstance().getUser().set_id((String)d.getKey());
                        }
                        else {
                            DataHolder.getInstance().setUser(new User());
                            DataHolder.getInstance().getUser().set_vorname((String) d.child("name").getValue());
                            DataHolder.getInstance().getUser().set_phone((String) d.child("phone").getValue());
                            DataHolder.getInstance().getUser().set_UID((String) d.child("password").getValue());
                            DataHolder.getInstance().getUser().set_email((String) d.child("email").getValue());
                            Addresse addresse = new Addresse();
                            addresse.set_streetName((String) d.child("address").getValue());
                            addresse.set_city((String) d.child("city").getValue());
                            addresse.set_postNumber((String) d.child("pzl").getValue());
                            addresse.set_houseNumber((String) d.child("hausnummer").getValue());
                            DataHolder.getInstance().getUser().set_addresse(addresse);
                            DataHolder.getInstance().getUser().setAdmin((boolean) d.child("isAdmin").getValue());
                            DataHolder.getInstance().getUser().set_id((String) d.getKey());
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }catch (Exception e) {
            return false;
        }
        return true;
    }


    public boolean setUserinData (FirebaseUser user , User benutzer) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        userRef = database.getReference("/User");

        try {
            String n = UUID.randomUUID().toString();
            userRef.child(n).push();
            userRef.child(n).child("isSupermarkt").setValue(false);
            userRef.child(n).child("isAdmin").setValue(false);
            userRef.child(n).child("address").setValue(benutzer.get_addresse().get_streetName());
            userRef.child(n).child("hausnummer").setValue(benutzer.get_addresse().get_houseNumber());
            userRef.child(n).child("name").setValue(benutzer.get_vorname());
            userRef.child(n).child("Last_name").setValue(benutzer.get_nachname());
            userRef.child(n).child("phone").setValue(benutzer.get_phone());
            userRef.child(n).child("pzl").setValue(benutzer.get_addresse().get_postNumber());
            userRef.child(n).child("city").setValue(benutzer.get_addresse().get_city());
            userRef.child(n).child("email").setValue(user.getEmail());
            userRef.child(n).child("Password").setValue(user.getUid());
            return true;





        }

        catch (Exception e){

            return false;
        }
    }

}
