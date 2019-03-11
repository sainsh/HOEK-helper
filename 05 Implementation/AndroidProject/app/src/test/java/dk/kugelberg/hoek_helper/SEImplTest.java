package dk.kugelberg.hoek_helper;

import org.junit.Test;

import dk.kugelberg.hoek_helper.model.SEImpl;

import static org.junit.Assert.*;

public class SEImplTest
{
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
    public void getBeregnet()
    {
        seImplObject.getBeregnet();
        assertEquals(seImplObject.getBeregnet(),true);

    }

    @Test
    public void beregn()
    {
        seImplObject.beregn();
        //seImplObject.init(10,10,10,10);
        assertEquals(seImplObject.getBeregnet(),true);

    }


}