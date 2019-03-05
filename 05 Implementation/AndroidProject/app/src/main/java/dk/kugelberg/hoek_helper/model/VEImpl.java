package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

public class VEImpl implements VE {

     VO vo;
     X x;
     SE se;
     KE ke;

    private double vaerdi;
    private boolean erBeregnet = false;

    public void init(VO vo, X x, SE se, KE ke){
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
            this.vaerdi = x;
            erBeregnet = false;
        }
    }

    @Override
    public double getVaerdi() {

        return vaerdi;
    }

    public void setBeregnet(boolean val){
        erBeregnet = val;
    }

    public boolean getBeregnet(){
        return erBeregnet;
    }

    @Override
    public void beregn() {

        if(x.getVaerdi() != NaN && vo.getVaerdi() != NaN){

            this.vaerdi = vo.getVaerdi() / x.getVaerdi();
            setBeregnet(true);

        }
        else if(se.getVaerdi() != NaN && ke.getVaerdi() != NaN){

            this.vaerdi = se.getVaerdi() - ke.getVaerdi();
            setBeregnet(true);

        }
        else if(getBeregnet()){

            this.vaerdi = NaN;

        }

       // VE = VO / X
       // VE = SE - KE

    }

}
