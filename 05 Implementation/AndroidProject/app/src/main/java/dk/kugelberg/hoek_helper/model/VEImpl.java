package dk.kugelberg.hoek_helper.model;

import androidx.lifecycle.MutableLiveData;
import static java.lang.Double.NaN;

public class VEImpl implements VE {

    private VO vo;
    private X x;
    private SE se;
    private KE ke;

    private double vaerdi = Double.NaN;
    private boolean erBeregnet = false;

    public VEImpl(){

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
            vaerdi = x;
            setBeregnet(false);
        }
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

        // VE = VO / X
        if(!Double.isNaN(x.getVaerdi()) && !Double.isNaN(vo.getVaerdi())){

            double vaerdi = (vo.getVaerdi() / x.getVaerdi());
            setVaerdi(vaerdi);
            setBeregnet(true);
        }

        // VE = SE - KE
        else if(!Double.isNaN(se.getVaerdi()) && !Double.isNaN(ke.getVaerdi())){
            double vaerdi = (se.getVaerdi() - ke.getVaerdi());
            setVaerdi(vaerdi);
            setBeregnet(true);

        }
        else if(getBeregnet()){
            setVaerdi(NaN);
        }
        if (this.vaerdi == NaN) this.erBeregnet = false;
    }
}
