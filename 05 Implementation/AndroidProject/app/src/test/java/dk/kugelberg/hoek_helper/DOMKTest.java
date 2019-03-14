package dk.kugelberg.hoek_helper;

import org.junit.Test;

import dk.kugelberg.hoek_helper.model.DOMK;
import dk.kugelberg.hoek_helper.model.DOMKImpl;
import dk.kugelberg.hoek_helper.model.KOImpl;
import dk.kugelberg.hoek_helper.model.SE;
import dk.kugelberg.hoek_helper.model.STO;
import dk.kugelberg.hoek_helper.model.STOImpl;
import dk.kugelberg.hoek_helper.model.VE;
import dk.kugelberg.hoek_helper.model.VEImpl;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.VOImpl;
import dk.kugelberg.hoek_helper.model.X;
import dk.kugelberg.hoek_helper.model.XImpl;

import static org.junit.Assert.*;

public class DOMKTest {

    private final double DELTA = 0.00000000001;


    @Test
    public void setVaerdi() {
        DOMK domk = new DOMKImpl();
        domk.setVaerdi(50.5);
        assertEquals(domk.getVaerdi(),50.5,DELTA);
    }

    @Test
    public void getVaerdi() {
        DOMK domk = new DOMKImpl();
        assertEquals(domk.getVaerdi(),Double.NaN, DELTA);
    }

    @Test
    public void testBeregn() {
        DOMK domkberegn = new DOMKImpl();
        domkberegn.init(new MockVO(25.5), new MockVO(50000.68), new STOImpl(), new KOImpl(), new VEImpl(), new MockX(500.9), new MockX(100852.56), new DOMKImpl(), new DOMKImpl());
        double resultat = 0.49800053;
        domkberegn.beregn();
        assertEquals(domkberegn.getVaerdi(),resultat, DELTA );
    }

    @Test
    public void testBeregnUdenVaerdier() {
        DOMK domkberegn = new DOMKImpl();
        domkberegn.init(new MockVO(Double.NaN), new MockVO(Double.NaN), new STOImpl(), new KOImpl(), new VEImpl(), new MockX(Double.NaN), new MockX(Double.NaN), new DOMKImpl(), new DOMKImpl());
        double resultat = Double.NaN;
        domkberegn.beregn();
        assertEquals(domkberegn.getVaerdi(),resultat, DELTA );
    }



    @Test
    public void testBeregnMedNegativ() {
        DOMK domkberegn = new DOMKImpl();
        domkberegn.init(new MockVO(-25.5), new MockVO(-50000.68), new STOImpl(), new KOImpl(), new VEImpl(), new MockX(500.9), new MockX(100852.56), new DOMKImpl(), new DOMKImpl());
        double resultat = -2.005982867370644730419152531734383876602;
        domkberegn.beregn();
        assertEquals(domkberegn.getVaerdi(),resultat, DELTA );
    }

    class MockVO implements VO{

        private double vaerdi = Double.NaN;

        public MockVO (double vaerdi){
            this.vaerdi = vaerdi;
        }

        @Override
        public void setVaerdi(double vaerdi) {
            this.vaerdi = vaerdi;
        }

        @Override
        public double getVaerdi() {
            return vaerdi;
        }
    }

    class MockX implements X {

        private double vaerdi;

        public MockX (double vaerdi){
            this.vaerdi = vaerdi;
        }

        @Override
        public void init(VO vo, VE ve, DOMK domk, STO sto, SE se) {

        }

        @Override
        public void setVaerdi(double x) {
            this.vaerdi = vaerdi;
        }

        @Override
        public double getVaerdi() {
            return vaerdi;
        }

        @Override
        public void beregn() {

        }
    }

    @Test
    public void init() {
        DOMK domk = new DOMKImpl();
    }

    @Test
    public void erBeregnet() {
        DOMK domk = new DOMKImpl();
    }
}