package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

public class KEimpl implements KE {

    private KO ko;
    private X x;
    private SE se;
    private VE ve;

    private double vaerdi = NaN;
    private boolean erBeregnet = false;

    public KEimpl() {
    }

    @Override
    public void init(KO ko, X x, SE se, VE ve) {
        this.ko = ko;
        this.x = x;
        this.se = se;
        this.ve = ve;
    }

    @Override
    public void setVaerdi(double x) {
        if (x < 0) {
            throw new NegativVaerdiException();
        } else {
            vaerdi = x;
            setBeregnet(false);
        }
    }

    @Override
    public double getVaerdi() {
        return vaerdi;
    }

    @Override
    public void setBeregnet(boolean val) {
        erBeregnet = val;
    }

    @Override
    public boolean getBeregnet() {

        return erBeregnet;
    }

    @Override
    public void beregn() {

        if (!Double.isNaN(ko.getVaerdi()) && !Double.isNaN(x.getVaerdi())) {

            vaerdi = ko.getVaerdi() / x.getVaerdi();
            setBeregnet(true);

        } else if (!Double.isNaN(se.getVaerdi()) && !Double.isNaN(ve.getVaerdi())) {
            vaerdi = se.getVaerdi() - ve.getVaerdi();
            setBeregnet(true);

        } else if (getBeregnet()) {
            setVaerdi(NaN);

        }
        if (vaerdi == NaN) erBeregnet = false;
    }
}