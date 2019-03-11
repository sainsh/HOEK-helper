package dk.kugelberg.hoek_helper;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import dk.kugelberg.hoek_helper.model.KE;
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

    /**
    @Test
    public void testAfVEStandardVaerdi() {
        VEImpl ve = new VEImpl();

    }
     */

    // kontrollerer om VO/X formlen virker
    /**
    @Test
    public void testBeregnMedVOFormel() {
        VEImpl ve = new VEImpl();
        ve.init(new VEMock(Double.NaN), new VOMock(Double.NaN), );
        double resultat = Double.NaN;
        ve.beregn();
        assertEquals();
        assertFalse();
    }
     */

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
}
