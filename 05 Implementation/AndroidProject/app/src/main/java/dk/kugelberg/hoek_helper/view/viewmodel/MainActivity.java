package dk.kugelberg.hoek_helper.view.viewmodel;

import dk.kugelberg.hoek_helper.model.DOMK;
import dk.kugelberg.hoek_helper.model.VE;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.X;

public interface MainActivity {


    VO getVOVaerdi(int raekkenummer);
    void setVOVaerdi(int raekkenummer, double value);

    X getXVaerdi(int raekkenummer);
    void setXVaerdi(int raekkenummer, double value);

    VE getVEVaerdi(int raekkenummer);
    void setVEVaerdi(int raekkenummer, double value);

    DOMK getDOMKVaerdi(int raekkenummer);
    void setDOMKVaerdi(int raekkenummer, double value);
}
