package dk.kugelberg.hoek_helper;

import org.junit.Test;

import dk.kugelberg.hoek_helper.model.DOMK;
import dk.kugelberg.hoek_helper.model.GROMK;
import dk.kugelberg.hoek_helper.model.KE;
import dk.kugelberg.hoek_helper.model.KEimpl;
import dk.kugelberg.hoek_helper.model.KO;
import dk.kugelberg.hoek_helper.model.SE;
import dk.kugelberg.hoek_helper.model.STO;
import dk.kugelberg.hoek_helper.model.VE;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.X;

import static org.junit.Assert.*;

public class KEImplTest {


    final double delta = 0.00000000000000000001;


    @Test
    public void setVaerdi() {
        KE ke = new KEimpl();
        ke.setVaerdi(45.2);
        assertEquals(ke.getVaerdi(),45.2,delta);
        assertFalse(ke.getBeregnet());

    }

    @Test
    public void getVaerdi() {

        KE ke = new KEimpl();
        ke.setVaerdi(45.4);
        assertEquals(ke.getVaerdi(),45.4,delta);
        assertFalse(ke.getBeregnet());

    }

    @Test
    public void setBeregnet() {

        KE ke = new KEimpl();
        ke.setBeregnet(true);
        assertTrue(ke.getBeregnet());
        ke.setBeregnet(false);
        assertFalse(ke.getBeregnet());

    }

    @Test
    public void getBeregnet() {
        KE ke = new KEimpl();
        ke.setBeregnet(true);
        assertTrue(ke.getBeregnet());
        ke.setBeregnet(false);
        assertFalse(ke.getBeregnet());

    }

    @Test
    public void beregnMedKOOgX() {

        KE ke = new KEimpl();
        KO ko = new KOMock(45.5);
        X x = new XMock(45);

        ke.init(ko,x,new SEMock(Double.NaN),new VEMock(Double.NaN));
        ke.beregn();


        assertEquals(ke.getVaerdi(), ko.getVaerdi() / x.getVaerdi(),delta);
        assertTrue(ke.getBeregnet());


    }
    @Test
    public void beregnMedSEOgVE() {

        KE ke = new KEimpl();
        SE se = new SEMock(45.5);
        VE ve = new VEMock(45);

        ke.init(new KOMock(Double.NaN),new XMock(Double.NaN),se,ve);
        ke.beregn();


        assertEquals(ke.getVaerdi(), se.getVaerdi() - ve.getVaerdi(),delta);
        assertTrue(ke.getBeregnet());

    }
    @Test
    public void beregnHvorErBeregnetErTrue() {

    }
    @Test
    public void beregnUdenVaerdier() {

    }
    @Test
    public void beregn() {

    }

    class KOMock implements KO {

        private double vaerdi = Double.NaN;

        public KOMock(double vaerdi){
            this.vaerdi= vaerdi;
        }



        @Override
        public void init(KE ke, X x, STO sto, VO vo) {

        }

        @Override
        public void init1(X x1, VO vo1) {

        }

        @Override
        public void init2(X x2, VO vo2) {

        }

        @Override
        public void setVaerdi(double Vaerdi) {
            this.vaerdi = vaerdi;
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

    class XMock implements X {

        private double vaerdi = Double.NaN;

        public XMock(double vaerdi){
            this.vaerdi= vaerdi;
        }


        @Override
        public void init(VO vo, VE ve, DOMK domk, STO sto, SE se, GROMK gromk) {

        }

        @Override
        public void init1(X x1, VO vo1) {

        }

        @Override
        public void init2(X x2, VO vo2, DOMK domk2) {

        }

        @Override
        public void setVaerdi(double x) {
            this.vaerdi = x;
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

        private double vaerdi = Double.NaN;

        public SEMock(double vaerdi){
            this.vaerdi= vaerdi;
        }


        @Override
        public void init(X x, STO sto, VE ve, KE ke) {

        }

        @Override
        public void setVaerdi(double x) {
            this.vaerdi = x;
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

    class VEMock implements VE {

        private double vaerdi = Double.NaN;

        public VEMock(double vaerdi){
            this.vaerdi= vaerdi;
        }


        @Override
        public void init(VO vo, X x, SE se, KE ke) {

        }

        @Override
        public void setVaerdi(double x) {
            this.vaerdi = x;
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


}

