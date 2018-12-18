package com.example.retten.retten.model;

public class Addresse {

    public Addresse(String m_streetName,String m_housNumber,String m_postNumber,String m_city)
    {
        this.m_streetName=m_streetName;
        this.m_housNumber=m_housNumber;
        this.m_postNumber=m_postNumber;
        this.m_city=m_city;

    }
    public Addresse()
    {}

    String m_streetName;

    public String get_streetName() {
        return m_streetName;
    }

    public void set_streetName(String m_streetName) {
        this.m_streetName = m_streetName;
    }

    public String get_housNumber() {
        return m_housNumber;
    }

    public void set_housNumber(String m_housNumber) {
        this.m_housNumber = m_housNumber;
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

    String m_housNumber;
    String m_postNumber;
    String m_city;





}
