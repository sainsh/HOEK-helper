package dk.kugelberg.hoek_helper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import dk.kugelberg.hoek_helper.model.Raekke;
import dk.kugelberg.hoek_helper.model.RaekkeImpl;
import dk.kugelberg.hoek_helper.model.Tabel;
import dk.kugelberg.hoek_helper.model.TabelImpl;

import static org.junit.Assert.*;

public class TabelImplTest {

    final double delta = 0.00000000000000000001;

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();


    @Test
    public void createCSVTest(){

        Tabel tabel = new TabelImpl();
        Raekke raekke;

        for(int i = 0; i<10; i++) {
            tabel.getTabel().add(new RaekkeImpl());


        }

        tabel.createCSV();




    }


}
