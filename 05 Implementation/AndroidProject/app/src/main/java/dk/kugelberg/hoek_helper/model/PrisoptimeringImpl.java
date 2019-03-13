package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

public class PrisoptimeringImpl implements Prisoptimering {

    private VE ve;
    private X x;
    private X xOver;
    private X xUnder;
    private KO ko;
    private VO vo;
    private VO voOver;
    private VO voUnder;
    private DOMK domk;
    private DOMK domkUnder;
    private STO sto;
    private SE se;

    private double vaerdi = NaN;
    private boolean erBeregnet = false;

    public PrisoptimeringImpl() {
        vaerdi = NaN;
        erBeregnet = false;
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


    /**
     * GROMK kan findes på 2 måder
     * enten ved at differentiere formlen for VO
     * <p>
     * Formlen for VO er en normal andengrads ligning der ser således ud:
     * VO = a*(x*x) + b*x + c
     * VO vil altid være en parabel da x ikke må være negativ
     * og det lader til at c altid 0 for HØK'erne
     * <p>
     * ELLER hvis vi ikke kender VO formlen
     * kan vi vinde GROMK ud fra 3 punkter af VO og x (Hvor x'erne er forskellige)
     * kan vi finde a, b og c i ovenstående formel således:
     * <p>
     * vo1 og x1
     * vo2 og x2
     * vo3 og x3
     * <p>
     * a = vo1 / ((x1-x2)*(x1-x3)) + vo2 / ((x2-x1)*(x2-x3)) + vo3 / ((x3-x1)*(x3-x2))
     * b = -vo1*(x2+x3)/((x1-x2)*(x1-x3)) - vo2 *(x1+x3)/((x2-x1)*(x2-x3)) - vo3 *(x1+x2)/((x3-x1)*(x3-x2))
     * c = vo1*x2*x3/((x1-x2)*(x1-x3)) + vo2*x1*x3 / ((x2-x1)*(x2-x3)) + vo3*x1*x2 / ((x3-x1)*(x3-x2))
     * <p>
     * Nu hvor vi har a b og c på plads kan vi differentiere formlen.
     * Det gøres således:
     * <p>
     * GROMK =  (2*a) * x + b + c   = voDifferentieret
     * <p>
     * når dette er klaret har vi fundet GROMK
     * VODifferentieret = GROMK
     */

    @Override
    public void beregn() {

        double vo1 = voOver.getVaerdi();
        double vo2 = vo.getVaerdi();
        double vo3 = voUnder.getVaerdi();

        double x1 = xOver.getVaerdi();
        double x2 = x.getVaerdi();
        double x3 = xUnder.getVaerdi();


        // Her beregnes GROMK ud fra 3 punkter på parablen
        // Først tjekkes derfor om der er 3 VO-værdier og 3 X-værdier

        if ((vo1 != vo2) && (vo1 != vo3) && (vo2 != vo3)) {
            if ((x1 != x2) && (x1 != x3) && (x2 != x3)) {


                if (!Double.isNaN(vo1) && !Double.isNaN(vo2) && !Double.isNaN(vo3) && !Double.isNaN(x1) && !Double.isNaN(x2) && !Double.isNaN(x3)) {

                    double a = vo1 / ((x1 - x2) * (x1 - x3)) + vo2 / ((x2 - x1) * (x2 - x3)) + vo3 / ((x3 - x1) * (x3 - x2));
                    double b = -vo1 * (x2 + x3) / ((x1 - x2) * (x1 - x3)) - vo2 * (x1 + x3) / ((x2 - x1) * (x2 - x3)) - vo3 * (x1 + x2) / ((x3 - x1) * (x3 - x2));
                    double c = vo1 * x2 * x3 / ((x1 - x2) * (x1 - x3)) + vo2 * x1 * x3 / ((x2 - x1) * (x2 - x3)) + vo3 * x1 * x2 / ((x3 - x1) * (x3 - x2));

                    setVaerdi(a * 2 * x.getVaerdi() + b + c);
                    setBeregnet(true);
                }
            }
        }

        if (vaerdi == NaN) erBeregnet = false;

    }
}
