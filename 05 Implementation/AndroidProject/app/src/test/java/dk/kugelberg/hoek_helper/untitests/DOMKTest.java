package dk.kugelberg.hoek_helper.untitests;

import org.junit.Test;

import dk.kugelberg.hoek_helper.MOCKS;
import dk.kugelberg.hoek_helper.model.DB;
import dk.kugelberg.hoek_helper.model.DOMK;
import dk.kugelberg.hoek_helper.model.DOMKImpl;
import dk.kugelberg.hoek_helper.model.GROMK;
import dk.kugelberg.hoek_helper.model.KE;
import dk.kugelberg.hoek_helper.model.KO;
import dk.kugelberg.hoek_helper.model.KOImpl;
import dk.kugelberg.hoek_helper.model.OMS;
import dk.kugelberg.hoek_helper.model.SE;
import dk.kugelberg.hoek_helper.model.STO;
import dk.kugelberg.hoek_helper.model.STOImpl;
import dk.kugelberg.hoek_helper.model.VE;
import dk.kugelberg.hoek_helper.model.VEImpl;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.VOImpl;
import dk.kugelberg.hoek_helper.model.X;
import dk.kugelberg.hoek_helper.model.XImpl;

import static org.junit.Assert.*;

public class DOMKTest {

    private final double DELTA = 0.00000000001;


    @Test
    public void setVaerdi() {
        DOMK domk = new DOMKImpl();
        domk.setVaerdi(50.5);
        assertEquals(domk.getVaerdi(), 50.5, DELTA);
    }

    @Test
    public void getVaerdi() {
        DOMK domk = new DOMKImpl();
        assertEquals(domk.getVaerdi(), Double.NaN, DELTA);
    }

    @Test
    public void testBeregnUdenVaerdier() {
        DOMK domkberegn = new DOMKImpl();
        domkberegn.init(new MOCKS.VOMock(Double.NaN), new MOCKS.STOMock(Double.NaN),
                new MOCKS.KOMock(Double.NaN), new MOCKS.VEMock(Double.NaN), new MOCKS.XMock(Double.NaN));
        domkberegn.initOver(new MOCKS.VOMock(Double.NaN), new MOCKS.XMock(Double.NaN), new MOCKS.DomkMock(Double.NaN));
        double resultat = Double.NaN;
        domkberegn.beregn();
        assertEquals(domkberegn.getVaerdi(), resultat, DELTA);
    }

    @Test
    public void testBeregn() {
        DOMK domkberegn = new DOMKImpl();
        domkberegn.init(new MOCKS.VOMock(310000), new MOCKS.STOMock(Double.NaN),
                new MOCKS.KOMock(Double.NaN), new MOCKS.VEMock(Double.NaN), new MOCKS.XMock(45000));
        domkberegn.initOver(new MOCKS.VOMock(280000), new MOCKS.XMock(40000), new MOCKS.DomkMock(Double.NaN));
        double resultat = 6;
        domkberegn.beregn();
        assertEquals(domkberegn.getVaerdi(), resultat, DELTA);
    }
}

