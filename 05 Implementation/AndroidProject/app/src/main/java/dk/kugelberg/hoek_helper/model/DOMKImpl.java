package dk.kugelberg.hoek_helper.model;

import androidx.lifecycle.MutableLiveData;

import static java.lang.Double.NaN;

public class DOMKImpl implements DOMK {

    private VO vo;
    private VO voOver;
    private STO sto;
    private KO ko;
    private VE ve;
    private X x;
    private X xOver;
    private DOMK domk;
    private DOMK domkOver;


    private MutableLiveData<Double> vaerdi = new MutableLiveData<>();
    private MutableLiveData<Boolean> erBeregnet = new MutableLiveData<>();

    public DOMKImpl(){
        vaerdi.setValue(NaN);
        erBeregnet.setValue(false);
    }

    @Override
    public void init(VO vo, STO sto, KO ko, VE ve, X x, DOMK domk) {
        this.vo = vo;
        this.sto = sto;
        this.ko = ko;
        this.ve = ve;
        this.x = x;
        this.domk = domk;
    }

    @Override
    public void initOver(VO voOver, X xOver, DOMK domkOver) {
        this.voOver = voOver;
        this.xOver = xOver;
        this.domkOver = domkOver;
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
    public boolean erBeregnet() {

        return erBeregnet.getValue();
    }

    @Override
    public void setBeregnet(boolean val){
        this.erBeregnet.setValue(val);
    }

    @Override
    public boolean getBeregnet(){
        return erBeregnet.getValue();
    }


    @Override
    public void beregn() {

            //DOMK = (X2-X1)/(VO2-VO1) X2 = x,  X1 = xOVer, VO2 = vo, VO1 = voOver
        if (!Double.isNaN(x.getVaerdi()) && !Double.isNaN(xOver.getVaerdi()) && !Double.isNaN(vo.getVaerdi()) && !Double.isNaN(voOver.getVaerdi())) {

            vaerdi.setValue((x.getVaerdi()-xOver.getVaerdi())/(vo.getVaerdi()-voOver.getVaerdi()));
            erBeregnet.setValue(true);
        }
        else {
            vaerdi.setValue(Double.NaN);
            erBeregnet.setValue(false);
        }
    }
}
