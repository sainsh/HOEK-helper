package com.example.hoek_helper.model;

import org.junit.Test;

import static org.junit.Assert.*;
import com.example.hoek_helper.model.VOImpl;

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