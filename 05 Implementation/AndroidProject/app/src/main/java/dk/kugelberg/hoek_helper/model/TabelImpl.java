package dk.kugelberg.hoek_helper.model;

import java.util.ArrayList;

public class TabelImpl implements Tabel {

    private ArrayList<Raekke> tabel;

    public TabelImpl() {
        tabel = new ArrayList<>();
    }


    @Override
    public Raekke getRaekke(int raekkenummer) {
        return tabel.get(raekkenummer);
    }

    @Override
    public ArrayList<Raekke> getTabel() {
        return tabel;
    }

    @Override
    public void addRaekke(int raekkenummer) {

        Raekke raekke = new RaekkeImpl();
        tabel.add(raekkenummer, raekke);

        updateAdjacentRows(raekkenummer);

    }

    @Override
    public void deleteRaekke(int raekkenummer) {

        tabel.remove(raekkenummer);
        updateAdjacentRows(raekkenummer);

    }

    private void updateAdjacentRows(int raekkenummer) {

        Raekke raekke0 = tabel.get(raekkenummer-1);
        Raekke raekke1 = tabel.get(raekkenummer);
        Raekke raekke2 = tabel.get(raekkenummer+1);





    }


}
