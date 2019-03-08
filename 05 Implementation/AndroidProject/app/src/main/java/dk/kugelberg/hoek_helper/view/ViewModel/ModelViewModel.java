package dk.kugelberg.hoek_helper.view.ViewModel;

import android.app.Application;

import java.util.ArrayList;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dk.kugelberg.hoek_helper.model.Controller;
import dk.kugelberg.hoek_helper.model.ControllerImpl;
import dk.kugelberg.hoek_helper.model.Raekke;
import dk.kugelberg.hoek_helper.model.Tabel;
import dk.kugelberg.hoek_helper.model.TabelImpl;

public class ModelViewModel extends AndroidViewModel {

    private Controller controller;

    private MutableLiveData<ArrayList<Raekke>> tasks;

    public ModelViewModel(Application application) {
        super(application);

        controller = ControllerImpl.getInstance();
        tasks = controller.getTabel().getTabelMld();
    }

    public MutableLiveData<ArrayList<Raekke>> getTable() {
        return tasks;
    }
}