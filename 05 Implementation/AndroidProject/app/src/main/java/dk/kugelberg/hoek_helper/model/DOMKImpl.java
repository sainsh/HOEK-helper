package dk.kugelberg.hoek_helper.model;

public class DOMKImpl implements DOMK {

    private VO vo1;
    private VO vo2;
    private STO sto;
    private KO ko;
    private VE ve;
    private X x1;
    private X x2;
    private DOMK domk1;
    private DOMK domk2;
    private double vaerdi = Double.NaN;
    private boolean erBeregnet = false;

    @Override
    public void setVaerdi(double vaerdi) {
        this.vaerdi = vaerdi;
    }

    @Override
    public double getVaerdi() {
        return vaerdi;
    }

    @Override
    public void beregn() {

    }

    @Override
    public void init(VO vo1, VO vo2, STO sto, KO ko, VE ve, X x1, X x2, DOMK domk1, DOMK domk2) {

    }

    @Override
    public boolean erBeregnet() {

        return false;
    }
}
