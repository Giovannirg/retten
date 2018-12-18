package com.example.retten.retten.model;

import com.example.retten.retten.database.Product;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class Supermarkt extends User {
    public String getM_Marktname() {
        return m_Marktname;
    }

    public void setM_Marktname(String m_Marktname) {
        this.m_Marktname = m_Marktname;
    }

    public String getM_Hausetage() {
        return m_Hausetage;
    }

    public void setM_Hausetage(String m_Hausetage) {
        this.m_Hausetage = m_Hausetage;
    }

    public String getM_Öffnungszeit() {
        return m_Öffnungszeit;
    }

    public void setM_Öffnungszeit(String m_Öffnungszeit) {
        this.m_Öffnungszeit = m_Öffnungszeit;
    }

    public String getM_Schließzeit() {
        return m_Schließzeit;
    }

    public void setM_Schließzeit(String m_Schließzeit) {
        this.m_Schließzeit = m_Schließzeit;
    }

    public String getM_Öffnungstage() {
        return m_Öffnungstage;
    }

    public void setM_Öffnungstage(String m_Öffnungstage) {
        this.m_Öffnungstage = m_Öffnungstage;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public Supermarkt(){super();}
    public Supermarkt( String m_email,
            String m_UID,
            FirebaseUser m_firebaseUser,
            String m_id,
            String m_vorname,
            String m_nachname,
            Addresse m_addresse,
            String m_Marktname,
            String m_Hausetage,
            String m_Öffnungszeit,
            String m_Schließzeit,
            String m_Öffnungstage){
        super(m_email,m_UID,m_firebaseUser,m_id,m_vorname,m_nachname,m_addresse);
        this.m_Marktname=m_Marktname;
        this.m_Hausetage=m_Hausetage;
        this.m_Öffnungszeit=m_Öffnungszeit;
        this.m_Schließzeit=m_Schließzeit;
        this.m_Öffnungstage=m_Öffnungstage;
    }


    String m_Marktname;
    String m_Hausetage;
    String m_Öffnungszeit;
    String m_Schließzeit;
    String m_Öffnungstage;
    List<Product> products;




}
