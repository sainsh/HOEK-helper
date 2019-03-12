package dk.kugelberg.hoek_helper;


import dk.kugelberg.hoek_helper.model.VEImpl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import static org.junit.Assert.*;

public class VEImplTest {

    @Rule
    //public TestRule rule = new InstantTaskExecutorRule();


    @Test
    public void setVaerdi() {
        VEImpl d = new VEImpl();
        d.setVaerdi(45);
        assertEquals(d.getVaerdi(),45,0.1);
    }

    @Test
    public void getVaerdi() {
        VEImpl d = new VEImpl();
        d.setVaerdi(45);
        assertEquals(d.getVaerdi(),45,0.1);
    }
}