package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

public class VOImpl implements VO {

    private VE ve;
    private X x;
    private X xOver;
    private X xUnder;
    private KO ko;
    private VO voOver;
    private VO voUnder;
    private DOMK domk;
    private DOMK domkUnder;
    private STO sto;
    private SE se;
    private DB db;
    private OMS oms;


    private double vaerdi = NaN;
    private boolean erBeregnet = false;

    public VOImpl() {
    }

    @Override
    public void init(VE ve, X x, KO ko, DOMK domk, STO sto, SE se, DB db, OMS oms) {
        this.ve = ve;
        this.x = x;
        this.ko = ko;
        this.domk = domk;
        this.sto = sto;
        this.se = se;
        this.db = db;
        this.oms = oms;
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
    public void setBeregnet(boolean val) {
        erBeregnet = val;
    }

    @Override
    public boolean getBeregnet() {
        return erBeregnet;
    }

    @Override
    public void beregn() {

        //VO = VE * X
        if (!Double.isNaN(ve.getVaerdi()) && !Double.isNaN(x.getVaerdi())) {
            setVaerdi(ve.getVaerdi() * x.getVaerdi());
            setBeregnet(true);

            //VO = STO - KO
        } else if (!Double.isNaN(sto.getVaerdi()) && !Double.isNaN(ko.getVaerdi())) {
            setVaerdi(sto.getVaerdi() - ko.getVaerdi());
            setBeregnet(true);

            //VO = DB - Oms
        } else if (!Double.isNaN(db.getVaerdi()) && !Double.isNaN(oms.getVaerdi())) {
            setVaerdi(db.getVaerdi() - oms.getVaerdi());
            setBeregnet(true);

            //VO2 = DOMK * (X2 - X1) + VO1
        } else if (!Double.isNaN(x.getVaerdi()) && !Double.isNaN(xOver.getVaerdi()) &&
                !Double.isNaN(domk.getVaerdi()) && !Double.isNaN(voOver.getVaerdi())) {
            setVaerdi(domk.getVaerdi() * (x.getVaerdi() - xOver.getVaerdi()) + voOver.getVaerdi());
            setBeregnet(true);

        } else if (getBeregnet()) {
            setVaerdi(NaN);
        }
        if (vaerdi == NaN) erBeregnet = false;
    }
}
/*
                                raekke.getSTO().init(raekke.getX(),raekke.getVO(),raekke.getKO(),raekke.getSE(),raekke.getGROMK());
                                raekke.getKO().init(raekke.getKE(),raekke.getX(),raekke.getSTO(),raekke.getVO());
                                raekke.getDOMK().init(raekke.getVO(), raekke.getSTO(), raekke.getKO(), raekke.getVE(), raekke.getX());
                                raekke.getX().init(raekke.getVO(),raekke.getVE(),raekke.getDOMK(),raekke.getSTO(),raekke.getSE(),raekke.getGROMK(),raekke.getKO(),raekke.getKE());
                                raekke.getVE().init(raekke.getVO(), raekke.getX(), raekke.getSE(), raekke.getKE());
                                raekke.getVO().init(raekke.getVE(),raekke.getX(),raekke.getKO(),raekke.getDOMK(),raekke.getSTO(),raekke.getSE(),raekke.getDB(),raekke.getOMS());
                                raekke.getSE().init(raekke.getX(),raekke.getSTO(),raekke.getVE(),raekke.getKE());
                                raekke.getKE().init(raekke.getKO(),raekke.getX(),raekke.getSE(),raekke.getVE());
                                raekke.getGROMK().init(raekke.getX(),raekke.getSTO());

                                 */