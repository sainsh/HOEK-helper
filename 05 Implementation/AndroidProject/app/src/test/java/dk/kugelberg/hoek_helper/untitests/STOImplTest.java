package dk.kugelberg.hoek_helper.untitests;

import org.junit.Test;


import dk.kugelberg.hoek_helper.MOCKS;
import dk.kugelberg.hoek_helper.model.STO;
import dk.kugelberg.hoek_helper.model.STOImpl;

import static org.junit.Assert.*;

public class STOImplTest {

    final double delta = 0.00000000000000000001;


    @Test
    public void testSaetSTOTil45() {
        STO sto = new STOImpl();

        sto.setVaerdi(45);

        assertEquals(45, sto.getVaerdi(), delta);

    }

    @Test
    public void testSTOStandardVaerdi() {
        STO sto = new STOImpl();

        assertTrue(Double.isNaN(sto.getVaerdi()));
    }

    @Test
    public void testBeregnSTOMedVOOgKO() {

        STO sto = new STOImpl();

        sto.init(new MOCKS.XMock(Double.NaN), new MOCKS.VOMock(45.2), new MOCKS.KOMock(42.3), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN));

        sto.beregn();

        assertEquals(sto.getVaerdi(), 87.5, delta);
        assertTrue(sto.getBeregnet());

    }

    @Test
    public void testBeregnSTOMedSEOgX() {

        STO sto = new STOImpl();

        sto.init(new MOCKS.XMock(2000), new MOCKS.VOMock(Double.NaN), new MOCKS.KOMock(Double.NaN), new MOCKS.SEMock(45.5), new MOCKS.GromkMock(Double.NaN));

        sto.beregn();

        assertEquals(sto.getVaerdi(), 91000, delta);
        assertTrue(sto.getBeregnet());

    }

    @Test
    public void testBeregnUdenVaerdier() {

        STO sto = new STOImpl();

        sto.init(new MOCKS.XMock(Double.NaN), new MOCKS.VOMock(Double.NaN), new MOCKS.KOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN));

        sto.beregn();

        assertFalse(sto.getBeregnet());

    }
}
