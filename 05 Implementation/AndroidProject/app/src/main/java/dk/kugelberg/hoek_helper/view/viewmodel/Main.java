package dk.kugelberg.hoek_helper.view.viewmodel;

import dk.kugelberg.hoek_helper.model.Controller;
import dk.kugelberg.hoek_helper.model.DOMK;
import dk.kugelberg.hoek_helper.model.Raekke;
import dk.kugelberg.hoek_helper.model.VE;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.X;

public interface Main {


    void addRow();

    Raekke getRow(int raekkenummer);

    Controller getController();

}
