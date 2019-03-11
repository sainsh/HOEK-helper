package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

public class VEImpl implements VE {

    private VO vo;
    private X x;
    private SE se;
    private KE ke;

    private double vaerdi = NaN;
    private boolean erBeregnet = false;

    public VEImpl() {
    }

    @Override
    public void init(VO vo, X x, SE se, KE ke) {
        this.vo = vo;
        this.x = x;
        this.se = se;
        this.ke = ke;
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

        // VE = VO / X
        if (!Double.isNaN(x.getVaerdi()) && !Double.isNaN(vo.getVaerdi())) {

            vaerdi = vo.getVaerdi() / x.getVaerdi();
            setBeregnet(true);
        }

        // VE = SE - KE
        else if (!Double.isNaN(se.getVaerdi()) && !Double.isNaN(ke.getVaerdi())) {
            vaerdi = se.getVaerdi() - ke.getVaerdi();
            setBeregnet(true);

        } else if (getBeregnet()) {
            setVaerdi(NaN);
        }
        if (vaerdi == NaN) erBeregnet = false;
    }
}