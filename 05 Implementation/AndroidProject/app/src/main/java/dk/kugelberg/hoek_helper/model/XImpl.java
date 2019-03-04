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

        if (vo.getVaerdi()!= NaN && ve.getVaerdi() != NaN){
        double x = vo.getVaerdi() / ve.getVaerdi();
        }
        else if (vo.getVaerdi()!= NaN && ve.getVaerdi() != NaN){
        double x = ko.getVaerdi() / ke.getVaerdi();
        }
        else if (sto.getVaerdi() != NaN && se.getVaerdi() != NaN){
        double x = sto.getVaerdi() / se.getVaerdi();
        }
        else if (domk.getVaerdi() != NaN && vo.getVaerdi() != NaN){
            double x = sto.getVaerdi() / se.getVaerdi();
        }

        /*
        X = KO / KE
        X = VO / VE
        X = STO / SE
        X = DOMK * VO
        */

                this.vaerdi = x;
    }


}
