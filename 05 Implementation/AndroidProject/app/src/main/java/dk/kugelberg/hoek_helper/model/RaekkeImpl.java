package dk.kugelberg.hoek_helper.model;

public class RaekkeImpl implements Raekke {

    private DOMK domk = null;
    private KO ko = null;
    private SE se = null;
    private STO sto = null;
    private VE ve = null;
    private VO vo = null;
    private X x = null;


    @Override
    public DOMK getDOMK() {
        return domk;
    }

    @Override
    public KO getKO() {
        return ko;
    }

    @Override
    public SE getSE() {
        return se;
    }

    @Override
    public STO getSTO() {
        return sto;
    }

    @Override
    public VE getVE() {
        return ve;
    }

    @Override
    public VO getVO() {
        return vo;
    }

    @Override
    public X getX() {
        return x;
    }

    @Override
    public void setDOMK(DOMK domk) {
        this.domk = domk;
    }

    @Override
    public void setKO(KO ko) {
        this.ko = ko;
    }

    @Override
    public void setSE(SE se) {
        this.se = se;

    }

    @Override
    public void setSTO(STO sto) {
        this.sto = sto;

    }

    @Override
    public void setVE(VE ve) {
        this.ve = ve;

    }

    @Override
    public void setVO(VO vo) {
        this.vo = vo;

    }

    @Override
    public void setX(X x) {
        this.x = x;

    }
}
