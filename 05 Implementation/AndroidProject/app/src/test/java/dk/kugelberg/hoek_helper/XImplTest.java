package dk.kugelberg.hoek_helper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


import dk.kugelberg.hoek_helper.model.NegativVaerdiException;
import dk.kugelberg.hoek_helper.model.XImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class XImplTest {

    @Rule
    //public TestRule rule = new InstantTaskExecutorRule();


    final double delta = 0.00000000000000000001;

    //Kontrollere om setVaerdi fungere og ændre tallet til 45.
    @Test
    public void testSaetXTil45() {
        XImpl x = new XImpl();
        x.setVaerdi(45.9);
        assertEquals(x.getVaerdi(), 45, delta);
        assertFalse(x.getBeregnet());
    }

    //Kontrollere at Init ikke ændre værdien.
    @Test
    public void testAfXStandardVaerdi()
    {
        XImpl x = new XImpl();
        x.initOver(new MOCKS.XMock(Double.NaN),new MOCKS.VOMock(Double.NaN));
        x.init(new MOCKS.VOMock(Double.NaN), new MOCKS.VEMock(Double.NaN), new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN), new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        assertEquals(x.getVaerdi(), Double.NaN, delta);
        assertFalse(x.getBeregnet());
    }

    //Kontrollerer om DOMK formlen virker
    @Test
    public void testBeregnMedDOMKFormel() {
        XImpl x = new XImpl();
        x.initOver(new MOCKS.XMock(Double.NaN),new MOCKS.VOMock(Double.NaN));
        x.init(new MOCKS.VOMock(Double.NaN), new MOCKS.VEMock(Double.NaN), new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN), new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        //x.initOver();
        double resultat = Double.NaN;
        x.beregn();
        assertEquals(x.getVaerdi(), resultat, delta);
        assertFalse(x.getBeregnet());
    }

    //Kontrolllerer at x vaerdien ikke blive ændret når formlen ikke er tilstrækkelig
    @Test
    public void testBeregnMedDOMKFormelMedManglendeTal() {
        XImpl x = new XImpl();
        x.initOver(new MOCKS.XMock(Double.NaN),new MOCKS.VOMock(Double.NaN));
        x.init(new MOCKS.VOMock(Double.NaN),new MOCKS.VEMock(Double.NaN),new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN), new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        double resultat = Double.NaN;
        x.beregn();
        assertEquals(x.getVaerdi(),resultat,delta);
        System.out.println(x.getBeregnet());
        assertFalse(x.getBeregnet());
    }

    //Kontrollerer om Groms formlen for x virker
    @Test
    public void testBeregnMedGROMSFormel() {
        XImpl x = new XImpl();
        x.initOver(new MOCKS.XMock(Double.NaN),new MOCKS.VOMock(Double.NaN));
        x.init(new MOCKS.VOMock(Double.NaN), new MOCKS.VEMock(Double.NaN), new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(2), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(2), new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        double resultat = 4;
        x.beregn();
        assertEquals(x.getVaerdi(), resultat, delta);
        assertTrue(x.getBeregnet());
    }


    //Hvis nedenstående fungere vil resultatet Double.NaN da den ikke kan udregnes
    @Test
    public void testBeregnUdenværdier() {
        XImpl x = new XImpl();
        x.initOver(new MOCKS.XMock(Double.NaN),new MOCKS.VOMock(Double.NaN));
        x.init(new MOCKS.VOMock(Double.NaN), new MOCKS.VEMock(Double.NaN), new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN), new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        double resultat = Double.NaN;
        x.beregn();
        assertEquals(x.getVaerdi(), resultat, delta);
        assertFalse(x.getBeregnet());
    }

    //Kontrollerer om x kan udregnes med VE og VO
    @Test
    public void testBeregnXmedVEogVO() {
        XImpl x = new XImpl();
        x.initOver(new MOCKS.XMock(Double.NaN),new MOCKS.VOMock(Double.NaN));
        x.init(new MOCKS.VOMock(10), new MOCKS.VEMock(5), new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN), new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        double resultat = 2;
        x.beregn();
        assertEquals(x.getVaerdi(), resultat, delta);
        assertTrue(x.getBeregnet());
    }

    //Kontrollerer om x blive ændret med negativ x? "SKAL IKKE SKE"
    @Test
    public void testBeregnXmedNegativVEogVO() {
        XImpl x = new XImpl();
        x.initOver(new MOCKS.XMock(Double.NaN),new MOCKS.VOMock(Double.NaN));
        x.init(new MOCKS.VOMock(10), new MOCKS.VEMock(-5), new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN), new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        double resultat = Double.NaN;

        try {
            x.beregn();
        }catch (NegativVaerdiException nve){
            return;
        } assertFalse(x.getBeregnet());
        fail();


    }

    //Kontrollerer om x blive ændret ligesom overstående.
    @Test
    public void testBeregnXmedVEogNegativVO() {
        XImpl x = new XImpl();
        x.initOver(new MOCKS.XMock(Double.NaN),new MOCKS.VOMock(Double.NaN));
        x.init(new MOCKS.VOMock(-10), new MOCKS.VEMock(5), new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN), new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        double resultat = Double.NaN;
        try {
            x.beregn();
        }catch (NegativVaerdiException nve){
            return;
        } assertFalse(x.getBeregnet());
        fail();
    }

    //Hvis nedenstående fungere vil resultatet være 2. da 10/5 = 2
    @Test
    public void testBeregnXmedDOMKogVO() {
        XImpl x = new XImpl();
        x.initOver(new MOCKS.XMock(0),new MOCKS.VOMock(0));
        x.init(new MOCKS.VOMock(5), new MOCKS.VEMock(Double.NaN), new MOCKS.DomkMock(10), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN), new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        double resultat = 50;
        x.beregn();
        assertEquals(x.getVaerdi(), resultat, delta);
        assertTrue(x.getBeregnet());
    }

    @Test
    public void testBeregnXMedDOMKogNegativVO() {
        XImpl x = new XImpl();
        x.initOver(new MOCKS.XMock(0),new MOCKS.VOMock(0));
        x.init(new MOCKS.VOMock(-10), new MOCKS.VEMock(Double.NaN), new MOCKS.DomkMock(5), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN), new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        double resultat = Double.NaN;
        try {
            x.beregn();
        }catch (NegativVaerdiException nve){
            return;
        } assertFalse(x.getBeregnet());
        fail();
    }

    @Test
    public void testBeregnXMedNegativDOMKogVO() {
        XImpl x = new XImpl();
        x.initOver(new MOCKS.XMock(0),new MOCKS.VOMock(0));
        x.init(new MOCKS.VOMock(10), new MOCKS.VEMock(Double.NaN), new MOCKS.DomkMock(-5), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN), new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        double resultat = Double.NaN;
        try {
            x.beregn();
        }catch (NegativVaerdiException nve){
            return;
        } assertFalse(x.getBeregnet());
        fail();
    }

    //Nedenstående metode tjekker om den udregner med en formel der ikke findes.
    @Test
    public void testBeregnXmedDOMKogVE() {
        XImpl x = new XImpl();
        x.initOver(new MOCKS.XMock(Double.NaN),new MOCKS.VOMock(Double.NaN));
        x.init(new MOCKS.VOMock(Double.NaN), new MOCKS.VEMock(10), new MOCKS.DomkMock(5), new MOCKS.STOMock(Double.NaN), new MOCKS.SEMock(Double.NaN), new MOCKS.GromkMock(Double.NaN), new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        double resultat = Double.NaN;
        x.beregn();
        assertEquals(x.getVaerdi(), resultat, delta);
        assertFalse(x.getBeregnet());
    }

    //Kontrollerer at x vaerdien blive ændret.
    @Test
    public void testBeregnXMedSTOogSE() {
        XImpl x = new XImpl();
        x.initOver(new MOCKS.XMock(Double.NaN),new MOCKS.VOMock(Double.NaN));
        x.init(new MOCKS.VOMock(Double.NaN), new MOCKS.VEMock(Double.NaN), new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(10), new MOCKS.SEMock(10), new MOCKS.GromkMock(Double.NaN), new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        double resultat = 1;
        x.beregn();
        assertEquals(x.getVaerdi(), resultat, delta);
        assertTrue(x.getBeregnet());

    }

    @Test
    public void testBeregnXMedSTOogNegativSE() {
        XImpl x = new XImpl();
        x.initOver(new MOCKS.XMock(Double.NaN),new MOCKS.VOMock(Double.NaN));
        x.init(new MOCKS.VOMock(Double.NaN), new MOCKS.VEMock(Double.NaN), new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(-10), new MOCKS.SEMock(10), new MOCKS.GromkMock(Double.NaN), new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        double resultat = Double.NaN;
        try {
            x.beregn();
        }catch (NegativVaerdiException nve){
            return;
        } assertFalse(x.getBeregnet());
        fail();
    }

    @Test
    public void testBeregnXMedNegativSTOogSE() {
        XImpl x = new XImpl();
        x.initOver(new MOCKS.XMock(Double.NaN),new MOCKS.VOMock(Double.NaN));
        x.init(new MOCKS.VOMock(Double.NaN), new MOCKS.VEMock(Double.NaN), new MOCKS.DomkMock(Double.NaN), new MOCKS.STOMock(-10), new MOCKS.SEMock(10), new MOCKS.GromkMock(Double.NaN), new MOCKS.KOMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        double resultat = Double.NaN;
        try {
            x.beregn();
        }catch (NegativVaerdiException nve){
            return;
        } assertFalse(x.getBeregnet());
        fail();
    }


    //Opretter Mock klasser for at undgå at det er fejlen i de benyttede klasser der gør at testen ikke lykkes.
    //Mock klasser skal være så simple at man fjerner/mindsker risikoen for at fejlen er i den klasse.
   }