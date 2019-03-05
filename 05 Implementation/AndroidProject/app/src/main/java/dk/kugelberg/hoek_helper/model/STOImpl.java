package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

public class STOImpl implements STO {

    private X x;
    private VO vo;
    private KO ko;
    private SE se;
    private X x1;
    private X x2;
    private VO vo1;
    private VO vo2;
    // GROMK gromk;

    private double vaerdi = NaN;
    private boolean erBeregnet = false;



    public void init(X x, VO vo, KO ko, SE se) {
        this.x = x;
        this.vo = vo;
        this.ko = ko;
        this.se = se;
    }

    @Override
    public void init1(X x1, VO vo1) {
        this.x1 = x1;
        this.vo1 = vo1;
    }

    @Override
    public void init2(X x2, VO vo2) {
        this.x2 = x2;
        this.vo2 = vo2;
    }

    @Override
    public void setVaerdi(double x) {
        if (x < 0) {
            throw new NegativVaerdiException();
        } else {
            this.vaerdi = x;
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

        if (vo.getVaerdi() != NaN && ko.getVaerdi() != NaN) {
            this.vaerdi = vo.getVaerdi() + ko.getVaerdi();
            setBeregnet(true);

        } else if (se.getVaerdi() != NaN && x.getVaerdi() != NaN) {
            this.vaerdi = se.getVaerdi() * x.getVaerdi();
            setBeregnet(true);
        } else if (getBeregnet()) {

            setVaerdi(NaN);

            // TODO: undersøg hvordan STO=GROMK * X kan være rigtig???
            //this.sto = gromk.getVaerdi() * x.getVaerdi();
            //this.vaerdi = gromk.getVaerdi() * x.getVaerdi();

        /*
        STO = VO + KO
        STO = SE * X
        STO = GROMK * X
         */
        }
    }
}
