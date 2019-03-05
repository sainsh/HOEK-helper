package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

public class XImpl implements X {

    private VO vo;
    private VE ve;
    private X x1;
    private X x2;
    private KO ko;
    private KE ke;
    private VO vo1;
    private VO vo2;
    private DOMK domk;
    private DOMK domk2;
    private STO sto;
    private SE se;
    private GROMK gromk;

    private double vaerdi = NaN;
    private boolean erBeregnet = false;

    @Override
    public void init(VO vo, VE ve, DOMK domk, STO sto, SE se, GROMK gromk) {
        this.vo = vo;
        this.ve = ve;
        this.domk = domk;
        this.sto = sto;
        this.se = se;
        this.gromk = gromk;
    }

    @Override
    public void init1(X x1, VO vo1){
        this.x1 = x1;
        this.vo1 = vo1;
    }

    @Override
    public void init2(X x2, VO vo2, DOMK domk2){
        this.x2 = x2;
        this.vo2 = vo2;
        this.domk2 = domk2;
    }

    @Override
    public void setBeregnet(boolean val){
        erBeregnet = val;
    }

    @Override
    public boolean getBeregnet(){
        return erBeregnet;
    }

    //start
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
    public void beregn() {

        // TODO: konstruer beregner der kan regne X ud via x1 , x2, vo1, vo2, domk og domk2

        // X = VO / VE
        if (vo.getVaerdi() != NaN && ve.getVaerdi() != NaN) {
            this.vaerdi = vo.getVaerdi() / ve.getVaerdi();
            setBeregnet(true);

            // X = KO / KE
        } else if (ko.getVaerdi() != NaN && ke.getVaerdi() != NaN) {
            this.vaerdi = ko.getVaerdi() / ke.getVaerdi();
            setBeregnet(true);

            // X = STO / SE
        } else if (sto.getVaerdi() != NaN && se.getVaerdi() != NaN) {
            this.vaerdi = sto.getVaerdi() / se.getVaerdi();
            setBeregnet(true);

            // X = DOMK * VO
        } else if (domk.getVaerdi() != NaN && vo.getVaerdi() != NaN) {
            this.vaerdi = domk.getVaerdi() * vo.getVaerdi();
            setBeregnet(true);

            // X = STO / GROMK
        } else if (sto.getVaerdi() != NaN && gromk.getVaerdi() != NaN) {
            this.vaerdi = sto.getVaerdi() * gromk.getVaerdi();
            setBeregnet(true);

            // X = (domk * ( vo - vo1)) + x1
        } else if (domk.getVaerdi() != NaN && vo.getVaerdi() != NaN && vo1.getVaerdi() != NaN && x1.getVaerdi() != NaN) {
            this.vaerdi = (domk.getVaerdi() * ( vo.getVaerdi() - vo1.getVaerdi())) + x1.getVaerdi();
            setBeregnet(true);
        }


        else if(getBeregnet()){

            setVaerdi(NaN);

    }
}
}
