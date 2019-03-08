package dk.kugelberg.hoek_helper.view.viewmodel;

import dk.kugelberg.hoek_helper.model.DOMK;
import dk.kugelberg.hoek_helper.model.VE;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.X;

public interface MainActivity {


    void addRow();

    VO getVO(int raekkenummer);
    void setVO(int raekkenummer, double value);

    X getX(int raekkenummer);
    void setX(int raekkenummer, double value);

    VE getVE(int raekkenummer);
    void setVE(int raekkenummer, double value);

    DOMK getDOMK(int raekkenummer);
    void setDOMK(int raekkenummer, double value);
}
