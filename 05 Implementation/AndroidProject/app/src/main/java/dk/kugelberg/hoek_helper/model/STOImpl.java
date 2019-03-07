package dk.kugelberg.hoek_helper.model;

import androidx.lifecycle.MutableLiveData;

import static java.lang.Double.NaN;

public class STOImpl implements STO {

    private X x;
    private VO vo;
    private KO ko;
    private SE se;
    private X xOver;
    private X xUnder;
    private VO voOver;
    private VO voUnder;
    private GROMK gromk;

    private MutableLiveData<Double> vaerdi = new MutableLiveData<>();
    private MutableLiveData<Boolean> erBeregnet = new MutableLiveData<>();

    @Override
    public void init(X x, VO vo, KO ko, SE se, GROMK gromk, X xOver, VO voOver, X xUnder, VO voUnder) {
        this.x = x;
        this.vo = vo;
        this.ko = ko;
        this.se = se;
        vaerdi.setValue(NaN);
        erBeregnet.setValue(false);
        this.xOver = xOver;
        this.voOver = voOver;
        this.xUnder = xUnder;
        this.voUnder = voUnder;
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
    public void setBeregnet(boolean val) {
        erBeregnet.setValue(val);
    }

    @Override
    public boolean getBeregnet() {
        return erBeregnet.getValue();
    }

    @Override
    public void beregn() {

        //STO = VO + KO
        if (!Double.isNaN(vo.getVaerdi()) && !Double.isNaN(ko.getVaerdi())) {
            vaerdi.setValue(vo.getVaerdi() + ko.getVaerdi());
            setBeregnet(true);

            //STO = SE * X
        } else if (!Double.isNaN(se.getVaerdi()) && !Double.isNaN(x.getVaerdi())) {
            vaerdi.setValue(se.getVaerdi() * x.getVaerdi());
            setBeregnet(true);

        } else if (getBeregnet()) {
            setVaerdi(NaN);
        }

        // TODO: undersøg hvordan STO=GROMK * X kan være rigtig???
        //this.sto = gromk.getVaerdi() * x.getVaerdi();
        //this.vaerdi = gromk.getVaerdi() * x.getVaerdi();

        if (this.vaerdi.getValue() == NaN) this.erBeregnet.setValue(false);
    }
}
