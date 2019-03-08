package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

import androidx.lifecycle.MutableLiveData;

public class GROMKImpl implements GROMK {

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


    private MutableLiveData<Double> vaerdi = new MutableLiveData<>();
    private MutableLiveData<Boolean> erBeregnet = new MutableLiveData<>();

    public GROMKImpl() {
        vaerdi.setValue(NaN);
        erBeregnet.setValue(false);
    }

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
        erBeregnet.setValue(val);
    }

    @Override
    public boolean getBeregnet() {
        return erBeregnet.getValue();
    }

    @Override
    public void beregn() {

        /*
        GROMK findes ved at differentiere formlen for VO

        Formlen for VO er en normal andengrads ligning der ser således ud:

        VO = a*(x*x) + b*x + c

        VO vil altid være en parabel da x ikke må være negativ
        og det lader til at c altid 0 for HØK'erne

        kender vi ikke formlen for VO men har 3 punkter af VO og x (Hvor x'erne er forskellige)
        kan vi finde a, b og c i ovenstående formel således:

        vo1 og x1
        vo2 og x2
        vo3 og x3

        a = vo1 / ((x1-x2)*(x1-x3)) + vo2 / ((x2-x1)*(x2-x3)) + vo3 / ((x3-x1)*(x3-x2))

        b = -vo1*(x2+x3)/((x1-x2)*(x1-x3)) - vo2 *(x1+x3)/((x2-x1)*(x2-x3)) - vo3 *(x1+x2)/((x3-x1)*(x3-x2))

        c = vo1*x2*x3/((x1-x2)*(x1-x3)) + vo2*x1*x3 / ((x2-x1)*(x2-x3)) + vo3*x1*x2 / ((x3-x1)*(x3-x2))

        Nu hvor vi har a b og c på plads kan vi differentiere formlen.

        Det gøres således:

        VODifferentieret =  (2*a) * x + b + c

        når dette er klaret har vi fundet GROMK

        VODifferentieret = GROMK

        */


        //if (this.vaerdi.getValue() == NaN) this.erBeregnet.setValue(false);

    }
}
