package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

public class KEimpl implements KE {

    private double vaerdi;

    public void setVaerdi(double vaerdi){

        this.vaerdi = vaerdi;

    }

    public double getVaerdi(){

        return vaerdi;

    }

    @Override
    public void beregn() {

    }

}
