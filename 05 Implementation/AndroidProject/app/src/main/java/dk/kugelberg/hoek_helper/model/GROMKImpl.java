package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;
import androidx.lifecycle.MutableLiveData;

public class GROMKImpl implements GROMK {

    private VE ve;
    private X x;
    private X xOver;
    private X xUnder;
    private KO ko;
    private VO voOver;
    private VO voUnder;
    private DOMK domk;
    private DOMK domkUnder;
    private STO sto;
    private SE se;


    private MutableLiveData<Double> vaerdi = new MutableLiveData<>();
    private MutableLiveData<Boolean> erBeregnet = new MutableLiveData<>();

    public GROMKImpl(){
        vaerdi.setValue(NaN);
        erBeregnet.setValue(false);
    }

    @Override
    public void init(VE ve, X x, KO ko, DOMK domk, STO sto, SE se) {
        this.ve = ve;
        this.x = x;
        this.ko = ko;
        this.domk = domk;
        this.sto = sto;
        this.se = se;
    }

    @Override
    public void initOver(X xOver, VO voOver) {
        this.xOver = xOver;
        this.voOver = voOver;
    }

    @Override
    public void initUnder(X xUnder, VO voUnder, DOMK domkUnder) {
        this.xUnder = xUnder;
        this.voUnder = voUnder;
        this.domkUnder = domkUnder;
    }

    @Override
    public void setVaerdi(double vaerdi) {
        if (vaerdi < 0) {
            throw new VaerdiException();
        } else {
            this.vaerdi.setValue(vaerdi);
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

        // TODO: lav alle beregningerne til GROMK

        /*
        GROMK findes ved at differentiere formlen for VO

        Formlen for VO ser således ud:  VO = a*(x*x) + b*x + c
        VO vil altid være en parabel da x ikke må være negativ
        og c er altid 0 da HØKerne ikke har komplicerede formler

        kender vi ikke formlen for VO men har 3 punkter af VO og x (Hvor x'erne er forskellige)
        kan vi udlede formlen for VO som følger:

        vo1 = 1
        vo2 = 2
        vo3 = 3
        x1 = 1
        x2 = 2
        x3 = 3

        vo = (((x-x2)*(x-x3)) / ((x1-x2)*(x1-x3)) * y1 * (((x-x1)*(x-x3)) / ((x2-x1)*(x2-x3)) * y2 * (((x-x1)*(x-x2)) / ((x3-x1)*(x3-x2)) * y3





        */

        //if (this.vaerdi.getValue() == NaN) this.erBeregnet.setValue(false);

    }
}
