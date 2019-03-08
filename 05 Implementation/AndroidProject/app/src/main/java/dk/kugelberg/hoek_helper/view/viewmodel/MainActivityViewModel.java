package dk.kugelberg.hoek_helper.view.viewmodel;

import androidx.lifecycle.ViewModel;
import dk.kugelberg.hoek_helper.model.Controller;

import dk.kugelberg.hoek_helper.model.DOMK;
import dk.kugelberg.hoek_helper.model.VE;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.X;


public class MainActivityViewModel extends ViewModel implements MainActivity{


    private Controller controller;


    @Override
    public VO getVOVaerdi(int raekkenummer){
        return controller.hentTabel().getTabel().get(raekkenummer).getVO();
    }

    @Override
    public void setVOVaerdi(int raekkenummer, double value){
        controller.hentTabel().getTabel().get(raekkenummer).getVO().setVaerdi(value);
    }

    @Override
    public X getXVaerdi(int raekkenummer) {
        return controller.hentTabel().getTabel().get(raekkenummer).getX();
    }

    @Override
    public void setXVaerdi(int raekkenummer, double value) {
        controller.hentTabel().getTabel().get(raekkenummer).getX().setVaerdi(value);
    }

    @Override
    public VE getVEVaerdi(int raekkenummer) {
        return controller.hentTabel().getTabel().get(raekkenummer).getVE();
    }

    @Override
    public void setVEVaerdi(int raekkenummer, double value) {
        controller.hentTabel().getTabel().get(raekkenummer).getVE().setVaerdi(value);
    }

    @Override
    public DOMK getDOMKVaerdi(int raekkenummer) {
        return controller.hentTabel().getTabel().get(raekkenummer).getDOMK();
    }

    @Override
    public void setDOMKVaerdi(int raekkenummer, double value) {
        controller.hentTabel().getTabel().get(raekkenummer).getDOMK().setVaerdi(value);
    }

}
