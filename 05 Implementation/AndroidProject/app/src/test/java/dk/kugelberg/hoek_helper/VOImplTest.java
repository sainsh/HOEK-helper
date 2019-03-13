package dk.kugelberg.hoek_helper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import dk.kugelberg.hoek_helper.model.DB;
import dk.kugelberg.hoek_helper.model.DOMK;
import dk.kugelberg.hoek_helper.model.GROMK;
import dk.kugelberg.hoek_helper.model.KE;
import dk.kugelberg.hoek_helper.model.KO;
import dk.kugelberg.hoek_helper.model.OMS;
import dk.kugelberg.hoek_helper.model.SE;
import dk.kugelberg.hoek_helper.model.STO;
import dk.kugelberg.hoek_helper.model.VE;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.VOImpl;
import dk.kugelberg.hoek_helper.model.X;
import dk.kugelberg.hoek_helper.model.XImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VOImplTest {

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();


    @Test
    public void testSetVaerdiTil45() {

        VO vo = new VOImpl();
        vo.setVaerdi(45);
        assertEquals(vo.getVaerdi(),45,0);
    }

    @Test
    public void testGetVaerdi45() {

        VO vo = new VOImpl();
        vo.setVaerdi(45);
        assertEquals(vo.getVaerdi(),45,0);
    }

    @Test
    public void testAfVOStandardVaerdi(){
        VO vo = new VOImpl();

        vo.init(new MOCKS.VEMock(Double.NaN), new MOCKS.XMock(Double.NaN), new MOCKS.KOMock(Double.NaN),
                new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN),
                new MOCKS.DBMock(Double.NaN), new MOCKS.OMSMock(Double.NaN));
        vo.initOver(new MOCKS.XMock(Double.NaN), new MOCKS.VOMock(Double.NaN));
        vo.initUnder(new MOCKS.XMock(Double.NaN), new MOCKS.VOMock(Double.NaN), new MOCKS.DomkMock(Double.NaN));

        double forventetResultat = Double.NaN;
        assertEquals(vo.getVaerdi(), forventetResultat, 0);
        assertFalse(vo.getBeregnet());
    }

    @Test
    public void testAfBeregnFunktion(){
        VO vo = new VOImpl();

        vo.init(new MOCKS.VEMock(Double.NaN), new MOCKS.XMock(Double.NaN), new MOCKS.KOMock(Double.NaN),
                new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN),
                new MOCKS.DBMock(Double.NaN), new MOCKS.OMSMock(Double.NaN));
        vo.initOver(new MOCKS.XMock(Double.NaN), new MOCKS.VOMock(Double.NaN));
        vo.initUnder(new MOCKS.XMock(Double.NaN), new MOCKS.VOMock(Double.NaN), new MOCKS.DomkMock(Double.NaN));

        double forventetResultat = Double.NaN;
        vo.beregn();
        assertEquals(vo.getVaerdi(), forventetResultat, 0);
        assertFalse(vo.getBeregnet());
    }


    @Test
    public void testAfBeregnVOMedVEOgX(){
        VO vo = new VOImpl();

        vo.init(new MOCKS.VEMock(10.5), new MOCKS.XMock(10.5), new MOCKS.KOMock(Double.NaN),
                new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN),
                new MOCKS.DBMock(Double.NaN), new MOCKS.OMSMock(Double.NaN));

        double forventetResultat = 110.25;
        vo.beregn();
        assertEquals(vo.getVaerdi(), forventetResultat, 0);
        assertTrue(vo.getBeregnet());
    }

    @Test
    public void testAfBeregnVOMedSTOOgKO(){
        VO vo = new VOImpl();

        vo.init(new MOCKS.VEMock(Double.NaN), new MOCKS.XMock(Double.NaN), new MOCKS.KOMock(50.5),
                new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(100.5), new MOCKS.SEMock(Double.NaN),
                new MOCKS.DBMock(Double.NaN), new MOCKS.OMSMock(Double.NaN));

        double forventetResultat = 50;
        vo.beregn();
        assertEquals(vo.getVaerdi(), forventetResultat, 0);
        assertTrue(vo.getBeregnet());
    }

    @Test
    public void testAfBeregnVOMedDBOgOMS(){
        VO vo = new VOImpl();

        vo.init(new MOCKS.VEMock(Double.NaN), new MOCKS.XMock(Double.NaN), new MOCKS.KOMock(Double.NaN),
                new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN),
                new MOCKS.DBMock(100.5), new MOCKS.OMSMock(50.5));

        double forventetResultat = 50;
        vo.beregn();
        assertEquals(vo.getVaerdi(), forventetResultat, 0);
        assertTrue(vo.getBeregnet());
    }

    @Test
    public void testAfBeregnVOMedDOMKFormel() {
        VO vo = new VOImpl();

        vo.init(new MOCKS.VEMock(Double.NaN), new MOCKS.XMock(45000), new MOCKS.KOMock(Double.NaN),
                new MOCKS.DomkMock(6), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN),
                new MOCKS.DBMock(Double.NaN), new MOCKS.OMSMock(Double.NaN));
        vo.initOver(new MOCKS.XMock(40000), new MOCKS.VOMock(280000));

        double forventetResultat = 310000;
        vo.beregn();
        assertEquals(vo.getVaerdi(), forventetResultat, 0);
        assertTrue(vo.getBeregnet());
    }
}