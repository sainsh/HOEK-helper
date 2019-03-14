package dk.kugelberg.hoek_helper.model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;

public class TabelImpl implements Tabel {

    private MutableLiveData<ArrayList<Raekke>> tabelMld;
    private ArrayList<Raekke> tabel;

    final char CSV_DELIMITER = ';';

    public TabelImpl() {
        tabelMld = new MutableLiveData<ArrayList<Raekke>>();
        tabel = new ArrayList<>();
        tabelMld.setValue(tabel);
    }


    @Override
    public Raekke getRaekke(int raekkenummer) {
        return tabel.get(raekkenummer);
    }

    @Override
    public MutableLiveData<ArrayList<Raekke>> getTabelMld() {
        return tabelMld;
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
        Raekke raekke1 = tabel.get(raekkenummer);
        Raekke raekke2 = null;


        if (raekkenummer != 0) {
            raekke0= tabel.get(raekkenummer-1);
            raekke1.getX().initOver(raekke0.getX(),raekke0.getVO());
            raekke1.getKO().initOver(raekke0.getX(),raekke0.getVO());
            raekke1.getVO().initOver(raekke0.getX(),raekke0.getVO());
            raekke1.getGROMK().initOver(raekke0.getX(),raekke0.getSTO());
            raekke1.getSTO().initOver(raekke0.getX(),raekke0.getVO(),raekke0.getSTO());
            raekke1.getDOMK().initOver(raekke0.getVO(),raekke0.getX(),raekke0.getDOMK());
        }

        if (raekkenummer != tabel.size()-1) {
            raekke2 = tabel.get(raekkenummer+1);
            raekke1.getSTO().initUnder(raekke2.getX(),raekke2.getVO());
            raekke1.getVO().initUnder(raekke2.getX(),raekke2.getVO(),raekke2.getDOMK());
            raekke1.getKO().initUnder(raekke2.getX(),raekke2.getVO());
            raekke1.getX().initUnder(raekke2.getX(),raekke2.getVO(),raekke2.getDOMK());
        }

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
