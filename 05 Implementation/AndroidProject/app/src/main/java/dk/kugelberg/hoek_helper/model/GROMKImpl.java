package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

public class GROMKImpl implements GROMK {

    private VE ve;
    private X x;
    private X x1;
    private X x2;
    private KO ko;
    private VO vo1;
    private VO vo2;
    private DOMK domk;
    private DOMK domk2;
    private STO sto;
    private SE se;


    private double vaerdi = NaN;
    private boolean erBeregnet = false;

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
    public void init1(X x1, VO vo1) {
        this.x1 = x1;
        this.vo1 = vo1;
    }

    @Override
    public void init2(X x2, VO vo2, DOMK domk2) {
        this.x2 = x2;
        this.vo2 = vo2;
        this.domk2 = domk2;
    }

    @Override
    public void setVaerdi(double vaerdi) {
        if (vaerdi < 0) {
            throw new VaerdiException();
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
    public void setBeregnet(boolean val){
        erBeregnet = val;
    }

    @Override
    public boolean getBeregnet(){
        return erBeregnet;
    }

    @Override
    public void beregn() {

        // TODO: lav alle beregningerne til GROMK

        //if (this.vaerdi.getValue() == NaN) this.erBeregnet.setValue(false);

    }
}
