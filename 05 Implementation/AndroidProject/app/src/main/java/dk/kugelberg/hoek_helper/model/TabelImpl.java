package dk.kugelberg.hoek_helper.model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TabelImpl implements Tabel {

    private ArrayList<Raekke> tabel;

    final char CSV_DELIMITER = ';';

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

        Raekke raekke = null;
        Raekke raekke1 = null;
        Raekke raekke2 = null;

/*
        if (raekkenummer != 0) {
            raekke0 = tabel.get(raekkenummer - 1);
            raekke0.getDOMK().initUnder(raekke0.getX(), raekke0.getVO());//and all others needed
        }
        raekke1 = tabel.get(raekkenummer);
        raekke1.getDOMK().initOver(raekke1.getX(), raekke1.getVO()); // and all others needed
        raekke1.getDOMK().initUnder(raekke1.getX(), raekke1.getVO()); // and all others needed

        if (raekkenummer != tabel.size()) {
            raekke2 = tabel.get(raekkenummer + 1);
            raekke2.getDOMK().initOver(raekke2.getX(), raekke2.getVO()); //and all others needed
        }

*/
    }

    @Override
    public void angivDOMK(double vaerdi, int raekkenummer) {
        tabel.get(raekkenummer).getDOMK().setVaerdi(vaerdi);
        updateAdjacentRows(raekkenummer);
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
        updateAdjacentRows(raekkenummer);


    }

    @Override
    public void angivKO(double vaerdi, int raekkenummer) {

        tabel.get(raekkenummer).getKO().setVaerdi(vaerdi);
        updateAdjacentRows(raekkenummer);
    }

    @Override
    public double hentKO(int raekkenummer) {
        return tabel.get(raekkenummer).getKO().getVaerdi();
    }

    @Override
    public void beregnKO(int raekkenummer) {
        tabel.get(raekkenummer).getKO().beregn();
        updateAdjacentRows(raekkenummer);

    }

    @Override
    public void angivSTO(double vaerdi, int raekkenummer) {
        tabel.get(raekkenummer).getSTO().setVaerdi(vaerdi);
        updateAdjacentRows(raekkenummer);

    }

    @Override
    public double hentSTO(int raekkenummer) {
        return tabel.get(raekkenummer).getSTO().getVaerdi();
    }

    @Override
    public void beregnSTO(int raekkenummer) {
        tabel.get(raekkenummer).getSTO().beregn();
        updateAdjacentRows(raekkenummer);

    }

    @Override
    public void angivVE(double vaerdi, int raekkenummer) {
        tabel.get(raekkenummer).getVE().setVaerdi(vaerdi);
        updateAdjacentRows(raekkenummer);

    }

    @Override
    public double hentVE(int raekkenummer) {
        return tabel.get(raekkenummer).getVE().getVaerdi();
    }

    @Override
    public void beregnVE(int raekkenummer) {
        tabel.get(raekkenummer).getVE().beregn();
        updateAdjacentRows(raekkenummer);
    }

    @Override
    public void angivVO(double vaerdi, int raekkenummer) {
        tabel.get(raekkenummer).getVO().setVaerdi(vaerdi);
        updateAdjacentRows(raekkenummer);

    }

    @Override
    public double hentVO(int raekkenummer) {
        return tabel.get(raekkenummer).getVO().getVaerdi();
    }

    @Override
    public void beregnVO(int raekkenummer) {
        tabel.get(raekkenummer).getVO().beregn();
        updateAdjacentRows(raekkenummer);

    }

    @Override
    public void angivX(int antal, int raekkenummer) {
        tabel.get(raekkenummer).getX().setVaerdi(antal);
        updateAdjacentRows(raekkenummer);

    }

    @Override
    public double hentX(int raekkenummer) {
        return tabel.get(raekkenummer).getX().getVaerdi();
    }

    @Override
    public void beregnX(int raekkenummer) {
        tabel.get(raekkenummer).getX().beregn();
        updateAdjacentRows(raekkenummer);

    }

    @Override
    public void createCSV() {

        try{
            File file = new File("test.csv");
            PrintWriter writer = new PrintWriter(file);
            StringBuilder sb = new StringBuilder();

            sb.append("X"+CSV_DELIMITER+"VO"+CSV_DELIMITER+"VE"+CSV_DELIMITER+"KE"+CSV_DELIMITER+"STO"+CSV_DELIMITER+"SE"+CSV_DELIMITER+"KO"+CSV_DELIMITER+"GROMK"+CSV_DELIMITER+"DOMK\n");



            for (Raekke raekke: tabel) {

                sb.append(String.valueOf(raekke.getX().getVaerdi())+CSV_DELIMITER);
                sb.append(String.valueOf(raekke.getVO().getVaerdi())+CSV_DELIMITER);
                sb.append(String.valueOf(raekke.getVE().getVaerdi())+CSV_DELIMITER);
                sb.append(String.valueOf(raekke.getKE().getVaerdi())+CSV_DELIMITER);
                sb.append(String.valueOf(raekke.getSTO().getVaerdi())+CSV_DELIMITER);
                sb.append(String.valueOf(raekke.getSE().getVaerdi())+CSV_DELIMITER);
                sb.append(String.valueOf(raekke.getKO().getVaerdi())+CSV_DELIMITER);
                sb.append(String.valueOf(raekke.getGROMK().getVaerdi())+CSV_DELIMITER);
                sb.append(String.valueOf(raekke.getDOMK().getVaerdi()));
                sb.append("\n");

            }

            writer.write(sb.toString());
            writer.close();


        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
