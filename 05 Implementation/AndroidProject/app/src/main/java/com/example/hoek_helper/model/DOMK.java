package com.example.hoek_helper.model;

public interface DOMK {

    void setVaerdi(double vaerdi);
    double getVaerdi();
    void beregn();
    void init(VO vo1, VO vo2, STO sto, KO ko, VE ve, X x1, X x2, DOMK domk1, DOMK domk2);
    boolean erBeregnet();


}



