package dk.kugelberg.hoek_helper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import dk.kugelberg.hoek_helper.model.DB;
import dk.kugelberg.hoek_helper.model.DOMK;
import dk.kugelberg.hoek_helper.model.DOMKImpl;
import dk.kugelberg.hoek_helper.model.GROMK;
import dk.kugelberg.hoek_helper.model.KE;
import dk.kugelberg.hoek_helper.model.KO;
import dk.kugelberg.hoek_helper.model.OMS;
import dk.kugelberg.hoek_helper.model.Raekke;
import dk.kugelberg.hoek_helper.model.RaekkeImpl;
import dk.kugelberg.hoek_helper.model.SE;
import dk.kugelberg.hoek_helper.model.STO;
import dk.kugelberg.hoek_helper.model.Tabel;
import dk.kugelberg.hoek_helper.model.TabelImpl;
import dk.kugelberg.hoek_helper.model.VE;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.X;

import static org.junit.Assert.*;

public class TabelImplTest {

    final double delta = 0.00000000000000000001;

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();


    @Test
    public void createCSVTest(){

        Tabel tabel = new TabelImpl();
        Raekke raekke;

        StringBuilder testData = new StringBuilder();

        testData.append("X;VO;VE;KE;STO;SE;KO;GROMK;DOMK\n");


        for(int i = 0; i<10; i++) {
            //tabel.getTabelmld().add(new RaekkeMock(1,1,1,1,1,1,1,1,1));
            //tabel.get().add(new RaekkeMock(1,1,1,1,1,1,1,1,1));
            testData.append("1.0;1.0;1.0;1.0;1.0;1.0;1.0;1.0;1.0\n");
        }

        tabel.createCSV();

        try{
            StringBuilder actualData = new StringBuilder();
            Scanner scan = new Scanner(new File("test.csv"));
            while(scan.hasNext()){
                actualData.append(scan.nextLine());
                actualData.append("\n");

            }
            System.out.println("testData: \n" + testData.toString());
            System.out.println("actualData: \n" + actualData.toString());

            assertTrue(testData.toString().equals(actualData.toString()));

        }catch (IOException e){
            e.printStackTrace();
        }






    }
    }

/*
    public class XMock implements X {

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

    public class RaekkeMock implements Raekke {

        private DOMK domk = null;
        private KO ko = null;
        private SE se = null;
        private STO sto = null;
        private VE ve = null;
        private VO vo = null;
        private X x = null;
        private KE ke = null;
        private GROMK gromk = null;

        public RaekkeMock(double domk, double ko, double se, double sto, double ve, double vo, double x, double gromk, double ke){

            this.domk = new DomkMock(domk);
            this.ko = new KOMock(ko);
            this.se = new SeMock(se);
            this.sto = new StoMock(sto);
            this.ve = new VeMock(ve);
            this.vo = new VoMock(vo);
            this.x = new XMock(x);
            this.ke = new KeMock(ke);
            this.gromk = new GromkMock(gromk);


        }


        @Override
        public DOMK getDOMK() {
            return domk;
        }

        @Override
        public KO getKO() {
            return ko;
        }

        @Override
        public SE getSE() {
            return se;
        }

        @Override
        public STO getSTO() {
            return sto;
        }

        @Override
        public VE getVE() {
            return ve;
        }

        @Override
        public VO getVO() {
            return vo;
        }

        @Override
        public X getX() {
            return x;
        }

        @Override
        public int getRaekkenummer() {
            return 0;
        }

        @Override
        public GROMK getGROMK() {
            return gromk;
        }

        @Override
        public KE getKE() {
            return ke;
        }

        @Override
        public void setDOMK(DOMK domk) {

        }

        @Override
        public void setKO(KO ko) {

        }

        @Override
        public void setSE(SE se) {

        }

        @Override
        public void setSTO(STO sto) {

        }

        @Override
        public void setVE(VE ve) {

        }

        @Override
        public void setVO(VO vo) {

        }

        @Override
        public void setX(X x) {

        }

        @Override
        public void setKE(KE ke) {

        }

        @Override
        public void setGROMK(GROMK gromk) {

        }

        @Override
        public void setRaekkenummer(int raekkenummer) {

        }
    }

    private class GromkMock implements GROMK {
        double vaerdi;
        public GromkMock(double gromk) {
            vaerdi = gromk;
        }

        @Override
        public void init(VE ve, X x, KO ko, DOMK domk, STO sto, SE se) {

        }

        @Override
        public void initOver(X x1, VO vo1) {

        }

        @Override
        public void initUnder(X x2, VO vo2, DOMK domk2) {

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
    }*/
