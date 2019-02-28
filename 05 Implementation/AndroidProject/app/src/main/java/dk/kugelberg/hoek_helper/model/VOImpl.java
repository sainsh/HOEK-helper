package dk.kugelberg.hoek_helper.model;

public class VOImpl implements VO {


    double vaerdi = Double.NaN;


    public VOImpl() {
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
