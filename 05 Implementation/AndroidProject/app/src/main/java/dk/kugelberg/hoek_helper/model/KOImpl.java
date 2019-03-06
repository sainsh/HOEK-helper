package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;

public class KOImpl implements KO {

    private KE ke;
    private X x;
    private STO sto;
    private VO vo;
    private X x1;
    private VO vo1;
    private X x2;
    private VO vo2;

    private double vaerdi = NaN;
    private boolean erBeregnet = false;

    @Override
    public void init(KE ke, X x, STO sto, VO vo) {
        this.ke = ke;
        this.x = x;
        this.sto = sto;
        this.vo = vo;
    }

    @Override
    public void init1(X x1, VO vo1){
        this.x1 = x1;
        this.vo1 = vo1;
    }

    @Override
    public void init2(X x2, VO vo2){
        this.x2 = x2;
        this.vo2 = vo2;
    }

    @Override
    public void setVaerdi(double vaerdi) {
        if (vaerdi < 0) {
            throw new NegativVaerdiException();
        } else {
            this.vaerdi = vaerdi;
            erBeregnet = false;
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

        // TODO: lav beregner med x1, x2, vo1 og vo2

        if (ke.getVaerdi() != NaN && x.getVaerdi() != NaN) {

            this.vaerdi = ke.getVaerdi() * x.getVaerdi();
            setBeregnet(true);

        } else if (sto.getVaerdi() != NaN && vo.getVaerdi() != NaN) {

            this.vaerdi = sto.getVaerdi() - vo.getVaerdi();
            setBeregnet(true);

        } else if (getBeregnet()) {
            setVaerdi(NaN);

        /*
        KO = KE * X
        KO = STO - VO
*/

        }
    }
}
