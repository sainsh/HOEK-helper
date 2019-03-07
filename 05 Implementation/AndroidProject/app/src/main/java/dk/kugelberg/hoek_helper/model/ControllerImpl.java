package dk.kugelberg.hoek_helper.model;

public class ControllerImpl implements Controller {

    DOMK domk;
    DOMK domk1;
    DOMK domk2;
    KO ko;
    STO sto;
    VE ve;
    VO vo1;
    VO vo2;
    X x1;
    X x2;

    public ControllerImpl() {

        ko = new KOImpl();
        x1 = new XImpl();
        x2 = new XImpl();
        vo1 = new VOImpl();
        vo2 = new VOImpl();
        domk = new DOMKImpl();
    }

     public void angivKO(double vaerdi, int raekkenummer) {


        //ko = tabel.getRaekke(raekkenummer).getKO();
        ko.setVaerdi(vaerdi);

    }

    public double hentKO(int raekkenummer) {
        //ko = tabel.getRaekke(raekkenummer).getKO();
        return ko.getVaerdi();
    }


    public void beregnKO(int raekkenummer) {
        //ko = tabel.getRaekke(raekkenummer).getKO();
        //ko.init();
        ko.beregn();

    }


    public void angivSTO(double vaerdi, int raekkenummer) {
        //sto = tabel.getRaekke(raekkenummer).getSTO();
        sto.setVaerdi(vaerdi);
    }


    public double hentSTO(int raekkenummer) {
        //sto = tabel.getRaekke(raekkenummer).getSTO();
        return sto.getVaerdi();
    }


    public void beregnSTO(int raekkenummer) {
        //sto = tabel.getRaekke(raekkenummer).getSTO();
        //sto.init(vo1, vo2, sto, ko, ve, x1, x2, domk1, domk2);
        sto.beregn();
    }


    public void angivVE(double vaerdi, int raekkenummer) {
        //ve = tabel.getRaekke(raekkenummer).getVE();
        ve.setVaerdi(vaerdi);
    }


    public double hentVE(int raekkenummer) {
        //ve = tabel.getRaekke(raekkenummer).getVE();
        return sto.getVaerdi();
    }


    public void beregnVE(int raekkenummer) {
        //ve = tabel.getRaekke(raekkenummer).getVE();

    }

    public void angivVO(double vaerdi, int raekkenummer) {

    }

    public void beregnDOMK(int raekkenummer) {

        //domk = tabel.getRaekke(raekkenummer).getDomk();

        // Init data field to object
        //domk.init(vo1, vo2, sto, ko, ve, x1, x2, domk1, domk2);

        // Beregning goes here
        domk.beregn();


    }

    public void angivDOMK(double vaerdi, int raekkenummer) {



    }

    public double hentDOMK(int raekkenummer) {
        // return domk.getDOMK();
        return 0.0;
    }

    public void beregnVO(int raekkenummer) {

    }

    public void angivX(int antal, int raekkenummer) {

    }

    public int hentX(int raekkenummer) {
        return 0;
    }

    public void beregnX(int raekkenummer) {

    }

    public double hentVO(int raekkenummer) {
        return 0;
    }


    @Override
    public void lavRaekke() {

    }

    @Override
    public Raekke hentRaekke(int raekkenummer) {
        return null;
    }

    @Override
    public void sletRaekke(int raekkenummer) {

    }

    @Override
    public int hentTabelStr() {
        return 0;
    }

    @Override
    public void opdaterRaekke(int raekkenummer) {

    }
}
