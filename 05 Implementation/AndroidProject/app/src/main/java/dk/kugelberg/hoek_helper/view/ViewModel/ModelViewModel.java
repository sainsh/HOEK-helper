package dk.kugelberg.hoek_helper.view.ViewModel;

import android.app.Application;
import android.widget.EditText;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.Collections;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import dk.kugelberg.hoek_helper.model.Controller;
import dk.kugelberg.hoek_helper.model.ControllerImpl;
import dk.kugelberg.hoek_helper.model.Raekke;
import dk.kugelberg.hoek_helper.model.Tabel;

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

    double testX = 0;
    double testVO = 0;

    public void addRow() {
        for (int i = 0; i < 10; i++) {
            Tabel tabel = controller.getTabel();
            ArrayList<Raekke> arrayList = tabel.getTabelMld().getValue();

            int tabelSize = arrayList.size();

            tabel.addRaekke(tabelSize);

            Raekke raekke = tabel.getRaekke(tabelSize);
            raekke.getX().setVaerdi(testX);
            testX += 1000;
            raekke.getVO().setVaerdi(testVO);
            testVO += 50000 * (testX / 1000);
            raekke.getVE().init(raekke.getVO(), raekke.getX(), raekke.getSE(), raekke.getKE());
            raekke.getVE().beregn();

            if (tabelSize != 0) {
                raekke.getDOMK().init(raekke.getVO(), raekke.getSTO(), raekke.getKO(), raekke.getVE(), raekke.getX());

                Raekke raekkeOver = tabel.getRaekke(tabelSize - 1);
                raekke.getDOMK().initOver(raekkeOver.getVO(), raekkeOver.getX(), raekkeOver.getDOMK());

                raekke.getDOMK().beregn();
            }

            tabel.getTabelMld().setValue(arrayList);
        }
    }

    public void popupInsert(PopupWindow popupWindow, EditText etRows, EditText etAntal, EditText etIncrement) {
        // if (etRows.getText().toString() != "" && etAntal.getText().toString() != "" && etIncrement.getText().toString() != "") {
            try {


            int rows = Integer.parseInt(etRows.getText().toString());
            int antal = Integer.parseInt(etAntal.getText().toString());
            int increment = Integer.parseInt(etIncrement.getText().toString());

            for (int i = 0; i < rows; i++) {
                Tabel tabel = controller.getTabel();
                ArrayList<Raekke> arrayList = tabel.getTabelMld().getValue();

                int tabelSize = arrayList.size();

                tabel.addRaekke(tabelSize);

                Raekke raekke = tabel.getRaekke(tabelSize);
                raekke.getX().setVaerdi(antal);

                tabel.getTabelMld().setValue(arrayList);

                antal += increment;
            }} catch (NumberFormatException e) {

            }
            popupWindow.dismiss();

      //  }
    }

    public void popupCancel(PopupWindow popupWindow) {
        popupWindow.dismiss();
    }

    public void moveUp(int position) {
        if (position != 0) {
            Collections.swap(tasks.getValue(), position, position - 1);
            ControllerImpl.getInstance().getTabel().getTabelMld().setValue(tasks.getValue());
        }
    }

    public void moveDown(int position) {
        if (position != tasks.getValue().size() - 1) {
            Collections.swap(tasks.getValue(), position, position + 1);
            ControllerImpl.getInstance().getTabel().getTabelMld().setValue(tasks.getValue());
        }
    }

    public void deleteRow(int position) {
        tasks.getValue().remove(position);
        ControllerImpl.getInstance().getTabel().getTabelMld().setValue(tasks.getValue());
    }

    public void deleteAll() {
        tasks.getValue().clear();
        ControllerImpl.getInstance().getTabel().getTabelMld().setValue(tasks.getValue());
    }

}