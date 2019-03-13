package dk.kugelberg.hoek_helper.model;

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

    private double vaerdi = NaN;
    private boolean erBeregnet = false;

    public KOImpl() {
    }

    @Override
    public void init(KE ke, X x, STO sto, VO vo) {
        this.ke = ke;
        this.x = x;
        this.sto = sto;
        this.vo = vo;
    }

    @Override
    public void initOver(X xOver, VO voOver) {
        this.xOver = xOver;
        this.voOver = voOver;
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

        // TODO: lav beregner med xOver, xUnder, voOver og voUnder

        // KO = KE * X
        if (!Double.isNaN(ke.getVaerdi()) && !Double.isNaN(x.getVaerdi())) {
            vaerdi = ke.getVaerdi() * x.getVaerdi();
            setBeregnet(true);

            // KO = STO - VO
        } else if (!Double.isNaN(sto.getVaerdi()) && !Double.isNaN(vo.getVaerdi())) {
            vaerdi = sto.getVaerdi() - vo.getVaerdi();
            setBeregnet(true);

        } else if (getBeregnet()) {
            setVaerdi(NaN);

        }

        if (vaerdi == NaN) erBeregnet = false;
    }
}
