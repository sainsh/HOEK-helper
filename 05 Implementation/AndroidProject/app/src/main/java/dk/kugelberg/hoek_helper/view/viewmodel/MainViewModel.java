package dk.kugelberg.hoek_helper.view.viewmodel;

import androidx.lifecycle.ViewModel;
import dk.kugelberg.hoek_helper.model.Controller;

import dk.kugelberg.hoek_helper.model.ControllerImpl;
import dk.kugelberg.hoek_helper.model.DOMK;
import dk.kugelberg.hoek_helper.model.VE;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.X;


public class MainViewModel extends ViewModel implements Main {


    private Controller controller = new ControllerImpl();


    @Override
    public void addRow() {
        System.out.println("NY RÆKKE TILFØJET!!!!\n");
        controller.hentTabel().addRaekke(controller.hentTabelStr());
    }

    @Override
    public VO getVO(int raekkenummer){
        return controller.hentTabel().getTabel().get(raekkenummer).getVO();
    }

    @Override
    public void setVO(int raekkenummer, double value){
        controller.hentTabel().getTabel().get(raekkenummer).getVO().setVaerdi(value);
    }

    @Override
    public X getX(int raekkenummer) {
        return controller.hentTabel().getTabel().get(raekkenummer).getX();
    }

    @Override
    public void setX(int raekkenummer, double value) {
        controller.hentTabel().getTabel().get(raekkenummer).getX().setVaerdi(value);
    }

    @Override
    public VE getVE(int raekkenummer) {
        return controller.hentTabel().getTabel().get(raekkenummer).getVE();
    }

    @Override
    public void setVE(int raekkenummer, double value) {
        controller.hentTabel().getTabel().get(raekkenummer).getVE().setVaerdi(value);
    }

    @Override
    public DOMK getDOMK(int raekkenummer) {
        return controller.hentTabel().getTabel().get(raekkenummer).getDOMK();
    }

    @Override
    public void setDOMK(int raekkenummer, double value) {
        controller.hentTabel().getTabel().get(raekkenummer).getDOMK().setVaerdi(value);
    }

}
