package dk.kugelberg.hoek_helper.view.ViewModel;

import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dk.kugelberg.hoek_helper.model.Controller;
import dk.kugelberg.hoek_helper.model.Raekke;
import dk.kugelberg.hoek_helper.model.Tabel;
import dk.kugelberg.hoek_helper.model.TabelImpl;

public class ModelViewModel extends ViewModel {

    // TODO (4) ViewModel skal også bruge LiveData, som de forskellige activities kan observere
    // ViewModel er også løst koblet på modellen, dvs. modellen har ikke kendskab til ViewModel

    private Controller controller;

    public ModelViewModel(Controller controller) {
        this.controller = controller;
    }


    public MutableLiveData<ArrayList<Raekke>> getTable() {

        return controller.getTabel().getTabel();
    }

//    public MutableLiveData<String> getA() {
//        // TODO (6) Hent data fra modellen
//        currentA = model.getA();
//        return currentA;
//    }
//
//    public void setA(String a) {
//        // TODO (7) Skriv data til modellen
//        model.setA(a);
//    }

}