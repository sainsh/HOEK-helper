package dk.kugelberg.hoek_helper.model;

import androidx.lifecycle.MutableLiveData;

public class DOMKImpl implements DOMK {

    private VO vo;
    private VO voOver;
    private STO sto;
    private KO ko;
    private VE ve;
    private X x;
    private X xOver;
    private DOMK domkOver;
    private DOMK domkUnder;


    private MutableLiveData<Double> vaerdi = new MutableLiveData<>();
    private MutableLiveData<Boolean> erBeregnet = new MutableLiveData<>();

    @Override
    public void setVaerdi(double vaerdi) {

        this.vaerdi.setValue(vaerdi);

    }

    @Override
    public double getVaerdi() {
        return vaerdi.getValue();
    }

    @Override
    public void init(VO vo, VO voOver, STO sto, KO ko, VE ve, X x, X xOver, DOMK domkOver, DOMK domkUnder) {
        this.vo = vo;
        this.voOver = voOver;
        this.sto = sto;
        this.ko = ko;
        this.ve = ve;
        this.x = x;
        this.xOver = xOver;
        this.domkOver = domkOver;
        this.domkUnder = domkUnder;

    }

    @Override
    public boolean erBeregnet() {

        return erBeregnet.getValue();
    }

    @Override
    public void initOver(X xOver, VO voOver) {

        this.voOver = voOver;
        this.xOver = xOver;

    }

    public void initUnder(DOMK domkUnder){
        this.domkUnder = domkUnder;
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
