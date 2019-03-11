package dk.kugelberg.hoek_helper.view.viewmodel;

import androidx.lifecycle.ViewModel;
import dk.kugelberg.hoek_helper.model.Controller;

import dk.kugelberg.hoek_helper.model.ControllerImpl;
import dk.kugelberg.hoek_helper.model.DOMK;
import dk.kugelberg.hoek_helper.model.Raekke;
import dk.kugelberg.hoek_helper.model.VE;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.X;


public class MainViewModel extends ViewModel implements Main {


    private Controller controller = new ControllerImpl();


    @Override
    public void addRow() {
        controller.hentTabel().addRaekke(controller.hentTabelStr());
    }

    @Override
    public Raekke getRow(int raekkenummer){
        return controller.hentTabel().getRaekke(raekkenummer);
    }


    @Override
    public Controller getController() {
        return controller;
    }


}
