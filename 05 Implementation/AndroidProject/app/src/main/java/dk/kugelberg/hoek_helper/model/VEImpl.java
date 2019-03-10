package dk.kugelberg.hoek_helper.model;

import androidx.lifecycle.MutableLiveData;
import static java.lang.Double.NaN;

public class VEImpl implements VE {

    private VO vo;
    private X x;
    private SE se;
    private KE ke;

    private MutableLiveData<Double> vaerdi = new MutableLiveData<>();
    private MutableLiveData<Boolean> erBeregnet = new MutableLiveData<>();

    public VEImpl(){
        vaerdi.setValue(NaN);
        erBeregnet.setValue(false);
    }

    @Override
    public void init(VO vo, X x, SE se, KE ke){
        this.vo = vo;
        this.x = x;
        this.se = se;
        this.ke = ke;
    }

    @Override
    public boolean kanBeregnes(VO vo, X x, SE se, KE ke){
        // VE = VO / X
        if(!Double.isNaN(x.getVaerdi()) && !Double.isNaN(vo.getVaerdi())){ return true; }

        // VE = SE - KE
        else if(!Double.isNaN(se.getVaerdi()) && !Double.isNaN(ke.getVaerdi())){ return true; }

        return false;
    }

    @Override
    public void setVaerdi(double x) {
        if (x < 0) {
            throw new NegativVaerdiException();
        } else {
            vaerdi.setValue(x);
            setBeregnet(false);
        }
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

        // VE = VO / X
        if(!Double.isNaN(x.getVaerdi()) && !Double.isNaN(vo.getVaerdi())){

            vaerdi.setValue(vo.getVaerdi() / x.getVaerdi());
            setBeregnet(true);
        }

        // VE = SE - KE
        else if(!Double.isNaN(se.getVaerdi()) && !Double.isNaN(ke.getVaerdi())){
            vaerdi.setValue(se.getVaerdi() - ke.getVaerdi());
            setBeregnet(true);

        }
        else if(getBeregnet()){
            setVaerdi(NaN);
        }
        if (this.vaerdi.getValue() == NaN) this.erBeregnet.setValue(false);
    }
}
