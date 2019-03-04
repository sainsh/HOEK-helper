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
}
