package dk.kugelberg.hoek_helper;

import dk.kugelberg.hoek_helper.model.X;
import dk.kugelberg.hoek_helper.model.XImpl;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestingXlmpl {
    X t =new XImpl();
    @Test
    public void setAntal(){
        t.setX(5);
        assertEquals(t.getX(),5,0.1);
    }
    @Test
    public void getAntal(){
        t.setX(10);
        assertEquals(10,t.getX());
    }
}
