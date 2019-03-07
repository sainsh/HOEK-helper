package dk.kugelberg.hoek_helper.model;

import java.util.ArrayList;

public interface Tabel {

    Raekke getRaekke(int raekkenummer);
    ArrayList<Raekke> getTabel();
    void addRaekke(int raekkenummer);
    void deleteRaekke(int raekkenummer);

    void angivDOMK(double vaerdi, int raekkenummer);

    double hentDOMK(int raekkenummer);

    void beregnDOMK(int raekkenummer);


    void angivKO(double vaerdi, int raekkenummer);

    double hentKO(int raekkenummer);

    void beregnKO(int raekkenummer);


    void angivSTO(double vaerdi, int raekkenummer);

    double hentSTO(int raekkenummer);

    void beregnSTO(int raekkenummer);


    void angivVE(double vaerdi, int raekkenummer);

    double hentVE(int raekkenummer);

    void beregnVE(int raekkenummer);


    void angivVO(double vaerdi, int raekkenummer);

    double hentVO(int raekkenummer);

    void beregnVO(int raekkenummer);


    void angivX(int antal, int raekkenummer);

    double hentX(int raekkenummer);

    void beregnX(int raekkenummer);


}
