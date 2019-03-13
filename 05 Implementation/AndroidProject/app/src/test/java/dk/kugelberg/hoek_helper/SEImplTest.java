package dk.kugelberg.hoek_helper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import dk.kugelberg.hoek_helper.model.NegativVaerdiException;
import dk.kugelberg.hoek_helper.model.SE;
import dk.kugelberg.hoek_helper.model.SEImpl;

import static org.junit.Assert.*;

public class SEImplTest
{
    //@Rule
    //public TestRule rule = new InstantTaskExecutorRule();


    final double delta = 0.00000000000000000001;
    SEImpl seImplObject=new SEImpl();
    @Test
    public void setVaerdi()
    {
        seImplObject.setVaerdi(45);
        assertEquals(seImplObject.getVaerdi(),45,0.1);
    }

    @Test
    public void getVaerdi()
    {
        seImplObject.setVaerdi(45);
        assertEquals(seImplObject.getVaerdi(),45,0);

    }

    @Test
    public void setBeregnet()
    {
        seImplObject.setBeregnet(true);
        assertEquals(seImplObject.getBeregnet(),true);

    }


    @Test
    public void testSEStandardVaerdi()
    {
        SEImpl se=new SEImpl();
        se.init(new MOCKS.XMock(Double.NaN),new MOCKS.STOMock(Double.NaN),new MOCKS.VEMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        assertEquals(se.getVaerdi(),Double.NaN,delta);
        assertFalse(se.getBeregnet());

    }


    @Test
    public void testBeregnMedStoOgX ()
    {
        SEImpl se=new SEImpl();
        se.init(new MOCKS.XMock(5), new MOCKS.STOMock(5), new MOCKS.VEMock(Double.NaN), new MOCKS.KEMock(Double.NaN));
        double resultat=1;
        se.beregn();
        assertEquals(se.getVaerdi(), resultat, delta);
        assertTrue(se.getBeregnet());

    }


    @Test
    public void testBeregnMedVeogK()
    {
        SEImpl se=new SEImpl();
        se.init(new MOCKS.XMock(Double.NaN), new MOCKS.STOMock(Double.NaN), new MOCKS.VEMock(5), new MOCKS.KEMock(5));

        double resultat=10;
        se.beregn();
        assertEquals(se.getVaerdi(),resultat,delta);
        assertTrue(se.getBeregnet());

    }

    @Test
    public void testBerengSEmedManglendeX()
    {
        SEImpl se=new SEImpl();
        se.init(new MOCKS.XMock(Double.NaN),new MOCKS.STOMock(5),new MOCKS.VEMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        double resultat=Double.NaN;
        se.beregn();
        assertEquals(se.getVaerdi(),resultat,delta);
        assertFalse(se.getBeregnet());

    }

    @Test
    public void testBeregnSEmedNegativTal()
    {
        SEImpl se=new SEImpl();
        se.init(new MOCKS.XMock(-5),new MOCKS.STOMock(5),new MOCKS.VEMock(Double.NaN),new MOCKS.KEMock(Double.NaN));
        double resultat=-1;
        se.beregn();
        assertEquals(se.getVaerdi(),resultat,delta);
        assertTrue(se.getBeregnet());

    }



}