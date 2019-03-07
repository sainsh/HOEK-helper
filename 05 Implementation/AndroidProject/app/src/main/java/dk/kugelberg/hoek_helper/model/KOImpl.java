package dk.kugelberg.hoek_helper.model;

import androidx.lifecycle.MutableLiveData;
import static java.lang.Double.NaN;

public class KOImpl implements KO {

    private KE ke;
    private X x;
    private STO sto;
    private VO vo;
    private X xOver;
    private VO voOver;
    private X xUnder;
    private VO voUnder;

    private MutableLiveData<Double> vaerdi = new MutableLiveData<>();
    private MutableLiveData<Boolean> erBeregnet = new MutableLiveData<>();

    @Override
    public void init(KE ke, X x, STO sto, VO vo, X xOver, VO voOver, X xUnder, VO voUnder) {
        this.ke = ke;
        this.x = x;
        this.sto = sto;
        this.vo = vo;
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

        // TODO: lav beregner med xOver, xUnder, voOver og voUnder

        // KO = KE * X
        if (ke.getVaerdi() != NaN && x.getVaerdi() != NaN) {
            vaerdi.setValue(ke.getVaerdi() * x.getVaerdi());
            setBeregnet(true);

        // KO = STO - VO
        } else if (sto.getVaerdi() != NaN && vo.getVaerdi() != NaN) {
            vaerdi.setValue(sto.getVaerdi() - vo.getVaerdi());
            setBeregnet(true);

        } else if (getBeregnet()) {
            setVaerdi(NaN);

        }
    }
}
