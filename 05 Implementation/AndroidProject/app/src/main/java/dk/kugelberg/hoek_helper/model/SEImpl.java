package dk.kugelberg.hoek_helper.model;

import androidx.lifecycle.MutableLiveData;
import static java.lang.Double.NaN;

public class SEImpl implements SE {

    private X x;
    private STO sto;
    private VE ve;
    private KE ke;

    private MutableLiveData<Double> vaerdi = new MutableLiveData<>();
    private MutableLiveData<Boolean> erBeregnet = new MutableLiveData<>();

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
        return vaerdi.getValue();
    }

    @Override
    public void setBeregnet(boolean val){
        erBeregnet.setValue(val);
    }

    @Override
    public boolean getBeregnet(){
        return erBeregnet.getValue();
    }

    @Override
    public void beregn() {

        //SE = STO / X
        if (!Double.isNaN(sto.getVaerdi()) && x.getVaerdi() != NaN) {
            setVaerdi(sto.getVaerdi() / x.getVaerdi());
            setBeregnet(true);

            //SE = VE + KE
        } else if (ve.getVaerdi() != NaN && ke.getVaerdi() != NaN) {
            setVaerdi(ve.getVaerdi() + ke.getVaerdi());
            setBeregnet(true);

        } else if (getBeregnet()) {
            setVaerdi(NaN);

        }

        if (this.vaerdi.getValue() == NaN) this.erBeregnet.setValue(false);
    }
}


