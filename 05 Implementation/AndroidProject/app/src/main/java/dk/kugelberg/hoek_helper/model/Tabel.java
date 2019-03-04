package dk.kugelberg.hoek_helper.model;

import java.util.ArrayList;

public interface Tabel {

    Raekke getRaekke(int raekkenummer);
    ArrayList<Raekke> getTabel();
    void addRaekke(int raekkenummer);
    void deleateRaekke(int raekkenummer);

}
