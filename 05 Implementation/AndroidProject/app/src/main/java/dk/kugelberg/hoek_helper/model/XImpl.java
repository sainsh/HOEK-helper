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
    STO sto;
    SE se;

    private double vaerdi = Double.NaN;
    private boolean erBeregnet = false;

    public void init(VO vo, VE ve, VO vo1, VO vo2, DOMK domk, DOMK domk2, STO sto, SE se) {
        this.vo = vo;
        this.ve = ve;
        this.domk = domk;
    }

    @Override
    public void init(VO vo, VE ve, X x1, X x2, VO vo1, VO vo2, DOMK domk, DOMK domk2) {

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

        return vaerdi;
    }


    @Override
    public void beregn() {


        double x = vo.getVaerdi() / ve.getVaerdi();
        //double x = ko.getVaerdi() / ke.getVaerdi();
        double x = sto.getVaerdi() / se.getVaerdi();
        /*
        X = KO / KE
        X = VO / VE
        X = STO / SE
        */

                this.vaerdi = x;
    }


}
