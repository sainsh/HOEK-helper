package dk.kugelberg.hoek_helper;

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
import dk.kugelberg.hoek_helper.model.X;

class MOCKS {
     static class DBMock implements DB{
        double vaerdi;

        public DBMock(double vaerdi){
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

    static class OMSMock implements OMS{
        double vaerdi;

        public OMSMock(double vaerdi) {
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

    static class XMock implements X {
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

     static class VOMock implements VO {
        double vaerdi;
        public VOMock(double vaerdi){
            this.vaerdi = vaerdi;
        }

        @Override
        public void init(VE ve, X x, KO ko, DOMK domk, STO sto, SE se) {

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

    static class VEMock implements VE {
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

    static class STOMock implements STO {
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
        public void init(X x, VO vo, KO ko, SE se, GROMK gromk) {

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
    }

    static class SEMock implements SE {


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

    static class KOMock implements KO {

        double vaerdi;

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

    static class KEMock implements KE {

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

    static class GromkMock implements GROMK {
        double vaerdi = Double.NaN;

        public GromkMock(double vaerdi){
            this.vaerdi = vaerdi;
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
    }

    static class DomkMock implements DOMK {
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
}
