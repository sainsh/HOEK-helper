package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

public class GROMKImpl implements GROMK {

    private X x;
    private X xOver;
    private STO sto;
    private STO stoOver;

    private double vaerdi = NaN;
    private boolean erBeregnet = false;

    public GROMKImpl() {
        vaerdi = NaN;
        erBeregnet = false;
    }

    @Override
    public void init(X x, STO sto) {
        this.x = x;
        this.sto = sto;
    }

    @Override
    public void initOver(X xOver, STO stoOver) {
        this.xOver = xOver;
        this.stoOver = stoOver;
    }

    @Override
    public void setVaerdi(double vaerdi) {
        if (vaerdi < 0) {
            throw new NegativVaerdiException();
        } else {
            this.vaerdi = vaerdi;
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
        if (!Double.isNaN(x.getVaerdi()) && !Double.isNaN(xOver.getVaerdi()) && !Double.isNaN(sto.getVaerdi()) && !Double.isNaN(stoOver.getVaerdi())) {
            double vaerdi = ((stoOver.getVaerdi() - sto.getVaerdi()) / (xOver.getVaerdi() - x.getVaerdi()));
            setVaerdi(vaerdi);
            erBeregnet = true;
        } else {
            vaerdi = Double.NaN;
            erBeregnet = false;
        }
    }
}
