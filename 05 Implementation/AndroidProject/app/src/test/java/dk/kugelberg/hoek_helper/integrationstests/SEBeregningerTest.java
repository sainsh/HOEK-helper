package dk.kugelberg.hoek_helper.integrationstests;

import org.junit.Test;

import dk.kugelberg.hoek_helper.MOCKS;
import dk.kugelberg.hoek_helper.model.KE;
import dk.kugelberg.hoek_helper.model.KEimpl;
import dk.kugelberg.hoek_helper.model.SE;
import dk.kugelberg.hoek_helper.model.SEImpl;
import dk.kugelberg.hoek_helper.model.STO;
import dk.kugelberg.hoek_helper.model.STOImpl;
import dk.kugelberg.hoek_helper.model.VE;
import dk.kugelberg.hoek_helper.model.VEImpl;
import dk.kugelberg.hoek_helper.model.X;
import dk.kugelberg.hoek_helper.model.XImpl;

import static org.junit.Assert.*;

public class SEBeregningerTest
{
    final double delta = 0.000000001;
    //void init(X x, STO sto, VE ve, KE ke);
    //void init(X x, VO vo, KO ko, SE se, GROMK gromk);
    // void init(VO vo, VE ve, DOMK domk, STO sto, SE se, GROMK gromk, KO ko, KE ke);
    @Test
    public void stoOgx()
    {
        SE se = new SEImpl();
        STO s = new STOImpl();
        X x = new XImpl();
        se.init(x, s, new MOCKS.VEMock(Double.NaN), new MOCKS.KEMock(Double.NaN));
        s.init(x, new MOCKS.VOMock(Double.NaN), new MOCKS.KOMock(Double.NaN), se, new MOCKS.GromkMock(Double.NaN));
        x.init(new MOCKS.VOMock(Double.NaN), new MOCKS.VEMock(Double.NaN), new MOCKS.DomkMock(Double.NaN), s, se, new MOCKS.GromkMock(Double.NaN), new MOCKS.KOMock(Double.NaN), new MOCKS.KEMock(Double.NaN));

        se.setVaerdi(10);
        s.setVaerdi(10);
        x.setVaerdi(10);

        se.beregn();
        double forVentetResultat = 1;
        assertEquals(se.getVaerdi(), forVentetResultat, 0);
        assertTrue(se.getBeregnet());


    }
    public void VePlusKe()
    {
        //SE = VE + KE
        SE se = new SEImpl();
        VE ve= new VEImpl();
        KE ke=new KEimpl();
        se.init(new MOCKS.XMock(Double.NaN),new MOCKS.STOMock(Double.NaN),ve,ke);
        ve.setVaerdi(10);
        ke.setVaerdi(5);
        se.beregn();
        double forventetResultat=5;
        assertEquals(se.getVaerdi(),forventetResultat,delta);
        assertTrue(se.getBeregnet());




    }






}