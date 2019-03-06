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
    public void addRaekke(int raekkenummer) {

    }


    @Override
    public ArrayList<Raekke> getTabel() {
        return tabel;
    }

    @Override
    public void addRaekke(int raekkeNummer, Raekke raekke) {

        tabel.add(raekkeNummer, raekke);
        updateRowNumbers();

    }

    @Override
    public void deleteRaekke(int raekkenummer) {

        tabel.remove(raekkenummer);
        updateRowNumbers();

    }

    @Override
    public void updateRowNumbers() {

        int currentRowNumber = 0;
        for (Raekke raekke : tabel){
            raekke.setRaekkenummer(currentRowNumber);
            currentRowNumber++;
        }

    }


    @Override
    public void angivDOMK(double vaerdi, int raekkenummer) {
        tabel.get(raekkenummer).getDOMK().setVaerdi(vaerdi);
        //updateAdjacentRows(raekkenummer);
    }

    @Override
    public double hentDOMK(int raekkenummer) {
        return tabel.get(raekkenummer).getDOMK().getVaerdi();

    }

    @Override
    public void beregnDOMK(int raekkenummer) {

        DOMK domk = tabel.get(raekkenummer).getDOMK();
        double vaerdi = Double.NaN;


        domk = new DOMKImpl();
        domk.setVaerdi(vaerdi);
        //updateAdjacentRows(raekkenummer);


    }

    @Override
    public void angivKO(double vaerdi, int raekkenummer) {

        tabel.get(raekkenummer).getKO().setVaerdi(vaerdi);
        //updateAdjacentRows(raekkenummer);
    }

    @Override
    public double hentKO(int raekkenummer) {
        return tabel.get(raekkenummer).getKO().getVaerdi();
    }

    @Override
    public void beregnKO(int raekkenummer) {
        tabel.get(raekkenummer).getKO().beregn();
        //updateAdjacentRows(raekkenummer);

    }

    @Override
    public void angivSTO(double vaerdi, int raekkenummer) {
        tabel.get(raekkenummer).getSTO().setVaerdi(vaerdi);
        //updateAdjacentRows(raekkenummer);

    }

    @Override
    public double hentSTO(int raekkenummer) {
        return tabel.get(raekkenummer).getSTO().getVaerdi();
    }

    @Override
    public void beregnSTO(int raekkenummer) {
        tabel.get(raekkenummer).getSTO().beregn();
        //updateAdjacentRows(raekkenummer);

    }

    @Override
    public void angivVE(double vaerdi, int raekkenummer) {
        tabel.get(raekkenummer).getVE().setVaerdi(vaerdi);
        //updateAdjacentRows(raekkenummer);

    }

    @Override
    public double hentVE(int raekkenummer) {
        return tabel.get(raekkenummer).getVE().getVaerdi();
    }

    @Override
    public void beregnVE(int raekkenummer) {
        tabel.get(raekkenummer).getVE().beregn();
        //updateAdjacentRows(raekkenummer);
    }

    @Override
    public void angivVO(double vaerdi, int raekkenummer) {
        tabel.get(raekkenummer).getVO().setVaerdi(vaerdi);
        //updateAdjacentRows(raekkenummer);

    }

    @Override
    public double hentVO(int raekkenummer) {
        return tabel.get(raekkenummer).getVO().getVaerdi();
    }

    @Override
    public void beregnVO(int raekkenummer) {
        tabel.get(raekkenummer).getVO().beregn();
        //updateAdjacentRows(raekkenummer);

    }

    @Override
    public void angivX(double antal, int raekkenummer) {
        tabel.get(raekkenummer).getX().setVaerdi(antal);
        //updateAdjacentRows(raekkenummer);

    }

    @Override
    public double hentX(int raekkenummer) {
        return tabel.get(raekkenummer).getX().getVaerdi();
    }

    @Override
    public void beregnX(int raekkenummer) {
        tabel.get(raekkenummer).getX().beregn();
        //updateAdjacentRows(raekkenummer);

    }


}
