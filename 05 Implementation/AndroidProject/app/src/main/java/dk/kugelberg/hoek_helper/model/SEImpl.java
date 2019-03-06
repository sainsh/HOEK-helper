package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

public class SEImpl implements SE {

    private X x;
    private STO sto;
    private VE ve;
    private KE ke;

    private double vaerdi = NaN;
    private boolean erBeregnet = false;

    @Override
    public void init(X x, STO sto, VE ve, KE ke) {
        this.x = x;
        this.sto = sto;
        this.ve = ve;
        this.ke = ke;
    }

    @Override
    public void setVaerdi(double x) {
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
        if (sto.getVaerdi() != NaN && x.getVaerdi() != NaN) {
            this.vaerdi = sto.getVaerdi() / x.getVaerdi();
            setBeregnet(true);

        } else if (ve.getVaerdi() != NaN && ke.getVaerdi() != NaN) {
            this.vaerdi = ve.getVaerdi() + ke.getVaerdi();
            setBeregnet(true);

        } else if (getBeregnet()) {
            setVaerdi(NaN);

/*
SE = STO / X
SE = VE + KE
*/
        }
    }
}


