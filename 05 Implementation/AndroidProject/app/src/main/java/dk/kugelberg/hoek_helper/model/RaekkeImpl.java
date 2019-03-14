package dk.kugelberg.hoek_helper.model;

public class RaekkeImpl implements Raekke {

    private DOMK domk = null;
    private GROMK gromk = null;
    private KE ke = null;
    private KO ko = null;
    private SE se = null;
    private STO sto = null;
    private VE ve = null;
    private VO vo = null;
    private X x = null;
    private OMS oms = null;
    private DB db = null;

    private int raekkenummer;

    public RaekkeImpl() {
        // Instantierer beregninger aka. kolonerne
        domk = new DOMKImpl();
        gromk = new GROMKImpl();
        ke = new KEimpl();
        ko = new KOImpl();
        se = new SEImpl();
        sto = new STOImpl();
        ve = new VEImpl();
        vo = new VOImpl();
        x = new XImpl();
        oms = new OMSImpl();
        db = new DBImpl();

        sto.init(x,vo,ko,se,gromk);
        domk.init(vo,sto,ko,ve,x);
        gromk.init(x, sto);
        ke.init(ko,x,se,ve);
        ko.init(ke,x,sto,vo);
        se.init(x,sto,ve,ke);
        ve.init(vo,x,se,ke);
        vo.init(ve,x,ko,domk,sto,se,db,oms);
        x.init(vo,ve,domk,sto,se,gromk,ko,ke);
    }

    @Override
    public DOMK getDOMK() {
        return domk;
    }

    @Override
    public GROMK getGROMK() {
        return gromk;
    }

    @Override
    public KE getKE() {
        return ke;
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
    public OMS getOMS() {
        return oms;
    }

    @Override
    public DB getDB() {
        return db;
    }

    @Override
    public int getRaekkenummer() {
        return raekkenummer;
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

    @Override
    public void setKE(KE ke) {
        this.ke = ke;
    }

    @Override
    public void setGROMK(GROMK gromk) {
        this.gromk = gromk;
    }

    @Override
    public void setDB(DB db) {
        this.db = db;
    }

    @Override
    public void setOMS(OMS oms) {
        this.oms = oms;
    }

    @Override
    public void setRaekkenummer(int raekkenummer) {
        this.raekkenummer = raekkenummer;
    }
}
