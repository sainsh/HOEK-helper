package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

public interface KEimpl extends KE {

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
