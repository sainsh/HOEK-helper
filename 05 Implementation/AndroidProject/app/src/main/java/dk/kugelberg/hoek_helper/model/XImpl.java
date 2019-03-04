package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

public class XImpl implements X {

    VO vo;
    VE ve;
    X x1;
    X x2;
    KO ko;
    KE ke;
    VO vo1;
    VO vo2;
    DOMK domk;
    DOMK domk2;
    STO sto;
    SE se;

    private double vaerdi = NaN;
    private boolean erBeregnet = false;

    public void init(VO vo, VE ve, DOMK domk, STO sto, SE se) {
        this.vo = vo;
        this.ve = ve;
        this.domk = domk;
        this.sto = sto;
        this.se = se;
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


        if (vo.getVaerdi() != NaN && ve.getVaerdi() != NaN) {
            this.vaerdi = vo.getVaerdi() / ve.getVaerdi();

        } else if (ko.getVaerdi() != NaN && ke.getVaerdi() != NaN) {
            this.vaerdi = ko.getVaerdi() / ke.getVaerdi();

        } else if (sto.getVaerdi() != NaN && se.getVaerdi() != NaN) {
            this.vaerdi = sto.getVaerdi() / se.getVaerdi();

        } else if (domk.getVaerdi() != NaN && vo.getVaerdi() != NaN) {
            this.vaerdi = domk.getVaerdi() * vo.getVaerdi();
        }

        /*
        X = KO / KE
        X = VO / VE
        X = STO / SE
        X = DOMK * VO
        */
    }


}
