package dk.kugelberg.hoek_helper.model;

public class XImpl implements X {

    VO vo;
    VE ve;
    X x1;
    X x2;
    VO vo1;
    VO vo2;
    DOMK domk;
    DOMK domk2;

    private double vaerdi = Double.NaN;
    private boolean erBeregnet = false;

    public void init(VO vo, VE ve, X x1, X x2, VO vo1, VO vo2, DOMK domk, DOMK domk2) {
        this.vo = vo;
        this.ve = ve;
        this.domk = domk;
    }

    //start
    @Override
    public void setVaerdi(double x) {
        if (x < 0) {
            throw new NegativVaerdiException();
        } else {
            this.vaerdi = x;
            erBeregnet = false;
        }
    }

    @Override
    public double getVaerdi() {
        if (vaerdi == Double.NaN)
            beregn();

        return vaerdi;
    }


    @Override
    public void beregn() {


        double x = vo.getVaerdi() / ve.getVaerdi();

                this.vaerdi = x;
    }


}
