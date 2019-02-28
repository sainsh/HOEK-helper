package dk.kugelberg.hoek_helper;

import dk.kugelberg.hoek_helper.model.X;
import dk.kugelberg.hoek_helper.model.XImpl;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestingXlmpl {
    X t =new XImpl();
    @Test
    public void setAntal(){
        t.setAntal(5);
        assertEquals(t.getAntal(),5,0.1);
    }
    @Test
    public void getAntal(){
        t.setAntal(10);
        assertEquals(10,t.getAntal());
    }
}
