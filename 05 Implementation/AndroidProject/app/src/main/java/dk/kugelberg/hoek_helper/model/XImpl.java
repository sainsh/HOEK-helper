package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

public class XImpl implements X {

    private VO vo;
    private VE ve;
    private X xOver;
    private X xUnder;
    private KO ko;
    private KE ke;
    private VO voOver;
    private VO voUnder;
    private DOMK domk;
    private DOMK domkUnder;
    private STO sto;
    private SE se;
    private GROMK gromk;

    private double vaerdi = NaN;
    private boolean erBeregnet = false;


    public XImpl() {
    }

    @Override
    public void init(VO vo, VE ve, DOMK domk, STO sto, SE se, GROMK gromk, KO ko, KE ke) {
        this.vo = vo;
        this.ve = ve;
        this.domk = domk;
        this.sto = sto;
        this.se = se;
        this.gromk = gromk;
        this.ko = ko;
        this.ke = ke;
    }

    @Override
    public void initOver(X xOver, VO voOver) {
        this.xOver = xOver;
        this.voOver = voOver;
    }

    @Override
    public void initUnder(X xUnder, VO voUnder, DOMK domkUnder) {
        this.xUnder = xUnder;
        this.voUnder = voUnder;
        this.domkUnder = domkUnder;
    }

    @Override
    public void setBeregnet(boolean val) {
        erBeregnet = val;
    }

    @Override
    public boolean getBeregnet() {
        return erBeregnet;
    }

    //start
    @Override
    public void setVaerdi(double x) {
        if (x < 0) {
            throw new NegativVaerdiException();
        } else {
            x = Math.floor(x);
            vaerdi = x;
            setBeregnet(false);
        }
    }

    @Override
    public double getVaerdi() {

        return vaerdi;
    }

    @Override
    public void beregn() {

        // X = VO / VE
        if (!Double.isNaN(vo.getVaerdi()) && !Double.isNaN(ve.getVaerdi())) {
            setVaerdi(vo.getVaerdi() / ve.getVaerdi());
            setBeregnet(true);

            // X = KO / KE
        } else if (!Double.isNaN(ko.getVaerdi()) && !Double.isNaN(ke.getVaerdi())) {
            setVaerdi(ko.getVaerdi() / ke.getVaerdi());
            setBeregnet(true);

            // X = STO / SE
        } else if (!Double.isNaN(sto.getVaerdi()) && !Double.isNaN(se.getVaerdi())) {
            setVaerdi(sto.getVaerdi() / se.getVaerdi());
            setBeregnet(true);

            // X = STO / GROMK
        } else if (!Double.isNaN(sto.getVaerdi()) && !Double.isNaN(gromk.getVaerdi())) {
            setVaerdi(sto.getVaerdi() * gromk.getVaerdi());
            setBeregnet(true);

            // X = (domk * ( vo - voOver)) + xOver
        } else if (!Double.isNaN(domk.getVaerdi()) && !Double.isNaN(vo.getVaerdi()) && !Double.isNaN(voOver.getVaerdi()) && !Double.isNaN(xOver.getVaerdi())) {
            setVaerdi((domk.getVaerdi() * (vo.getVaerdi() - voOver.getVaerdi())) + xOver.getVaerdi());
            setBeregnet(true);

        } else if (getBeregnet()) {
            setVaerdi(NaN);
        }
        if (vaerdi == NaN) erBeregnet = false;
    }
}