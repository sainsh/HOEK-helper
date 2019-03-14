package dk.kugelberg.hoek_helper.model;

public class OMSImpl implements OMS {
    double vaerdi = Double.NaN;

    public void init(VE ve, X x, KO ko, DOMK domk, STO sto, SE se, X xOver, VO voOver, X xUnder, VO voUnder, DOMK domkUnder) {

    }

    public void setVaerdi(double vaerdi) {
        this.vaerdi = vaerdi;
    }

    public double getVaerdi() {
        return vaerdi;
    }

    public void beregn() {

    }

    public void setBeregnet(boolean val) {

    }

    public boolean getBeregnet() {
        return false;
    }
}