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
        gromk.init(new MOCKS.XMock(10), new MOCKS.STOMock(10));
        gromk.initOver(new MOCKS.XMock(5),new MOCKS.STOMock(5));
        gromk.beregn();
        double resultat = 1;
        assertEquals(gromk.getVaerdi(),resultat,0.00000000001);
    }

    @Test
    public void testBeregnGROMKUdenTal(){
        GROMKImpl gromk = new GROMKImpl();
        gromk.init(new MOCKS.XMock(Double.NaN), new MOCKS.STOMock(Double.NaN));
        gromk.initOver(new MOCKS.XMock(Double.NaN),new MOCKS.STOMock(Double.NaN));
        gromk.beregn();
        double resultat = Double.NaN;
        assertEquals(gromk.getVaerdi(),resultat,0.00000000001);
    }
}