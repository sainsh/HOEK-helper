package dk.kugelberg.hoek_helper;

import org.junit.Test;

import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.VOImpl;

import static org.junit.Assert.assertEquals;

public class VOImplTest {

    VO vo = new VOImpl();

    @Test
    public void setVaerdi() {

        vo.setVaerdi(45);
        assertEquals(vo.getVaerdi(),45,0);
    }

    @Test
    public void getVaerdi() {

        vo.setVaerdi(45);
        assertEquals(vo.getVaerdi(),45,0);
    }
}