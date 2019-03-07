package dk.kugelberg.hoek_helper.model;

public class ControllerImpl implements Controller {

    private GROMK gromk;
    private KE ke;
    private SE se;
    private VO vo;
    private X x;
    private DOMK domk;
    private DOMK domk1;
    private DOMK domk2;
    private KO ko;
    private STO sto;
    private VE ve;
    private VO vo1;
    private VO vo2;
    private X x1;
    private X x2;

    // Platformen indeholder kun 1 tabel.
    private Tabel tabel = new TabelImpl();

    @Override
    public void lavRaekke() {

        // Opret række
        Raekke raekke = new RaekkeImpl();
        // Hent ny række nummer
        int raekkeNummer = hentTabelStr();
        raekke.setRaekkenummer(raekkeNummer);

        // Tilføj til array
        tabel.addRaekke(raekkeNummer, raekke);

    }

    @Override
    public Raekke hentRaekke(int raekkenummer) {
        return null;
    }

    @Override
    public void sletRaekke(int raekkenummer) {

    }

    @Override
    public int hentTabelStr(){
        return tabel.getTabel().size();
    }

    @Override
    public void opdaterRaekke(int raekkenummer) {

    }


        public void angivKO(double vaerdi, int raekkenummer) {

        ko = tabel.getRaekke(raekkenummer).getKO();
        ko.setVaerdi(vaerdi);

    }

    public double hentKO(int raekkenummer) {
        ko = tabel.getRaekke(raekkenummer).getKO();
        return ko.getVaerdi();
    }


    public void beregnKO(int raekkenummer) {
        ko = tabel.getRaekke(raekkenummer).getKO();
        ko.init(ke, x, sto, vo);
        ko.beregn();

    }

    @Override
    public void angivSTO(double vaerdi, int raekkenummer) {
        sto = tabel.getRaekke(raekkenummer).getSTO();
        sto.setVaerdi(vaerdi);
    }

    @Override
    public double hentSTO(int raekkenummer) {
        sto = tabel.getRaekke(raekkenummer).getSTO();
        return sto.getVaerdi();
    }

    @Override
    public void beregnSTO(int raekkenummer) {
        sto = tabel.getRaekke(raekkenummer).getSTO();
        sto.init(x, vo, ko, se);
        sto.beregn();
    }

    @Override
    public void angivVE(double vaerdi, int raekkenummer) {
        ve = tabel.getRaekke(raekkenummer).getVE();
        ve.setVaerdi(vaerdi);
    }

    @Override
    public double hentVE(int raekkenummer) {
        ve = tabel.getRaekke(raekkenummer).getVE();
        return sto.getVaerdi();
    }

    @Override
    public void beregnVE(int raekkenummer) {
        ve = tabel.getRaekke(raekkenummer).getVE();
        ve.init(vo, x, se, ke);

    }

    @Override
    public void angivVO(double vaerdi, int raekkenummer) {

    }

    @Override
    public void beregnDOMK(int raekkenummer) {

        //domk = tabel.getRaekke(raekkenummer).getDomk();

        // Init data field to object
        domk.init(vo1, vo2, sto, ko, ve, x1, x2, domk1, domk2);

        // Beregning goes here
        domk.beregn();


    }

    @Override
    public void angivDOMK(double vaerdi, int raekkenummer) {



    }

    @Override
    public double hentDOMK(int raekkenummer) {
        // return domk.getDOMK();
        return 0.0;
    }

    @Override
    public void beregnVO(int raekkenummer) {

    }

    @Override
    public void angivX(int antal, int raekkenummer) {

    }

    @Override
    public int hentX(int raekkenummer) {
        return 0;
    }

    @Override
    public void beregnX(int raekkenummer) {

    }

    @Override
    public double hentVO(int raekkenummer) {
        return 0;
    }




}
