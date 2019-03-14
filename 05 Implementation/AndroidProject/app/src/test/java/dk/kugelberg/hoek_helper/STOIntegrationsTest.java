package dk.kugelberg.hoek_helper;

import org.junit.Test;

import dk.kugelberg.hoek_helper.model.GROMKImpl;
import dk.kugelberg.hoek_helper.model.KOImpl;
import dk.kugelberg.hoek_helper.model.SEImpl;
import dk.kugelberg.hoek_helper.model.STO;
import dk.kugelberg.hoek_helper.model.STOImpl;
import dk.kugelberg.hoek_helper.model.VOImpl;
import dk.kugelberg.hoek_helper.model.XImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class STOIntegrationsTest {

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

        VOImpl voimpl = new VOImpl();

        voimpl.setVaerdi(5);

        KOImpl koimpl = new KOImpl();

        koimpl.setVaerdi(5);

        sto.init(new XImpl(),voimpl,koimpl, new SEImpl(), new GROMKImpl());

        sto.beregn();

        assertEquals(sto.getVaerdi(), 10, delta);
        assertTrue(sto.getBeregnet());

    }

    @Test
    public void testBeregnSTOMedSEOgX() {

        STO sto = new STOImpl();

        SEImpl seimpl = new SEImpl();

        seimpl.setVaerdi(5);

        XImpl ximpl = new XImpl();

        ximpl.setVaerdi(5);

        sto.init(ximpl, new VOImpl(), new KOImpl(),seimpl, new GROMKImpl());

        sto.beregn();

        assertEquals(sto.getVaerdi(), 25, delta);
        assertTrue(sto.getBeregnet());

    }

    @Test
    public void testBeregnUdenVaerdier() {

        STO sto = new STOImpl();

        sto.init(new XImpl(), new VOImpl(), new KOImpl(), new SEImpl(), new GROMKImpl());

        sto.beregn();

        assertFalse(sto.getBeregnet());

    }
}
