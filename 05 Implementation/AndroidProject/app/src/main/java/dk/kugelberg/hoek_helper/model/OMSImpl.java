package dk.kugelberg.hoek_helper.model;

public class OMSImpl implements OMS{

    double vaerdi;

    public OMSImpl(){
        vaerdi = Double.NaN;
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
