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
    public void angivKO(double vaerdi) {
        ko.setVaerdi(vaerdi);

    }

    @Override
    public double hentKO() {
        return ko.getVaerdi();
    }

    @Override
    public void beregnDOMK() {

        double vaerdi = Double.NaN;


        domk = new DOMKImpl();
        domk.setVaerdi(vaerdi);

    }

    @Override
    public double hentDOMK() {
        // return domk.getDOMK();
        return 0.0;
    }

    @Override
    public void beregnVO() {

    }

    @Override
    public double hentVO() {
        return 0;
    }
}
