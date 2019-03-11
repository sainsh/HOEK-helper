package dk.kugelberg.hoek_helper.view.ViewModel;

import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dk.kugelberg.hoek_helper.model.Raekke;
import dk.kugelberg.hoek_helper.model.Tabel;

public class ModelViewModel extends ViewModel {

    // TODO (4) ViewModel skal også bruge LiveData, som de forskellige activities kan observere
    // ViewModel er også løst koblet på modellen, dvs. modellen har ikke kendskab til ViewModel
    private MutableLiveData<Double> currentA = new MutableLiveData<>();
    private MutableLiveData<Double> currentX = new MutableLiveData<>();


    private Tabel tabel = new Tabel() {
        @Override
        public Raekke getRaekke(int raekkenummer) {
            return null;
        }

        @Override
        public ArrayList<Raekke> getTabel() {
            return null;
        }

        @Override
        public void addRaekke(int raekkenummer) {

        }

        @Override
        public void deleteRaekke(int raekkenummer) {

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

        }

        @Override
        public void angivKO(double vaerdi, int raekkenummer) {

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
            this.getRaekke(raekkenummer).getX().setVaerdi(antal);
        }

        @Override
        public double hentX(int raekkenummer) {
            return tabel.getRaekke(raekkenummer).getX().getVaerdi();
        }

        @Override
        public void beregnX(int raekkenummer) {

        }

        @Override
        public void createCSV() {

        }
    };



    public ModelViewModel() {
        // TODO (5) Det her illustrerer, at vi får data fra modellen
        currentA.setValue(tabel.getRaekke(0).getX().getVaerdi());
        currentA.setValue(tabel.getRaekke(0).getVE().getVaerdi());
        currentA.setValue(tabel.getRaekke(0).getVO().getVaerdi());
        currentA.setValue(tabel.getRaekke(0).getSE().getVaerdi());
        currentA.setValue(tabel.getRaekke(0).getSTO().getVaerdi());
        currentA.setValue(tabel.getRaekke(0).getKE().getVaerdi());
        currentA.setValue(tabel.getRaekke(0).getKO().getVaerdi());
        currentA.setValue(tabel.getRaekke(0).getDOMK().getVaerdi());
        currentA.setValue(tabel.getRaekke(0).getGROMK().getVaerdi());
        // Giver "Startdata fra Model"
        // currentA.setValue("Startdata fra ViewModel");
    }

    public double getXvaerdi(int raekke){
        return tabel.getRaekke(raekke).getX().getVaerdi();
    }

    public void setXvaerdi(double vaerdi, int raekke) {
        tabel.getRaekke(raekke).getX().setVaerdi(vaerdi);
    }


    public MutableLiveData<Double> getA() {
        // TODO (6) Hent data fra modellen
        currentA = tabel.getRaekke(1).getX().getXmutable();
        return currentA;
    }
}