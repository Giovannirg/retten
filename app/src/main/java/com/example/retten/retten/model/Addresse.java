package com.example.retten.retten.model;

public class Addresse {

    public Addresse(String m_streetName,String m_houseNumber,String m_postNumber,String m_city)
    {
        this.m_streetName=m_streetName;
        this.m_houseNumber=m_houseNumber;
        this.m_postNumber=m_postNumber;
        this.m_city=m_city;

    }
    public Addresse()
    {

        this.m_streetName="";
        this.m_houseNumber="";
        this.m_postNumber="";
        this.m_city="";

    }

    String m_streetName;

    public String get_streetName() {
        return m_streetName;
    }

    public void set_streetName(String m_streetName) {
        this.m_streetName = m_streetName;
    }

    public String get_houseNumber() {
        return m_houseNumber;
    }

    public void set_houseNumber(String m_houseNumber) {
        this.m_houseNumber = m_houseNumber;
    }

    public String get_postNumber() {
        return m_postNumber;
    }

    public void set_postNumber(String m_postNumber) {
        this.m_postNumber = m_postNumber;
    }

    public String get_city() {
        return m_city;
    }

    public void set_city(String m_city) {
        this.m_city = m_city;
    }

    String m_houseNumber;
    String m_postNumber;
    String m_city;





}
