package dk.kugelberg.hoek_helper.model;

import androidx.lifecycle.MutableLiveData;

import static java.lang.Double.NaN;

public class SEImpl implements SE {

    private X x;
    private STO sto;
    private VE ve;
    private KE ke;

    private double vaerdi = NaN;
    private boolean erBeregnet = false;

    public SEImpl() {
    }

    @Override
    public void init(X x, STO sto, VE ve, KE ke) {
        this.x = x;
        this.sto = sto;
        this.ve = ve;
        this.ke = ke;
    }

    @Override
    public void setVaerdi(double x) {
        this.vaerdi = x;
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

        //SE = STO / X
        if (!Double.isNaN(sto.getVaerdi()) && !Double.isNaN(x.getVaerdi())) {
            setVaerdi(sto.getVaerdi() / x.getVaerdi());
            setBeregnet(true);

            //SE = VE + KE
        } else if (!Double.isNaN(ve.getVaerdi()) && !Double.isNaN(ke.getVaerdi())) {
            setVaerdi(ve.getVaerdi() + ke.getVaerdi());
            setBeregnet(true);

        } else if (getBeregnet()) {
            setVaerdi(NaN);

        }

        if (vaerdi == NaN) erBeregnet = false;
    }
}