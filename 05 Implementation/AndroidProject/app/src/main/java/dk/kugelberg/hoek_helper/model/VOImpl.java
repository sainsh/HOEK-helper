package dk.kugelberg.hoek_helper.model;

public class VOImpl implements VO {


    private double vaerdi = Double.NaN;


    @Override
    public void setVaerdi(double vaerdi) {
        this.vaerdi = vaerdi;
    }

    @Override
    public double getVaerdi() {
        return vaerdi;
    }

    @Override
    public void beregn() {

    }

    @Override
    public void init(VO vo1, VO vo2, STO sto, KO ko, VE ve, X x1, X x2, DOMK domk1, DOMK domk2) {

    }

    @Override
    public boolean erBeregnet() {
        return false;
    }
}
