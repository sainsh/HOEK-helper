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

    @Override
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
        if(x.getVaerdi() != NaN && vo.getVaerdi() != NaN){

            vaerdi.setValue(vo.getVaerdi() / x.getVaerdi());
            setBeregnet(true);
        }

        // VE = SE - KE
        else if(se.getVaerdi() != NaN && ke.getVaerdi() != NaN){

            vaerdi.setValue(se.getVaerdi() - ke.getVaerdi());
            setBeregnet(true);

        }
        else if(getBeregnet()){

            setVaerdi(NaN);

        }


    }

}
