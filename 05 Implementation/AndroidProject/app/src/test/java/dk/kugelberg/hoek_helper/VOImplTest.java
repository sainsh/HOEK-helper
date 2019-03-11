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

        vo.init(new VEMock(Double.NaN), new XMock(Double.NaN), new KOMock(Double.NaN),
                new DOMKMock(Double.NaN), new STOMock(Double.NaN), new SEMock(Double.NaN),
                new DBMock(Double.NaN), new OMSMock(Double.NaN));
        vo.initOver(new XMock(Double.NaN), new VOMock(Double.NaN));
        vo.initUnder(new XMock(Double.NaN), new VOMock(Double.NaN), new DOMKMock(Double.NaN));

        double forventetResultat = Double.NaN;
        assertEquals(vo.getVaerdi(), forventetResultat, 0);
        assertFalse(vo.getBeregnet());
    }

    @Test
    public void testAfBeregnFunktion(){
        VO vo = new VOImpl();

        vo.init(new VEMock(Double.NaN), new XMock(Double.NaN), new KOMock(Double.NaN),
                new DOMKMock(Double.NaN), new STOMock(Double.NaN), new SEMock(Double.NaN),
                new DBMock(Double.NaN), new OMSMock(Double.NaN));
        vo.initOver(new XMock(Double.NaN), new VOMock(Double.NaN));
        vo.initUnder(new XMock(Double.NaN), new VOMock(Double.NaN), new DOMKMock(Double.NaN));

        double forventetResultat = Double.NaN;
        vo.beregn();
        assertEquals(vo.getVaerdi(), forventetResultat, 0);
        assertFalse(vo.getBeregnet());
    }


    @Test
    public void testAfBeregnVOMedVEOgX(){
        VO vo = new VOImpl();

        vo.init(new VEMock(10.5), new XMock(10.5), new KOMock(Double.NaN),
                new DOMKMock(Double.NaN), new STOMock(Double.NaN), new SEMock(Double.NaN),
                new DBMock(Double.NaN), new OMSMock(Double.NaN));

        double forventetResultat = 110.25;
        vo.beregn();
        assertEquals(vo.getVaerdi(), forventetResultat, 0);
        assertTrue(vo.getBeregnet());
    }

    @Test
    public void testAfBeregnVOMedSTOOgKO(){
        VO vo = new VOImpl();

        vo.init(new VEMock(Double.NaN), new XMock(Double.NaN), new KOMock(50.5),
                new DOMKMock(Double.NaN), new STOMock(100.5), new SEMock(Double.NaN),
                new DBMock(Double.NaN), new OMSMock(Double.NaN));

        double forventetResultat = 50;
        vo.beregn();
        assertEquals(vo.getVaerdi(), forventetResultat, 0);
        assertTrue(vo.getBeregnet());
    }

    @Test
    public void testAfBeregnVOMedDBOgOMS(){
        VO vo = new VOImpl();

        vo.init(new VEMock(Double.NaN), new XMock(Double.NaN), new KOMock(Double.NaN),
                new DOMKMock(Double.NaN), new STOMock(Double.NaN), new SEMock(Double.NaN),
                new DBMock(100.5), new OMSMock(50.5));

        double forventetResultat = 50;
        vo.beregn();
        assertEquals(vo.getVaerdi(), forventetResultat, 0);
        assertTrue(vo.getBeregnet());
    }

    @Test
    public void testAfBeregnVOMedDOMKFormel(){
        VO vo = new VOImpl();

        vo.init(new VEMock(Double.NaN), new XMock(100), new KOMock(Double.NaN),
                new DOMKMock(2), new STOMock(Double.NaN), new SEMock(Double.NaN),
                new DBMock(Double.NaN), new OMSMock(Double.NaN));
        vo.initOver(new XMock(50), new VOMock(25));

        double forventetResultat = 50;
        vo.beregn();
        assertEquals(vo.getVaerdi(), forventetResultat, 0);
        assertTrue(vo.getBeregnet());
    }



    class VEMock implements VE{
        double vaerdi = Double.NaN;

        public VEMock(double vaerdi){
            this.vaerdi = vaerdi;
        }

        @Override
        public void init(VO vo, X x, SE se, KE ke) {

        }

        @Override
        public void setVaerdi(double x) {

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
        double vaerdi = Double.NaN;

        public XMock(double vaerdi){
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
        double vaerdi = Double.NaN;

        public KOMock(double vaerdi){
            this.vaerdi = vaerdi;
        }

        @Override
        public void init(KE ke, X x, STO sto, VO vo) {

        }

        @Override
        public void initOver(X xOver, VO voOver) {

        }

        @Override
        public void initUnder(X xUnder, VO voUnder) {

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

    class DOMKMock implements DOMK{

        double vaerdi = Double.NaN;

        public DOMKMock(double vaerdi){
            this.vaerdi = vaerdi;
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

        @Override
        public void init(VO vo, STO sto, KO ko, VE ve, X x) {

        }

        @Override
        public void initOver(VO voOver, X xOver, DOMK domkOver) {

        }

        @Override
        public boolean erBeregnet() {
            return false;
        }
    }

    class STOMock implements STO{

        double vaerdi = Double.NaN;

        public STOMock(double vaerdi){
            this.vaerdi = vaerdi;
        }

        @Override
        public void init(X x, VO vo, KO ko, SE se, GROMK gromk) {

        }

        @Override
        public void initOver(X xOver, VO voOver) {

        }

        @Override
        public void initUnder(X xUnder, VO voUnder) {

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

    class SEMock implements SE{

        double vaerdi = Double.NaN;

        public SEMock(double vaerdi){
            this.vaerdi = vaerdi;
        }

        @Override
        public void init(X x, STO sto, VE ve, KE ke) {

        }

        @Override
        public void setVaerdi(double x) {

        }

        @Override
        public double getVaerdi() {
            return 0;
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

    class VOMock implements VO{

        double vaerdi = Double.NaN;

        public VOMock(double vaerdi){
            this.vaerdi = vaerdi;
        }

        @Override
        public void init(VE ve, X x, KO ko, DOMK domk, STO sto, SE se, DB db, OMS oms) {

        }

        @Override
        public void initOver(X xOver, VO voOver) {

        }

        @Override
        public void initUnder(X xUnder, VO voUnder, DOMK domkUnder) {

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

    class DBMock implements DB {

        double vaerdi = Double.NaN;

        public DBMock(double vaerdi){

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

    class OMSMock implements OMS {

        double vaerdi = Double.NaN;

        public OMSMock(double vaerdi){

            this.vaerdi = vaerdi;
        }

        @Override
        public void setVaerdi(double vaerdi) {

        }

        @Override
        public double getVaerdi() {
            return vaerdi;
        }
    }
}