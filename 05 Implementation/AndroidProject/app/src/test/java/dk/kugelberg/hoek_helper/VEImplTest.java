package dk.kugelberg.hoek_helper;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import dk.kugelberg.hoek_helper.model.KE;
import dk.kugelberg.hoek_helper.model.NegativVaerdiException;
import dk.kugelberg.hoek_helper.model.SE;
import dk.kugelberg.hoek_helper.model.VE;
import dk.kugelberg.hoek_helper.model.VEImpl;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.X;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import static org.junit.Assert.*;

public class VEImplTest {

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    final double delta = 0.00000000000000000001;

    @Test
    public void testSaetVETil45() {
        VEImpl ve = new VEImpl();
        ve.setVaerdi(45);
        assertEquals(ve.getVaerdi(), 45, delta);

        assertFalse(ve.getBeregnet());
    }

    @Test
    public void setVaerdi() {
        VEImpl d = new VEImpl();
        d.setVaerdi(45);
        assertEquals(d.getVaerdi(),45,delta);
    }

    @Test
    public void getVaerdi() {
        VEImpl d = new VEImpl();
        d.setVaerdi(45);
        assertEquals(d.getVaerdi(),45,delta);
    }

    /**
    @Test
    public void testAfVEStandardVaerdi() {
        VEImpl ve = new VEImpl();

    }
     */

    // kontrollerer om VO/X formlen virker
    @Test
    public void testBeregnVEMedVOFormel() {
        VEImpl ve = new VEImpl();
        ve.init(new MOCKS.VOMock(5), new MOCKS.XMock(5), new MOCKS.SEMock(Double.NaN), new MOCKS.KEMock(Double.NaN));
        double resultat = 1;
        ve.beregn();
        assertEquals(ve.getVaerdi(), resultat, delta);
        assertTrue(ve.getBeregnet());
    }

    // kontrollerer om SE - KE formlen virker
    @Test
    public void testBeregnVEMedSEKEFormel() {
        VEImpl ve = new VEImpl();
        ve.init(new MOCKS.VOMock(Double.NaN), new MOCKS.XMock(Double.NaN), new MOCKS.SEMock(3), new MOCKS.KEMock(2));
        double resultat = 1;
        ve.beregn();
        assertEquals(ve.getVaerdi(), resultat, delta);
        assertTrue(ve.getBeregnet());
    }

    // kontrollerer om VE bliver udregnet når der mangler et tal
    @Test
    public void testBeregnVEMedManglendeX() {
        VEImpl ve = new VEImpl();
        ve.init(new MOCKS.VOMock(5), new MOCKS.XMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.KEMock(Double.NaN));
        double resultat = Double.NaN;
        ve.beregn();
        assertEquals(ve.getVaerdi(), resultat, delta);
        assertFalse(ve.getBeregnet());
    }

    // tester om VE bliver udregnet når der bliver indtastet et negativt tal
    @Test
    public void testBeregnVEMedNegativeTal() {
        VEImpl ve = new VEImpl();
        ve.init(new MOCKS.VOMock(-5), new MOCKS.XMock(5), new MOCKS.SEMock(Double.NaN), new MOCKS.KEMock(Double.NaN));
        double resultat = Double.NaN;

        try {
            ve.beregn();
        }catch (NegativVaerdiException nve) {
            return;
        } assertTrue(ve.getBeregnet());
        fail();
    }


}
