package dk.kugelberg.hoek_helper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import dk.kugelberg.hoek_helper.model.DOMK;
import dk.kugelberg.hoek_helper.model.GROMK;
import dk.kugelberg.hoek_helper.model.KE;
import dk.kugelberg.hoek_helper.model.KO;
import dk.kugelberg.hoek_helper.model.NegativVaerdiException;
import dk.kugelberg.hoek_helper.model.SE;
import dk.kugelberg.hoek_helper.model.STO;
import dk.kugelberg.hoek_helper.model.VE;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.X;
import dk.kugelberg.hoek_helper.model.XImpl;

import static org.junit.Assert.*;

public class XImplTest {

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();


    final double delta = 0.00000000000000000001;

    //Kontrollere om setVaerdi fungere og ændre tallet til 45.
    @Test
    public void testSaetXTil45() {
        XImpl x = new XImpl();
        x.setVaerdi(45.5);
        assertEquals(x.getVaerdi(), 45.5, delta);
        assertFalse(x.getBeregnet());
    }

    //Kontrollere at Init ikke ændre værdien.
    @Test
    public void testAfXStandardVaerdi() {
        XImpl x = new XImpl();
        x.initOver(new XMock(Double.NaN),new VOMock(Double.NaN));
        x.init(new VOMock(Double.NaN), new VEMock(Double.NaN), new DomkMock(Double.NaN), new STOMock(Double.NaN), new SEMock(Double.NaN), new GROMKMock(Double.NaN), new KOMock(Double.NaN),new KEMock(Double.NaN));
        assertEquals(x.getVaerdi(), Double.NaN, delta);
        assertFalse(x.getBeregnet());
    }

    //Kontrollerer om DOMK formlen virker
    @Test
    public void testBeregnMedDOMKFormel() {
        XImpl x = new XImpl();
        x.initOver(new XMock(Double.NaN),new VOMock(Double.NaN));
        x.init(new VOMock(Double.NaN), new VEMock(Double.NaN), new DomkMock(Double.NaN), new STOMock(Double.NaN), new SEMock(Double.NaN), new GROMKMock(Double.NaN), new KOMock(Double.NaN),new KEMock(Double.NaN));
        //x.init1();
        double resultat = Double.NaN;
        x.beregn();
        assertEquals(x.getVaerdi(), resultat, delta);
        assertFalse(x.getBeregnet());
    }

    //Kontrolllerer at x vaerdien ikke blive ændret når formlen ikke er tilstrækkelig
    @Test
    public void testBeregnMedDOMKFormelMedManglendeTal() {
        XImpl x = new XImpl();
        x.initOver(new XMock(Double.NaN),new VOMock(Double.NaN));
        x.init(new VOMock(Double.NaN),new VEMock(Double.NaN),new DomkMock(Double.NaN), new STOMock(Double.NaN), new SEMock(Double.NaN), new GROMKMock(Double.NaN), new KOMock(Double.NaN),new KEMock(Double.NaN));
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
        x.initOver(new XMock(Double.NaN),new VOMock(Double.NaN));
        x.init(new VOMock(Double.NaN), new VEMock(Double.NaN), new DomkMock(Double.NaN), new STOMock(2), new SEMock(Double.NaN), new GROMKMock(2), new KOMock(Double.NaN),new KEMock(Double.NaN));
        double resultat = 4;
        x.beregn();
        assertEquals(x.getVaerdi(), resultat, delta);
        assertTrue(x.getBeregnet());
    }


    //Hvis nedenstående fungere vil resultatet Double.NaN da den ikke kan udregnes
    @Test
    public void testBeregnUdenværdier() {
        XImpl x = new XImpl();
        x.initOver(new XMock(Double.NaN),new VOMock(Double.NaN));
        x.init(new VOMock(Double.NaN), new VEMock(Double.NaN), new DomkMock(Double.NaN), new STOMock(Double.NaN), new SEMock(Double.NaN), new GROMKMock(Double.NaN), new KOMock(Double.NaN),new KEMock(Double.NaN));
        double resultat = Double.NaN;
        x.beregn();
        assertEquals(x.getVaerdi(), resultat, delta);
        assertFalse(x.getBeregnet());
    }

    //Kontrollerer om x kan udregnes med VE og VO
    @Test
    public void testBeregnXmedVEogVO() {
        XImpl x = new XImpl();
        x.initOver(new XMock(Double.NaN),new VOMock(Double.NaN));
        x.init(new VOMock(10), new VEMock(5), new DomkMock(Double.NaN), new STOMock(Double.NaN), new SEMock(Double.NaN), new GROMKMock(Double.NaN), new KOMock(Double.NaN),new KEMock(Double.NaN));
        double resultat = 2;
        x.beregn();
        assertEquals(x.getVaerdi(), resultat, delta);
        assertTrue(x.getBeregnet());
    }

    //Kontrollerer om x blive ændret med negativ x? "SKAL IKKE SKE"
    @Test
    public void testBeregnXmedNegativVEogVO() {
        XImpl x = new XImpl();
        x.initOver(new XMock(Double.NaN),new VOMock(Double.NaN));
        x.init(new VOMock(10), new VEMock(-5), new DomkMock(Double.NaN), new STOMock(Double.NaN), new SEMock(Double.NaN), new GROMKMock(Double.NaN), new KOMock(Double.NaN),new KEMock(Double.NaN));
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
        x.initOver(new XMock(Double.NaN),new VOMock(Double.NaN));
        x.init(new VOMock(-10), new VEMock(5), new DomkMock(Double.NaN), new STOMock(Double.NaN), new SEMock(Double.NaN), new GROMKMock(Double.NaN), new KOMock(Double.NaN),new KEMock(Double.NaN));
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
        x.initOver(new XMock(0),new VOMock(0));
        x.init(new VOMock(5), new VEMock(Double.NaN), new DomkMock(10), new STOMock(Double.NaN), new SEMock(Double.NaN), new GROMKMock(Double.NaN), new KOMock(Double.NaN),new KEMock(Double.NaN));
        double resultat = 50;
        x.beregn();
        assertEquals(x.getVaerdi(), resultat, delta);
        assertTrue(x.getBeregnet());
    }

    @Test
    public void testBeregnXMedDOMKogNegativVO() {
        XImpl x = new XImpl();
        x.initOver(new XMock(0),new VOMock(0));
        x.init(new VOMock(-10), new VEMock(Double.NaN), new DomkMock(5), new STOMock(Double.NaN), new SEMock(Double.NaN), new GROMKMock(Double.NaN), new KOMock(Double.NaN),new KEMock(Double.NaN));
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
        x.initOver(new XMock(0),new VOMock(0));
        x.init(new VOMock(10), new VEMock(Double.NaN), new DomkMock(-5), new STOMock(Double.NaN), new SEMock(Double.NaN), new GROMKMock(Double.NaN), new KOMock(Double.NaN),new KEMock(Double.NaN));
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
        x.initOver(new XMock(Double.NaN),new VOMock(Double.NaN));
        x.init(new VOMock(Double.NaN), new VEMock(10), new DomkMock(5), new STOMock(Double.NaN), new SEMock(Double.NaN), new GROMKMock(Double.NaN), new KOMock(Double.NaN),new KEMock(Double.NaN));
        double resultat = Double.NaN;
        x.beregn();
        assertEquals(x.getVaerdi(), resultat, delta);
        assertFalse(x.getBeregnet());
    }

    //Kontrollerer at x vaerdien blive ændret.
    @Test
    public void testBeregnXMedSTOogSE() {
        XImpl x = new XImpl();
        x.initOver(new XMock(Double.NaN),new VOMock(Double.NaN));
        x.init(new VOMock(Double.NaN), new VEMock(Double.NaN), new DomkMock(Double.NaN), new STOMock(10), new SEMock(10), new GROMKMock(Double.NaN), new KOMock(Double.NaN),new KEMock(Double.NaN));
        double resultat = 1;
        x.beregn();
        assertEquals(x.getVaerdi(), resultat, delta);
        assertTrue(x.getBeregnet());

    }

    @Test
    public void testBeregnXMedSTOogNegativSE() {
        XImpl x = new XImpl();
        x.initOver(new XMock(Double.NaN),new VOMock(Double.NaN));
        x.init(new VOMock(Double.NaN), new VEMock(Double.NaN), new DomkMock(Double.NaN), new STOMock(-10), new SEMock(10), new GROMKMock(Double.NaN), new KOMock(Double.NaN),new KEMock(Double.NaN));
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
        x.initOver(new XMock(Double.NaN),new VOMock(Double.NaN));
        x.init(new VOMock(Double.NaN), new VEMock(Double.NaN), new DomkMock(Double.NaN), new STOMock(-10), new SEMock(10), new GROMKMock(Double.NaN), new KOMock(Double.NaN),new KEMock(Double.NaN));
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
    class GROMKMock implements GROMK{
        double vaerdi = Double.NaN;

        public GROMKMock(double vaerdi){
            this.vaerdi = vaerdi;
        }

        @Override
        public void init(VE ve, X x, KO ko, DOMK domk, STO sto, SE se) {

        }

        @Override
        public void init1(X x1, VO vo1) {

        }

        @Override
        public void init2(X x2, VO vo2, DOMK domk2) {

        }

        @Override
        public void setVaerdi(double vaerdi) {

        }

        @Override
        public double getVaerdi() {
            return vaerdi;
        }

        @Override
        public void beregn() {

        }

        @Override
        public void setBeregnet(boolean val) {

        }

        @Override
        public boolean getBeregnet() {
            return false;
        }
    }

    class SEMock implements SE {


        double vaerdi;

        public SEMock(double vaerdi) {
            this.vaerdi = vaerdi;
        }

        @Override
        public void init(X x, STO sto, VE ve, KE ke) {

        }

        @Override
        public void setVaerdi(double x) {

        }

        public double getVaerdi() {
            return vaerdi;
        }

        @Override
        public void beregn() {

        }

        @Override
        public void setBeregnet(boolean val) {

        }

        @Override
        public boolean getBeregnet() {
            return false;
        }
    }

    class STOMock implements STO  {
        double vaerdi;

        public STOMock(double vaerdi) {
            this.vaerdi = vaerdi;
        }

        @Override
        public void beregn() {

        }

        @Override
        public void setBeregnet(boolean val) {

        }

        @Override
        public boolean getBeregnet() {
            return false;
        }

        @Override
        public void init(X x, VO vo, KO ko, SE se, GROMK gromk, X xOver, VO voOver, X xUnder, VO voUnder) {

        }

        @Override
        public void setVaerdi(double Vaerdi) {
        }

        @Override
        public double getVaerdi() {
            return vaerdi;
        }
    }

    class VOMock implements VO {
        double vaerdi;

        public VOMock(double vaerdi) {
            this.vaerdi = vaerdi;
        }

        @Override
        public void init(VE ve, X x, KO ko, DOMK domk, STO sto, SE se, X xOver, VO voOver, X xUnder, VO voUnder, DOMK domkUnder) {

        }

        @Override
        public void setVaerdi(double vaerdi) {
        }

        @Override
        public double getVaerdi() {
            return vaerdi;
        }

        @Override
        public void beregn() {

        }

        @Override
        public void setBeregnet(boolean val) {

        }

        @Override
        public boolean getBeregnet() {
            return false;
        }
    }
}

class VEMock implements VE {
    double vaerdi;

    public VEMock(double vaerdi) {
        this.vaerdi = vaerdi;
    }

    @Override
    public void init(VO vo, X x, SE se, KE ke) {

    }

    @Override
    public void setVaerdi(double Vaerdi) {
    }

    @Override
    public double getVaerdi() {
        return vaerdi;
    }

    @Override
    public void setBeregnet(boolean val) {

    }

    @Override
    public boolean getBeregnet() {
        return false;
    }

    @Override
    public void beregn() {

    }
}

class DomkMock implements DOMK {
    double vaerdi;

    public DomkMock(double vaerdi) {
        this.vaerdi = vaerdi;
    }

    @Override
    public void setVaerdi(double vaerdi) {

    }

    @Override
    public double getVaerdi() {
        return vaerdi;
    }

    @Override
    public void beregn() {

    }

    @Override
    public void init(VO vo1, VO vo2, STO sto, KO ko, VE ve, X x1, X x2, DOMK domk1, DOMK domk2) {

    }

    @Override
    public boolean erBeregnet() {
        return false;
    }

    @Override
    public void initOver(VO voOver, X xOver, DOMK domkOver) {

    }
}

class XMock implements X {
    double vaerdi;

    public XMock(double vaerdi) {
        this.vaerdi = vaerdi;
    }

    @Override
    public void init(VO vo, VE ve, DOMK domk, STO sto, SE se, GROMK gromk, KO ko, KE ke) {

    }

    @Override
    public void initOver(X xOver, VO voOver) {

    }

    @Override
    public void initUnder(X xUnder, VO voUnder, DOMK domkUnder) {

    }

    @Override
    public void setVaerdi(double x) {

    }

    @Override
    public double getVaerdi() {
        return vaerdi;
    }

    @Override
    public void beregn() {

    }

    @Override
    public void setBeregnet(boolean val) {

    }

    @Override
    public boolean getBeregnet() {
        return false;
    }
}

class KOMock implements KO{

    double vaerdi;

    public KOMock(double vaerdi){
        this.vaerdi = vaerdi;
    }

    @Override
    public void init(KE ke, X x, STO sto, VO vo, X xOver, VO voOver, X xUnder, VO voUnder) {

    }

    @Override
    public void setVaerdi(double Vaerdi) {

    }

    @Override
    public double getVaerdi() {
        return 0;
    }

    @Override
    public void setBeregnet(boolean val) {

    }

    @Override
    public boolean getBeregnet() {
        return false;
    }

    @Override
    public void beregn() {

    }
}

class KEMock implements KE{
    double vaerdi;

    public KEMock(double vaerdi){
        this.vaerdi = vaerdi;
    }
    @Override
    public void init(KO ko, X x, SE se, VE ve) {

    }

    @Override
    public void setVaerdi(double Vaerdi) {

    }

    @Override
    public double getVaerdi() {
        return vaerdi;
    }

    @Override
    public void setBeregnet(boolean val) {

    }

    @Override
    public boolean getBeregnet() {
        return false;
    }

    @Override
    public void beregn() {

    }
}