package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

public class VEImpl implements VE {

    private VO vo;
    private X x;
    private SE se;
    private KE ke;

    private double vaerdi;
    private boolean erBeregnet = false;

    public void setVaerdi(double vaerdi){
        this.vaerdi = vaerdi;
    }

    public double getVaerdi(){
        return vaerdi;
    }

    public void setBeregnet(boolean val){
        erBeregnet = val;
    }

    private boolean getBeregnet(){
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

    }

}
