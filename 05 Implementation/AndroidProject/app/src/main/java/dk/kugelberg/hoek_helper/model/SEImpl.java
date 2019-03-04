package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

public class SEImpl {
    private double vaerdi;
    private SE se;
    private STO sto;
    private X x;
    private VE ve;
    private KE ke;

    private boolean erBeregnet = false;

    public void setBeregnet(boolean val){
        erBeregnet = val;
    }

    private boolean getBeregnet(){
        return erBeregnet;
    }

    @Override
    public void setvaerdi(double Vaerdi) {
    }

    @Override
    public void getvaerdi() {
    }

    @Override
    public void beregn() {
        if (sto.getVaerdi() != NaN && x.getVaerdi() != NaN) {
            this.vaerdi = sto.getVaerdi() / x.getVaerdi();
            setBeregnet(true);

            else if (ve.getVaerdi() != NaN && ke.getVaerdi() != NaN) {
                this.vaerdi = ve.getVaerdi() + ke.getVaerdi();
                setBeregnet(true);

                else if (getBeregnet()) {

                    this.vaerdi = NaN;
                }
            }
        }
    }
}
