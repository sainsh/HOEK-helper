package dk.kugelberg.hoek_helper.untitests;

import org.junit.Test;

import dk.kugelberg.hoek_helper.MOCKS;
import dk.kugelberg.hoek_helper.model.RaekkeImpl;

import static org.junit.Assert.*;

public class RaekkeImplTest {

    private RaekkeImpl raekke = new RaekkeImpl();

    @Test
    public void testSetOgGetDOMK() {
        raekke.setDOMK(new MOCKS.DomkMock(20));
        assertEquals(raekke.getDOMK().getVaerdi(), 20, 0.0000001);
        assertNotEquals(raekke.getDOMK().getVaerdi(), 15, 0.0000001);
    }

    @Test
    public void testSetOgGetGROMK() {
        raekke.setGROMK(new MOCKS.GromkMock(20));
        assertEquals(raekke.getGROMK().getVaerdi(), 20, 0.0000001);
        assertNotEquals(raekke.getGROMK().getVaerdi(), 15, 0.0000001);
    }

    @Test
    public void testSetOgGetKE() {
        raekke.setKE(new MOCKS.KEMock(20));
        assertEquals(raekke.getKE().getVaerdi(), 20, 0.0000001);
        assertNotEquals(raekke.getKE().getVaerdi(), 15, 0.0000001);
    }

    @Test
    public void testSetOgGetKO() {
        raekke.setKO(new MOCKS.KOMock(20));
        assertEquals(raekke.getKO().getVaerdi(), 20, 0.0000001);
        assertNotEquals(raekke.getKO().getVaerdi(), 15, 0.0000001);
    }

    @Test
    public void testSetOgGetSE() {
        raekke.setSE(new MOCKS.SEMock(20));
        assertEquals(raekke.getSE().getVaerdi(), 20, 0.0000001);
        assertNotEquals(raekke.getSE().getVaerdi(), 15, 0.0000001);
    }

    @Test
    public void testSetOgGetSTO() {
        raekke.setSTO(new MOCKS.STOMock(20));
        assertEquals(raekke.getSTO().getVaerdi(), 20, 0.0000001);
        assertNotEquals(raekke.getSTO().getVaerdi(), 15, 0.0000001);
    }

    @Test
    public void testSetOgGetVE() {
        raekke.setVE(new MOCKS.VEMock(20));
        assertEquals(raekke.getVE().getVaerdi(), 20, 0.0000001);
        assertNotEquals(raekke.getVE().getVaerdi(), 15, 0.0000001);
    }

    @Test
    public void testSetOgGetVO() {
        raekke.setVO(new MOCKS.VOMock(20));
        assertEquals(raekke.getVO().getVaerdi(), 20, 0.0000001);
        assertNotEquals(raekke.getVO().getVaerdi(), 15, 0.0000001);
    }

    @Test
    public void testSetOgGetX() {
        raekke.setX(new MOCKS.XMock(20));
        assertEquals(raekke.getX().getVaerdi(), 20, 0.0000001);
        assertNotEquals(raekke.getX().getVaerdi(), 15, 0.0000001);
    }

    @Test
    public void testSetOgGetOMS() {
        raekke.setOMS(new MOCKS.OMSMock(20));
        assertEquals(raekke.getOMS().getVaerdi(), 20, 0.0000001);
        assertNotEquals(raekke.getOMS().getVaerdi(), 15, 0.0000001);
    }

    @Test
    public void testSetOgGetDB() {
        raekke.setDB(new MOCKS.DBMock(20));
        assertEquals(raekke.getDB().getVaerdi(), 20, 0.0000001);
        assertNotEquals(raekke.getDB().getVaerdi(), 15, 0.0000001);

    }

    @Test
    public void testSetOgGetRaekkenummer() {
        raekke.setRaekkenummer(20);
        assertEquals(raekke.getRaekkenummer(), 20, 0.0000001);
        assertNotEquals(raekke.getRaekkenummer(), 15, 0.0000001);
    }
}