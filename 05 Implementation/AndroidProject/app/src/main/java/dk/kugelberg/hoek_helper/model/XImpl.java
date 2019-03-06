package dk.kugelberg.hoek_helper.model;

import androidx.lifecycle.MutableLiveData;

import static java.lang.Double.NaN;

public class XImpl implements X {

    private VO vo;
    private VE ve;
    private X x1;
    private X x2;   //Jeg ved ikke om vi nogensinde får brug for denne?
    private KO ko;
    private KE ke;
    private VO vo1;
    private VO vo2;   //Jeg ved ikke om vi nogensinde får brug for denne?
    private DOMK domk;
    private DOMK domk2;    //Jeg ved ikke om vi nogensinde får brug for denne?
    private STO sto;
    private SE se;
    private GROMK gromk;

    private MutableLiveData<Double> vaerdi = new MutableLiveData<>();
    private MutableLiveData<Boolean> erBeregnet = new MutableLiveData<>();

    @Override
    public void init(VO vo, VE ve, DOMK domk, STO sto, SE se, GROMK gromk) {
        this.vo = vo;
        this.ve = ve;
        this.domk = domk;
        this.sto = sto;
        this.se = se;
        this.gromk = gromk;
        vaerdi.setValue(NaN);
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
        erBeregnet.setValue(val);
    }

    @Override
    public boolean getBeregnet(){
        return erBeregnet.getValue();
    }

    //start
    @Override
    public void setVaerdi(double x) {
        if (x < 0) {
            throw new NegativVaerdiException();
        } else {
            vaerdi.setValue(x);
            setBeregnet(false);
        }
    }

    @Override
    public double getVaerdi() {

        return vaerdi.getValue();
    }


    @Override
    public void beregn() {

        // X = VO / VE
        if (vo.getVaerdi() != NaN && ve.getVaerdi() != NaN) {
            setVaerdi(vo.getVaerdi() / ve.getVaerdi());
            setBeregnet(true);

            // X = KO / KE
        } else if (ko.getVaerdi() != NaN && ke.getVaerdi() != NaN) {
            setVaerdi(ko.getVaerdi() / ke.getVaerdi());
            setBeregnet(true);

            // X = STO / SE
        } else if (sto.getVaerdi() != NaN && se.getVaerdi() != NaN) {
            setVaerdi(sto.getVaerdi() / se.getVaerdi());
            setBeregnet(true);

            // X = STO / GROMK
        } else if (sto.getVaerdi() != NaN && gromk.getVaerdi() != NaN) {
            setVaerdi(sto.getVaerdi() * gromk.getVaerdi());
            setBeregnet(true);

            // X = (domk * ( vo - vo1)) + x1
        } else if (domk.getVaerdi() != NaN && vo.getVaerdi() != NaN && vo1.getVaerdi() != NaN && x1.getVaerdi() != NaN) {
            setVaerdi( (domk.getVaerdi() * ( vo.getVaerdi() - vo1.getVaerdi())) + x1.getVaerdi() );
            setBeregnet(true);
        }

        else if(getBeregnet()){

            setVaerdi(NaN);

    }
}
}