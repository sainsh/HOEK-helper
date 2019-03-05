package dk.kugelberg.hoek_helper.model;

public class STOImpl implements STO {

    private double vaerdi;
    private X x;
    private KO ko;
    private VO vo;
    private STO sto;
    private SE se;

    // private GROMK gromk;
    // private SE se;
    // private AFS afs;


    @Override
    public void setVaerdi(double Vaerdi) {

    }

    @Override
    public double getVaerdi() {
        return vaerdi;
    }

    @Override
    public void beregn () {
    double sto = vo.getVaerdi() + ko.getVaerdi();
    this.vaerdi = vo.getVaerdi() + ko.getVaerdi();
    // STO = VO + KO

    this.sto = se.getVaerdi() * x.getVaerdi();
    this.vaerdi = se.getVaerdi() * x.getVaerdi();
    // STO = SE * X

    this.sto = gromk.getVaerdi() * afs.getVaerdi();
    this.vaerdi = gromk.getVaerdi() * afs.getVaerdi();
    // STO = GROMK * AFS
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
