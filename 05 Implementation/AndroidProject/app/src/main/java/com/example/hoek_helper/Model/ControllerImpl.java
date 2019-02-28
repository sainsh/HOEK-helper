package com.example.hoek_helper.Model;

public class ControllerImpl implements Controller {

    KO ko;
    X x1;
    X x2;
    VO vo1;
    VO vo2;
    DOMK domk

    public ControllerImpl() {

        ko = new KO();
    }


    @Override
    public void angivKO(double vaerdi) {
        return ko.setVaerdi(vaerdi);
    }

    @Override
    public double hentKO() {
        return ko.getVaerdi();
    }

    @Override
    public void beregnDOMK() {

        domk = new DOMKImpl();
        domk.setVaerdi(x1.getAntal,x2.getAntal,vo1.getVaerdi,vo2.getVaerdi);

    }

    @Override
    public double hentDOMK() {
        return domk.getDOMK();
    }
}
