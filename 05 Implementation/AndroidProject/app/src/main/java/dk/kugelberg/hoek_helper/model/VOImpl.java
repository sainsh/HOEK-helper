package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

public class VOImpl implements VO {

    VE ve;
    X x;
    X x1;
    X x2;
    KO ko;
    VO vo1;
    VO vo2;
    DOMK domk;
    DOMK domk2;
    STO sto;
    SE se;

/*
VO = VE * X
VO = STO - KO
VO = DB - Oms
*/

    private double vaerdi = Double.NaN;
    private boolean erBeregnet = false;


    public void init(VE ve, X x, KO ko, DOMK domk, STO sto, SE se) {
        this.ve = ve;
        this.x = x;
        this.ko = ko;
        this.domk = domk;
        this.sto = sto;
        this.se = se;
    }

    @Override
    public void init1(X x1, VO vo1) {
        this.x1 = x1;
        this.vo1 = vo1;
    }

    @Override
    public void init2(X x2, VO vo2, DOMK domk2) {
        this.x2 = x2;
        this.vo2 = vo2;
        this.domk2 = domk2;
    }

    @Override
    public void setVaerdi(double vaerdi) {
        if (vaerdi < 0) {
            throw new VaerdiException();
        } else {
            this.vaerdi = vaerdi;
            erBeregnet = false;
        }
    }

    @Override
    public double getVaerdi() {
        return vaerdi;
    }

    @Override
    public void setBeregnet(boolean val){
        erBeregnet = val;
    }

    @Override
    public boolean getBeregnet(){
        return erBeregnet;
    }


    @Override
    public void beregn() {


        if (ve.getVaerdi() != NaN && x.getVaerdi() != NaN) {
            this.vaerdi = ve.getVaerdi() * x.getVaerdi();
            setBeregnet(true);

        } else if (sto.getVaerdi() != NaN && ko.getVaerdi() != NaN) {
            this.vaerdi = sto.getVaerdi() - ko.getVaerdi();
            setBeregnet(true);

        } /* else if (db.getVaerdi() != NaN && oms.getVaerdi() != NaN) {
            this.vaerdi = db.getVaerdi() - oms.getVaerdi();
            setBeregnet(true);

        } */ else if (getBeregnet()) {

            this.vaerdi = NaN;

        }

    }
}

/*
VO = VE * X
VO = STO - KO
VO = DB - Oms
*/