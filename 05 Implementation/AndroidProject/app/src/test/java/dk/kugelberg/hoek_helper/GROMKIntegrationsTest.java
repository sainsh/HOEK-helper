package dk.kugelberg.hoek_helper;

import org.junit.Test;

import dk.kugelberg.hoek_helper.model.GROMKImpl;
import dk.kugelberg.hoek_helper.model.STOImpl;
import dk.kugelberg.hoek_helper.model.XImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class GROMKIntegrationsTest {
    private GROMKImpl gromk = new GROMKImpl();

    @Test
    public void testSetOgGetVaerdi() {
        assertEquals(gromk.getVaerdi(),Double.NaN,0.0000000001);
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
    public void testBeregnGROMK2(){
        GROMKImpl gromk = new GROMKImpl();

        XImpl ximpl = new XImpl();
        XImpl ximpl2 = new XImpl();
        ximpl.setVaerdi(10);
        ximpl2.setVaerdi(5);

        STOImpl stoimpl = new STOImpl();
        STOImpl stoimpl2 = new STOImpl();
        stoimpl.setVaerdi(10);
        stoimpl2.setVaerdi(5);

        gromk.init(ximpl, stoimpl);
        gromk.initOver(ximpl2, stoimpl2);
        gromk.beregn();
        double resultat = 1;
        assertEquals(gromk.getVaerdi(),resultat,0.00000000001);
    }

    @Test
    public void testBeregnGROMKUdenTal() {
        GROMKImpl gromk = new GROMKImpl();

        gromk.init(new MOCKS.XMock(Double.NaN), new MOCKS.STOMock(Double.NaN));
        gromk.initOver(new XImpl(), new STOImpl());
        gromk.beregn();
        double resultat = Double.NaN;
        assertEquals(gromk.getVaerdi(), resultat, 0.00000000001);
    }
}
