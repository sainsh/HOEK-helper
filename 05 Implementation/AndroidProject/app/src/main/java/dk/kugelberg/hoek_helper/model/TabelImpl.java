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

    @Override
    public void angivDOMK(double vaerdi, int raekkenummer) {

    }

    @Override
    public double hentDOMK(int raekkenummer) {
        return 0;
    }

    @Override
    public void beregnDOMK(int raekkenummer) {

        DOMK domk = tabel.get(raekkenummer).getDOMK();
        double vaerdi = Double.NaN;


        domk = new DOMKImpl();
        domk.setVaerdi(vaerdi);


    }

    @Override
    public void angivKO(double vaerdi, int raekkenummer) {

        tabel.get(raekkenummer).getKO().setVaerdi(vaerdi);

    }

    @Override
    public double hentKO(int raekkenummer) {
        return 0;
    }

    @Override
    public void beregnKO(int raekkenummer) {

    }

    @Override
    public void angivSTO(double vaerdi, int raekkenummer) {

    }

    @Override
    public double hentSTO(int raekkenummer) {
        return 0;
    }

    @Override
    public void beregnSTO(int raekkenummer) {

    }

    @Override
    public void angivVE(double vaerdi, int raekkenummer) {

    }

    @Override
    public double hentVE(int raekkenummer) {
        return 0;
    }

    @Override
    public void beregnVE(int raekkenummer) {

    }

    @Override
    public void angivVO(double vaerdi, int raekkenummer) {

    }

    @Override
    public double hentVO(int raekkenummer) {
        return 0;
    }

    @Override
    public void beregnVO(int raekkenummer) {

    }

    @Override
    public void angivX(int antal, int raekkenummer) {

    }

    @Override
    public int hentX(int raekkenummer) {
        return 0;
    }

    @Override
    public void beregnX(int raekkenummer) {

    }


}
