package dk.kugelberg.hoek_helper.model;

public interface Controller {


    void angivKO(double vaerdi, int raekkenummer);

    double hentKO(int raekkenummer);

    void beregnDOMK(int raekkenummer);

    double hentDOMK(int raekkenummer);

    void beregnVO(int raekkenummer);

    double hentVO(int raekkenummer);




}
