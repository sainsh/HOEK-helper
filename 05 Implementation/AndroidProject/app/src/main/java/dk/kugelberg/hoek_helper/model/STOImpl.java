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
    private STO stoOver;
    private GROMK gromk;

    private double vaerdi = NaN;
    private boolean erBeregnet = false;

    public STOImpl() {
    }

    @Override
    public void init(X x, VO vo, KO ko, SE se, GROMK gromk) {
        this.x = x;
        this.vo = vo;
        this.ko = ko;
        this.se = se;
        this.gromk = gromk;
    }

    @Override
    public void initOver(X xOver, VO voOver, STO stoOver) {
        this.xOver = xOver;
        this.voOver = voOver;
        this.stoOver = stoOver;
    }

    @Override
    public void initUnder(X xUnder, VO voUnder) {
        this.xUnder = xUnder;
        this.voUnder = voUnder;
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
    public void setBeregnet(boolean val) {
        erBeregnet = val;
    }

    @Override
    public boolean getBeregnet() {
        return erBeregnet;
    }

    @Override
    public void beregn() {

        //STO = VO + KO
        if (!Double.isNaN(vo.getVaerdi()) && !Double.isNaN(ko.getVaerdi())) {
            double vaerdi = vo.getVaerdi() + ko.getVaerdi();
            setVaerdi(vaerdi);
            setBeregnet(true);

            //STO = SE * X
        } else if (!Double.isNaN(se.getVaerdi()) && !Double.isNaN(x.getVaerdi())) {
            double vaerdi = se.getVaerdi() * x.getVaerdi();
            setVaerdi(vaerdi);
            setBeregnet(true);

        } else if (!Double.isNaN(se.getVaerdi()) && !Double.isNaN(x.getVaerdi())) {
            vaerdi = (gromk.getVaerdi()*-1)*xOver.getVaerdi()+gromk.getVaerdi()*x.getVaerdi()+stoOver.getVaerdi();
            setVaerdi(vaerdi);
            setBeregnet(true);

    }

        else if (getBeregnet()) {
            setVaerdi(NaN);
        }




        if (vaerdi == NaN) erBeregnet = false;
    }
}