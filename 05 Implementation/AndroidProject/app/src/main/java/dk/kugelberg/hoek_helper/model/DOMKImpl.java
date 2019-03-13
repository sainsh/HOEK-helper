package dk.kugelberg.hoek_helper.model;

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

    private double vaerdi = NaN;
    private boolean erBeregnet = false;

    public DOMKImpl() {
    }

    @Override
    public void init(VO vo, STO sto, KO ko, VE ve, X x) {
        this.vo = vo;
        this.sto = sto;
        this.ko = ko;
        this.ve = ve;
        this.x = x;
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
            vaerdi = x;
            setBeregnet(false);
        }
    }

    @Override
    public double getVaerdi() {
        return vaerdi;
    }


    @Override
    public boolean erBeregnet() {

        return erBeregnet;
    }

    @Override
    public void setBeregnet(boolean val) {
        this.erBeregnet = val;
    }

    @Override
    public boolean getBeregnet() {
        return erBeregnet;
    }

    @Override
    public void beregn() {

        //DOMK = (VO2 - VO1)/(X2 - X1) X2 = x,  X1 = xOVer, VO2 = vo, VO1 = voOver
        if (!Double.isNaN(x.getVaerdi()) && !Double.isNaN(xOver.getVaerdi()) && !Double.isNaN(vo.getVaerdi()) && !Double.isNaN(voOver.getVaerdi())) {

            vaerdi = ((voOver.getVaerdi() - vo.getVaerdi()) / (xOver.getVaerdi() - x.getVaerdi()));
            erBeregnet = true;
        } else {
            vaerdi = Double.NaN;
            erBeregnet = false;
        }
    }
}
