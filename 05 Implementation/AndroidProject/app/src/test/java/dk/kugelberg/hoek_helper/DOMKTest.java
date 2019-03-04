package dk.kugelberg.hoek_helper;

import org.junit.Test;

import dk.kugelberg.hoek_helper.model.DOMK;
import dk.kugelberg.hoek_helper.model.DOMKImpl;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.VOImpl;
import dk.kugelberg.hoek_helper.model.X;
import dk.kugelberg.hoek_helper.model.XImpl;

import static org.junit.Assert.*;

public class DOMKTest {

    private final double DELTA = 0.00000000001;


    @Test
    public void setVaerdi() {
        DOMK domk = new DOMKImpl();
        domk.setVaerdi(50.5);
        assertEquals(domk.getVaerdi(),50.5,DELTA);
    }

    @Test
    public void getVaerdi() {
        DOMK domk = new DOMKImpl();
        assertEquals(domk.getVaerdi(),Double.NaN, DELTA);
    }

    @Test
    public void beregn() {
        DOMK domkberegn = new DOMKImpl();

        VO vo1 = new VOImpl();
        VO vo2 = new VOImpl();
        VO vo3 = new VOImpl();

        X x1 = new XImpl();
        X x2 = new XImpl();
        X x3 = new XImpl();

        vo1.setVaerdi(50.5);
        vo2.setVaerdi(75.5);
        vo3.setVaerdi(185720.68);

        x1.setAntal(10);
        x2.setAntal(25);
        x3.setAntal(50000);

        // Expectation: domk1 = (x1-0)/(y1-0)   = 0.1980198019801
        // Expectation: domk2 = (x2-x1)/(y2-y1) = 0.6
        // Expectation: domk2 = (x3-x2)/(y3-y2) = 0.2691963238690064562947446305904629465736
        assertEquals(x1.getAntal()/vo1.getVaerdi(), 0.1980198019801, DELTA);
        assertEquals((x2.getAntal()-x1.getAntal())/(vo2.getVaerdi()-vo1.getVaerdi()), 0.6,DELTA);
        assertEquals((x3.getAntal()-x2.getAntal())/(vo3.getVaerdi()-vo2.getVaerdi()), 0.2691963238690064562947446305904629465736,DELTA);


    }

    @Test
    public void init() {
        DOMK domk = new DOMKImpl();
    }

    @Test
    public void erBeregnet() {
        DOMK domk = new DOMKImpl();
    }
}