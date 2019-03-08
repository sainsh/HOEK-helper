package dk.kugelberg.hoek_helper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.VOImpl;

import static org.junit.Assert.assertEquals;

public class VOImplTest {

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();


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