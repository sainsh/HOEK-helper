package dk.kugelberg.hoek_helper.model;

public class ControllerImpl implements Controller {

    KO ko;
    X x1;
    X x2;
    VO vo1;
    VO vo2;
    DOMK domk;

    Tabel tabel;

    public ControllerImpl() {

        ko = new KOImpl();
        tabel = new TabelImpl();
    }


    @Override
    public void angivKO(double vaerdi, int raekkenummer) {
        tabel.angivKO(vaerdi, raekkenummer);
        ko.setVaerdi(vaerdi);

    }

    @Override
    public double hentKO(int raekkenummer) {

        return tabel.hentKO(raekkenummer);
    }

    @Override
    public void beregnKO(int raekkenummer) {

        tabel.beregnKO(raekkenummer);

    }

    @Override
    public void angivSTO(double vaerdi, int raekkenummer) {

        tabel.angivSTO(vaerdi, raekkenummer);

    }

    @Override
    public double hentSTO(int raekkenummer) {
        return tabel.hentSTO(raekkenummer);
    }

    @Override
    public void beregnSTO(int raekkenummer) {
        tabel.beregnSTO(raekkenummer);

    }

    @Override
    public void angivVE(double vaerdi, int raekkenummer) {
        tabel.angivVE(vaerdi, raekkenummer);

    }

    @Override
    public double hentVE(int raekkenummer) {
        return tabel.hentVE(raekkenummer);
    }

    @Override
    public void beregnVE(int raekkenummer) {
        tabel.beregnVE(raekkenummer);

    }

    @Override
    public void angivVO(double vaerdi, int raekkenummer) {
        tabel.angivVO(vaerdi, raekkenummer);

    }

    @Override
    public void beregnDOMK(int raekkenummer) {

        tabel.beregnDOMK(raekkenummer);

    }

    @Override
    public void angivDOMK(double vaerdi, int raekkenummer) {
        tabel.angivDOMK(vaerdi, raekkenummer);
    }

    @Override
    public double hentDOMK(int raekkenummer) {
        // return domk.getDOMK();
        return tabel.hentDOMK(raekkenummer);
    }

    @Override
    public void beregnVO(int raekkenummer) {
        tabel.beregnVO(raekkenummer);

    }

    @Override
    public void angivX(int antal, int raekkenummer) {
        tabel.angivX(antal,raekkenummer);
    }

    @Override
    public int hentX(int raekkenummer) {
        return tabel.hentX(raekkenummer);
    }

    @Override
    public void beregnX(int raekkenummer) {
        tabel.beregnX(raekkenummer);

    }

    @Override
    public double hentVO(int raekkenummer) {
        return tabel.hentVO(raekkenummer);
    }


}
