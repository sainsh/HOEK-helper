package dk.kugelberg.hoek_helper.model;

public class ControllerImpl implements Controller {

    KO ko;
    X x1;
    X x2;
    VO vo1;
    VO vo2;
    DOMK domk;

    public ControllerImpl() {

        ko = new KOImpl();
    }


    @Override
    public void angivKO(double vaerdi, int raekkenummer) {
        ko.setVaerdi(vaerdi);

    }

    @Override
    public double hentKO(int raekkenummer) {
        return ko.getVaerdi();
    }

    @Override
    public void beregnDOMK(int raekkenummer) {

        double vaerdi = Double.NaN;


        domk = new DOMKImpl();
        domk.setVaerdi(vaerdi);

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
    public double hentVO(int raekkenummer) {
        return 0;
    }




}
