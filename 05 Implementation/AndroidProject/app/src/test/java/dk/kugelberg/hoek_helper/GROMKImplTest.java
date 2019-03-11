package dk.kugelberg.hoek_helper;

import org.junit.Test;

import dk.kugelberg.hoek_helper.model.DOMKImpl;
import dk.kugelberg.hoek_helper.model.GROMKImpl;
import dk.kugelberg.hoek_helper.model.KOImpl;
import dk.kugelberg.hoek_helper.model.SEImpl;
import dk.kugelberg.hoek_helper.model.STOImpl;
import dk.kugelberg.hoek_helper.model.VEImpl;
import dk.kugelberg.hoek_helper.model.XImpl;

import static org.junit.Assert.*;

public class GROMKImplTest {

    private GROMKImpl gromk = new GROMKImpl();

    @Test
    public void testSetOgGetVaerdi() {
        gromk.setVaerdi(10);
        assertEquals(gromk.getVaerdi(), 10, 0);

        gromk.setVaerdi(20);
        assertNotEquals(gromk.getVaerdi(), 15, 0);
    }

    @Test
    public void testSetOgGetBeregnet() {
        gromk.setBeregnet(true);
        assertTrue(gromk.getBeregnet());

        gromk.setBeregnet(false);
        assertFalse(gromk.getBeregnet());
    }

    @Test
    public void testBeregnGROMK() {
        XImpl x1 = new XImpl();
        x1.setVaerdi(20);

        STOImpl sto1 = new STOImpl();
        sto1.setVaerdi(2600);

        gromk.init(x1, sto1);

        XImpl x2 = new XImpl();
        x2.setVaerdi(10);

        STOImpl sto2 = new STOImpl();
        sto2.setVaerdi(2350);

        gromk.initOver(x2, sto2);

        gromk.beregn();
        assertEquals(gromk.getVaerdi(), 25, 0);
        assertNotEquals(gromk.getVaerdi(), 99, 0);
    }
}