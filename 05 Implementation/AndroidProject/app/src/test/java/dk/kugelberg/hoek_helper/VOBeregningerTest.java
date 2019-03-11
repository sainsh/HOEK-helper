package dk.kugelberg.hoek_helper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import dk.kugelberg.hoek_helper.model.VE;
import dk.kugelberg.hoek_helper.model.VEImpl;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.VOImpl;
import dk.kugelberg.hoek_helper.model.X;
import dk.kugelberg.hoek_helper.model.XImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VOBeregningerTest {

    final double delta = 0.000000001;

    @Test
    public void TestAfVOMedXOgVE(){
        VO vo = new VOImpl();
        X x = new XImpl();
        VE ve = new VEImpl();

        vo.init(ve, x, new MOCKS.KOMock(Double.NaN),
                new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN),
                new MOCKS.DBMock(Double.NaN), new MOCKS.OMSMock(Double.NaN));

        x.init(vo, ve, new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN),
                new MOCKS.GromkMock(Double.NaN), new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));

        ve.init(vo, x, new MOCKS.SEMock(Double.NaN), new MOCKS.KEMock(Double.NaN));

        x.setVaerdi(10);
        ve.setVaerdi(10.5);

        vo.beregn();

        double forventetResultat = 105;
        assertEquals(vo.getVaerdi(), forventetResultat, 0);
        assertTrue(vo.getBeregnet());
    }

    @Test
    public void TestAfXMedVOOgVE(){
        VO vo = new VOImpl();
        X x = new XImpl();
        VE ve = new VEImpl();

        vo.init(ve, x, new MOCKS.KOMock(Double.NaN),
                new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN),
                new MOCKS.DBMock(Double.NaN), new MOCKS.OMSMock(Double.NaN));

        x.init(vo, ve, new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN),
                new MOCKS.GromkMock(Double.NaN), new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));

        ve.init(vo, x, new MOCKS.SEMock(Double.NaN), new MOCKS.KEMock(Double.NaN));

        vo.setVaerdi(11);
        ve.setVaerdi(5.5);

        x.beregn();

        double forventetResultat = 2;
        assertEquals(x.getVaerdi(), forventetResultat, 0);
        assertTrue(x.getBeregnet());
    }

    @Test
    public void TestAfVEMedXOgVO(){
        VO vo = new VOImpl();
        X x = new XImpl();
        VE ve = new VEImpl();

        vo.init(ve, x, new MOCKS.KOMock(Double.NaN),
                new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN),
                new MOCKS.DBMock(Double.NaN), new MOCKS.OMSMock(Double.NaN));

        x.init(vo, ve, new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN),
                new MOCKS.GromkMock(Double.NaN), new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));

        ve.init(vo, x, new MOCKS.SEMock(Double.NaN), new MOCKS.KEMock(Double.NaN));

        x.setVaerdi(5);
        vo.setVaerdi(15);

        ve.beregn();

        double forventetResultat = 3;
        assertEquals(ve.getVaerdi(), forventetResultat, 0);
        assertTrue(ve.getBeregnet());
    }
}
