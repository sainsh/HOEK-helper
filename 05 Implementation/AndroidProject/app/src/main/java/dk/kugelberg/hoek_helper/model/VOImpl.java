package dk.kugelberg.hoek_helper.model;

import androidx.lifecycle.MutableLiveData;


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


    private MutableLiveData<Double> vaerdi = new MutableLiveData<>();
    private MutableLiveData<Boolean> erBeregnet = new MutableLiveData<>();

    public VOImpl(){
        vaerdi.setValue(NaN);
        erBeregnet.setValue(false);
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
            vaerdi.setValue(NaN);
            erBeregnet.setValue(false);
            this.xOver = xOver;
            this.voOver = voOver;
        }

        @Override
        public void initUnder(X xUnder, VO voUnder, DOMK domkUnder){
            this.xUnder = xUnder;
            this.voUnder = voUnder;
            this.domkUnder = domkUnder;
        }


    @Override
    public void setVaerdi(double vaerdi) {
        if (vaerdi < 0) {
            throw new VaerdiException();
        } else {
            this.vaerdi.setValue(vaerdi);
            setBeregnet(false);
        }
    }

    @Override
    public double getVaerdi() {
        return vaerdi.getValue();
    }

    @Override
    public void setBeregnet(boolean val) {
        this.erBeregnet.setValue(val);
    }

    @Override
    public boolean getBeregnet() {
        return erBeregnet.getValue();
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

            //VO = ((x-xOver) / domk) + voOver
        } else if (!Double.isNaN(x.getVaerdi()) && !Double.isNaN(xOver.getVaerdi()) &&
                !Double.isNaN(domk.getVaerdi()) && !Double.isNaN(voOver.getVaerdi())) {
            setVaerdi(  ((x.getVaerdi() - xOver.getVaerdi()) / domk.getVaerdi()) + voOver.getVaerdi());
            setBeregnet(true);

        }





        else if (getBeregnet()) {

            setVaerdi(NaN);
        }
        if (this.vaerdi.getValue() == NaN) this.erBeregnet.setValue(false);
    }
}