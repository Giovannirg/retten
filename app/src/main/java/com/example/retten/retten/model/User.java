package com.example.retten.retten.model;

import com.google.firebase.auth.FirebaseUser;

public class User {
    public String get_email() {
        return m_email;
    }

    public void set_email(String m_email) {
        this.m_email = m_email;
    }

    public String get_UID() {
        return m_UID;
    }

    public void set_UID(String m_UID) {
        this.m_UID = m_UID;
    }

    public FirebaseUser get_firebaseUser() {
        return m_firebaseUser;
    }

    public void set_firebaseUser(FirebaseUser m_firebaseUser) {
        this.m_firebaseUser = m_firebaseUser;
    }

    public String get_id() {
        return m_id;
    }

    public void set_id(String m_id) {
        this.m_id = m_id;
    }

    public String get_vorname() {
        return m_vorname;
    }

    public void set_vorname(String m_vorname) {
        this.m_vorname = m_vorname;
    }

    public String get_nachname() {
        return m_nachname;
    }

    public void set_nachname(String m_nachname) {
        this.m_nachname = m_nachname;
    }

    public boolean admin (boolean m_admin){ return m_admin;}

    public Addresse get_addresse() {
        return m_addresse;
    }

    public void set_addresse(Addresse m_addresse) {
        this.m_addresse = m_addresse;
    }



    public User(){
        this.m_nachname="";
        this.m_vorname="";
        m_addresse =new Addresse();
        this.m_email="";
        this.m_UID="";
        this.m_id="";
        isAdmin=false;
    }

    public User(String email,String UID,FirebaseUser user,String id,String m_vorname,String m_nachname,Addresse addresse,boolean isAdmin){
        this.m_addresse=addresse;
        this.m_email=email;
        this.m_UID=UID;
        this.m_firebaseUser=user;
        this.m_id=id;
        this.m_vorname=m_vorname;
        this.m_nachname=m_nachname;
        this.isAdmin=isAdmin;

    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    boolean isAdmin;
    String m_email;
    String m_UID;
    FirebaseUser m_firebaseUser;
    String m_id;
    String m_vorname;
    String m_nachname;
    Addresse m_addresse;

    public String get_phone() {
        return m_phone;
    }

    public void set_phone(String m_phone) {
        this.m_phone = m_phone;
    }

    String m_phone;




}
