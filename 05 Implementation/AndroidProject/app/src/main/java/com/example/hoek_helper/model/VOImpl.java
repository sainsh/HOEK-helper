package com.example.hoek_helper.model;

import static java.lang.Double.NaN;

public class VOImpl implements VO {


    double vaerdi = NaN;

    /**
     * Constructoren modtager 4 parametre der kan bruges til at beregne VO.
     *
     * @param stk
     * @param ve
     * @param ko
     * @param sto
     */
    public VOImpl(STK stk, VE ve, KO ko, STO sto){

    }


    @Override
    public void setVaerdi(double vaerdi) {
        this.vaerdi = vaerdi;
    }

    @Override
    public double getVaerdi() {
        return vaerdi;
    }
}
