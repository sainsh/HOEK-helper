package dk.kugelberg.hoek_helper;

import org.junit.Test;

import dk.kugelberg.hoek_helper.model.KO;
import dk.kugelberg.hoek_helper.model.KOImpl;
import dk.kugelberg.hoek_helper.model.STO;
import dk.kugelberg.hoek_helper.model.STOImpl;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.VOImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KOBeregningerTest {

    final double delta = 0.000000001;

    @Test
    public void TestAfKOMedSTOOgVO() {
        VO vo = new VOImpl();
        STO sto = new STOImpl();
        KO ko = new KOImpl();


        vo.init(new MOCKS.VEMock(Double.NaN), new MOCKS.XMock(Double.NaN), ko,
                new MOCKS.DomkMock(Double.NaN), sto, new MOCKS.SEMock(Double.NaN),
                new MOCKS.DBMock(Double.NaN), new MOCKS.OMSMock(Double.NaN));

        sto.init(new MOCKS.XMock(Double.NaN), vo, ko,
                new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN));

        ko.init(new MOCKS.KEMock(Double.NaN), new MOCKS.XMock(Double.NaN), sto, vo);

        sto.setVaerdi(100);
        vo.setVaerdi(45.5);
        ko.beregn();

        double forventetResultat = 54.5;

        assertEquals(forventetResultat, ko.getVaerdi(), delta);
        assertTrue(ko.getBeregnet());
    }

    @Test
    public void TestAfVOMedSTOOgKO() {
        VO vo = new VOImpl();
        STO sto = new STOImpl();
        KO ko = new KOImpl();


        vo.init(new MOCKS.VEMock(Double.NaN), new MOCKS.XMock(Double.NaN), ko,
                new MOCKS.DomkMock(Double.NaN), sto, new MOCKS.SEMock(Double.NaN),
                new MOCKS.DBMock(Double.NaN), new MOCKS.OMSMock(Double.NaN));

        sto.init(new MOCKS.XMock(Double.NaN), vo, ko,
                new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN));

        ko.init(new MOCKS.KEMock(Double.NaN), new MOCKS.XMock(Double.NaN), sto, vo);

        sto.setVaerdi(100);
        ko.setVaerdi(45.5);
        vo.beregn();

        double forventetResultat = 54.5;

        assertEquals(forventetResultat, vo.getVaerdi(), delta);
        assertTrue(vo.getBeregnet());
    }

    @Test
    public void TestAfSTOMedKOOgVO() {
        VO vo = new VOImpl();
        STO sto = new STOImpl();
        KO ko = new KOImpl();


        vo.init(new MOCKS.VEMock(Double.NaN), new MOCKS.XMock(Double.NaN), new MOCKS.KOMock(Double.NaN),
                new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN),
                new MOCKS.DBMock(Double.NaN), new MOCKS.OMSMock(Double.NaN));

        sto.init(new MOCKS.XMock(Double.NaN), vo, ko,
                new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN));

        ko.init(new MOCKS.KEMock(Double.NaN), new MOCKS.XMock(Double.NaN), sto, vo);

        ko.setVaerdi(100);
        vo.setVaerdi(45.5);
        sto.beregn();

        double forventetResultat = 145.5;

        assertEquals(forventetResultat, sto.getVaerdi(), delta);
        assertTrue(sto.getBeregnet());
    }
}
