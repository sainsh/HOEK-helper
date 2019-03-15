package dk.kugelberg.hoek_helper.integrationstests;

import org.junit.Test;

import dk.kugelberg.hoek_helper.MOCKS;
import dk.kugelberg.hoek_helper.model.KE;
import dk.kugelberg.hoek_helper.model.KEimpl;
import dk.kugelberg.hoek_helper.model.KO;
import dk.kugelberg.hoek_helper.model.KOImpl;
import dk.kugelberg.hoek_helper.model.X;
import dk.kugelberg.hoek_helper.model.XImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KEBeregningerTest {

    double delta = 0.000000001;

    @Test
    public void testAfKEMedKoOgX(){
        KE ke = new KEimpl();
        KO ko = new KOImpl();
        X x = new XImpl();

        ke.init(ko, x, new MOCKS.SEMock(Double.NaN), new MOCKS.VEMock(Double.NaN));

        ko.init(ke, x, new MOCKS.STOMock(Double.NaN), new MOCKS.VOMock(Double.NaN));

        x.init(new MOCKS.VOMock(Double.NaN), new MOCKS.VEMock(Double.NaN), new MOCKS.DomkMock(Double.NaN),
                new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN), ko, ke);

        ko.setVaerdi(55);
        x.setVaerdi(10);

        double forventetResultat = 5.5;

        ke.beregn();

        assertEquals(ke.getVaerdi(), forventetResultat, delta);
        assertTrue(ke.getBeregnet());
    }

    @Test
    public void testAfXMedKOOgKE(){
        KE ke = new KEimpl();
        KO ko = new KOImpl();
        X x = new XImpl();

        ke.init(ko, x, new MOCKS.SEMock(Double.NaN), new MOCKS.VEMock(Double.NaN));

        ko.init(ke, x, new MOCKS.STOMock(Double.NaN), new MOCKS.VOMock(Double.NaN));

        x.init(new MOCKS.VOMock(Double.NaN), new MOCKS.VEMock(Double.NaN), new MOCKS.DomkMock(Double.NaN),
                new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN), ko, ke);

        ko.setVaerdi(50);
        ke.setVaerdi(10);

        double forventetResultat = 5;

        x.beregn();

        assertEquals(forventetResultat, x.getVaerdi(), delta);
        assertTrue(x.getBeregnet());
    }

    @Test
    public void testAfKOMedXOgKE(){
        KE ke = new KEimpl();
        KO ko = new KOImpl();
        X x = new XImpl();

        ke.init(ko, x, new MOCKS.SEMock(Double.NaN), new MOCKS.VEMock(Double.NaN));

        ko.init(ke, x, new MOCKS.STOMock(Double.NaN), new MOCKS.VOMock(Double.NaN));

        x.init(new MOCKS.VOMock(Double.NaN), new MOCKS.VEMock(Double.NaN), new MOCKS.DomkMock(Double.NaN),
                new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN), ko, ke);

        x.setVaerdi(50);
        ke.setVaerdi(10);

        double forventetResultat = 500;

        ko.beregn();

        assertEquals(forventetResultat, ko.getVaerdi(), delta);
        assertTrue(ko.getBeregnet());
    }
}
