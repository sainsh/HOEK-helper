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


    @Override
    public void setvaerdi(double Vaerdi) {
    }

    @Override
    public void getvaerdi() {
    }

    @Override
    public void beregn() {
        if (sto.getVaerdi() != NaN && x.getVaerdi() != NaN) {

        }
    }
}
