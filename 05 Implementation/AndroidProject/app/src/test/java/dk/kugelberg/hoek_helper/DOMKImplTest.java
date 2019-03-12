package dk.kugelberg.hoek_helper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import dk.kugelberg.hoek_helper.model.DOMK;
import dk.kugelberg.hoek_helper.model.DOMKImpl;
import dk.kugelberg.hoek_helper.model.NegativVaerdiException;
import dk.kugelberg.hoek_helper.model.XImpl;

import static org.junit.Assert.*;

public class DOMKImplTest {

    final double delta = 0.00000000000000000001;

    @Test
    public void getVaerdi() {
        DOMKImpl domk = new DOMKImpl();
        double resultat = Double.NaN;
        assertEquals(domk.getVaerdi(), resultat, delta);
        assertFalse(domk.erBeregnet());
    }

    @Test
    public void setVaerdi() {
        DOMKImpl domk = new DOMKImpl();
        domk.setVaerdi(5);
        double resultat = 5;
        assertEquals(domk.getVaerdi(), resultat, delta);
        assertFalse(domk.erBeregnet());
    }

    @Test
    public void beregnDOMKUdenTal() {
        DOMKImpl domk = new DOMKImpl();
        domk.initOver(new MOCKS.VOMock(Double.NaN), new MOCKS.XMock(Double.NaN), new MOCKS.DomkMock(Double.NaN));
        domk.init(new MOCKS.VOMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.KOMock(Double.NaN), new MOCKS.VEMock(Double.NaN), new MOCKS.XMock(Double.NaN));
        domk.beregn();
        assertEquals(domk.getVaerdi(), Double.NaN, delta);
        assertFalse(domk.erBeregnet());
    }

    @Test
    public void beregnDOMKMedTal() {
        DOMKImpl domk = new DOMKImpl();
        domk.initOver(new MOCKS.VOMock(280000), new MOCKS.XMock(40000), new MOCKS.DomkMock(Double.NaN));
        domk.init(new MOCKS.VOMock(310000), new MOCKS.STOMock(Double.NaN), new MOCKS.KOMock(Double.NaN), new MOCKS.VEMock(Double.NaN), new MOCKS.XMock(45000));
        domk.beregn();
        double forventetRestultat = 6;
        assertEquals(domk.getVaerdi(), forventetRestultat, delta);
        assertTrue(domk.erBeregnet());

    }
}
