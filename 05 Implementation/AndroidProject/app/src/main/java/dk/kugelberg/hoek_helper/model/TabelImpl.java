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

        Raekke raekke0 = null;
        Raekke raekke1 = null;
        Raekke raekke2 = null;


        if (raekkenummer != 0) {
            raekke0 = tabel.get(raekkenummer - 1);
            raekke0.getDOMK().init2(raekke0.getX(), raekke0.getVO());//and all others needed
        }
        raekke1 = tabel.get(raekkenummer);
        raekke1.getDOMK().init1(raekke1.getX(), raekke1.getVO()); // and all others needed
        raekke1.getDOMK().init2(raekke1.getX(), raekke1.getVO()); // and all others needed

        if (raekkenummer != tabel.size()) {
            raekke2 = tabel.get(raekkenummer + 1);
            raekke2.getDOMK().init1(raekke2.getX(), raekke2.getVO()); //and all others needed
        }


    }


}
