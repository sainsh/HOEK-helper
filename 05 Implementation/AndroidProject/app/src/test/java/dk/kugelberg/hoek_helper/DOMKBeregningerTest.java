package dk.kugelberg.hoek_helper;

import org.junit.Test;

import dk.kugelberg.hoek_helper.model.DOMK;
import dk.kugelberg.hoek_helper.model.DOMKImpl;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.VOImpl;
import dk.kugelberg.hoek_helper.model.X;
import dk.kugelberg.hoek_helper.model.XImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DOMKBeregningerTest {

    final double delta = 0.000000001;

    @Test
    public void testAfDOMKMedVOOgX(){
        X x1 = new XImpl();
        VO vo1 = new VOImpl();
        X x2 = new XImpl();
        VO vo2 = new VOImpl();
        DOMK domk = new DOMKImpl();

        x1.init(vo1, new MOCKS.VEMock(Double.NaN), domk, new MOCKS.STOMock(Double.NaN),
                new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN),
                new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        x1.initOver(new MOCKS.XMock(Double.NaN), new MOCKS.VOMock(Double.NaN));

        vo1.init(new MOCKS.VEMock(Double.NaN), x1, new MOCKS.KOMock(Double.NaN),
                domk, new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN),
                new MOCKS.DBMock(Double.NaN), new MOCKS.OMSMock(Double.NaN));
        vo1.initOver(new MOCKS.XMock(Double.NaN), new MOCKS.VOMock(Double.NaN));

        x2.init(vo2, new MOCKS.VEMock(Double.NaN), domk, new MOCKS.STOMock(Double.NaN),
                new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN),
                new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        x2.initOver(x1, vo1);

        vo2.init(new MOCKS.VEMock(Double.NaN), x2, new MOCKS.KOMock(Double.NaN),
                domk, new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN),
                new MOCKS.DBMock(Double.NaN), new MOCKS.OMSMock(Double.NaN));
        vo2.initOver(x1, vo1);

        domk.init(vo2, new MOCKS.STOMock(Double.NaN), new MOCKS.KOMock(Double.NaN),
                new MOCKS.VEMock(Double.NaN), x2);
        domk.initOver(vo1, x1, new MOCKS.DomkMock(Double.NaN));


        x1.setVaerdi(40000);
        vo1.setVaerdi(280000);
        x2.setVaerdi(45000);
        vo2.setVaerdi(310000);

        domk.beregn();


        double forventetResultat = 6;

        assertEquals(forventetResultat, domk.getVaerdi(), delta);
        assertTrue(domk.getBeregnet());
    }

    @Test
    public void testAfVOMedDOMKOgVOOgX(){
        X x1 = new XImpl();
        VO vo1 = new VOImpl();
        X x2 = new XImpl();
        VO vo2 = new VOImpl();
        DOMK domk = new DOMKImpl();

        x1.init(vo1, new MOCKS.VEMock(Double.NaN), new MOCKS.DomkMock(Double.NaN),
                new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN),
                new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        x1.initOver(new MOCKS.XMock(Double.NaN), new MOCKS.VOMock(Double.NaN));

        vo1.init(new MOCKS.VEMock(Double.NaN), x1, new MOCKS.KOMock(Double.NaN),
                new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN),
                new MOCKS.DBMock(Double.NaN), new MOCKS.OMSMock(Double.NaN));
        vo1.initOver(new MOCKS.XMock(Double.NaN), new MOCKS.VOMock(Double.NaN));

        x2.init(vo2, new MOCKS.VEMock(Double.NaN), domk,
                new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN),
                new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        x2.initOver(x1, vo1);

        vo2.init(new MOCKS.VEMock(Double.NaN), x2, new MOCKS.KOMock(Double.NaN),
                domk, new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN),
                new MOCKS.DBMock(Double.NaN), new MOCKS.OMSMock(Double.NaN));
        vo2.initOver(x1, vo1);

        domk.init(vo2, new MOCKS.STOMock(Double.NaN), new MOCKS.KOMock(Double.NaN),
                new MOCKS.VEMock(Double.NaN), x2);
        domk.initOver(vo1, x1, new MOCKS.DomkMock(Double.NaN));


        x1.setVaerdi(40000);
        vo1.setVaerdi(280000);
        x2.setVaerdi(45000);
        domk.setVaerdi(6);

        vo2.beregn();


        double forventetResultat = 310000;

        assertEquals(forventetResultat, vo2.getVaerdi(), delta);
        assertTrue(vo2.getBeregnet());
    }

    @Test
    public void testAfXMedDOMKOgVOOgX(){
        X x1 = new XImpl();
        VO vo1 = new VOImpl();
        X x2 = new XImpl();
        VO vo2 = new VOImpl();
        DOMK domk = new DOMKImpl();

        x1.init(vo1, new MOCKS.VEMock(Double.NaN), new MOCKS.DomkMock(Double.NaN),
                new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN),
                new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        x1.initOver(new MOCKS.XMock(Double.NaN), new MOCKS.VOMock(Double.NaN));

        vo1.init(new MOCKS.VEMock(Double.NaN), x1, new MOCKS.KOMock(Double.NaN),
                new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN),
                new MOCKS.DBMock(Double.NaN), new MOCKS.OMSMock(Double.NaN));
        vo1.initOver(new MOCKS.XMock(Double.NaN), new MOCKS.VOMock(Double.NaN));

        x2.init(vo2, new MOCKS.VEMock(Double.NaN), domk,
                new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN),
                new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        x2.initOver(x1, vo1);

        vo2.init(new MOCKS.VEMock(Double.NaN), x2, new MOCKS.KOMock(Double.NaN),
                domk, new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN),
                new MOCKS.DBMock(Double.NaN), new MOCKS.OMSMock(Double.NaN));
        vo2.initOver(x1, vo1);

        domk.init(vo2, new MOCKS.STOMock(Double.NaN), new MOCKS.KOMock(Double.NaN),
                new MOCKS.VEMock(Double.NaN), x2);
        domk.initOver(vo1, x1, new MOCKS.DomkMock(Double.NaN));


        x1.setVaerdi(40000);
        vo1.setVaerdi(280000);
        vo2.setVaerdi(310000);
        domk.setVaerdi(6);

        x2.beregn();


        double forventetResultat = 45000;

        assertEquals(forventetResultat, x2.getVaerdi(), delta);
        assertTrue(x2.getBeregnet());
    }
}
