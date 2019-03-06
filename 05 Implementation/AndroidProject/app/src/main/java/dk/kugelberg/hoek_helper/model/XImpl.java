package dk.kugelberg.hoek_helper.model;

import androidx.lifecycle.MutableLiveData;

import static java.lang.Double.NaN;

public class XImpl implements X {

    /*
    VO vo;
    VE ve;
    X x1;
    X x2;
    KO ko;
    KE ke;
    VO vo1;
    VO vo2;
    DOMK domk;
    DOMK domk2;
    STO sto;
    SE se;
    */

    private MutableLiveData<VO> vo = new MutableLiveData<>();
    private MutableLiveData<VE> ve = new MutableLiveData<>();
    private MutableLiveData<X> x1 = new MutableLiveData<>();
    private MutableLiveData<X> x2 = new MutableLiveData<>();
    private MutableLiveData<KO> ko = new MutableLiveData<>();
    private MutableLiveData<KE> ke = new MutableLiveData<>();
    private MutableLiveData<VO> vo1 = new MutableLiveData<>();
    private MutableLiveData<VO> vo2 = new MutableLiveData<>();
    private MutableLiveData<DOMK> domk = new MutableLiveData<>();
    private MutableLiveData<DOMK> domk2 = new MutableLiveData<>();
    private MutableLiveData<STO> sto = new MutableLiveData<>();
    private MutableLiveData<SE> se = new MutableLiveData<>();

    private double vaerdi = NaN;
    private boolean erBeregnet = false;

    public void init(VO vo, VE ve, DOMK domk, STO sto, SE se) {
        this.vo = vo;
        this.ve = ve;
        this.domk = domk;
        this.sto = sto;
        this.se = se;
    }

    @Override
    public void init1(X x1, VO vo1){
        this.x1 = x1;
        this.vo1 = vo1;
    }

    @Override
    public void init2(X x2, VO vo2, DOMK domk2){
        this.x2 = x2;
        this.vo2 = vo2;
        this.domk2 = domk2;
    }

    @Override
    public void setBeregnet(boolean val){
        erBeregnet = val;
    }

    @Override
    public boolean getBeregnet(){
        return erBeregnet;
    }

    //start
    @Override
    public void setVaerdi(double x) {
        if (x < 0) {
            throw new NegativVaerdiException();
        } else {
            this.vaerdi = x;
            erBeregnet = false;
        }
    }

    @Override
    public double getVaerdi() {

        return vaerdi;
    }


    @Override
    public void beregn() {

        // TODO: konstruer beregner der kan regne X ud via x1 , x2, vo1, vo2, domk og domk2

        if (vo.getVaerdi() != NaN && ve.getVaerdi() != NaN) {
            this.vaerdi = vo.getVaerdi() / ve.getVaerdi();
            setBeregnet(true);

        } else if (ko.getVaerdi() != NaN && ke.getVaerdi() != NaN) {
            this.vaerdi = ko.getVaerdi() / ke.getVaerdi();
            setBeregnet(true);

        } else if (sto.getVaerdi() != NaN && se.getVaerdi() != NaN) {
            this.vaerdi = sto.getVaerdi() / se.getVaerdi();
            setBeregnet(true);

        } else if (domk.getVaerdi() != NaN && vo.getVaerdi() != NaN) {
            this.vaerdi = domk.getVaerdi() * vo.getVaerdi();
            setBeregnet(true);
        }

        else if(getBeregnet()){

            this.vaerdi = NaN;

        /*
        X = KO / KE
        X = VO / VE
        X = STO / SE
        X = DOMK * VO
        */

    }
}
}
