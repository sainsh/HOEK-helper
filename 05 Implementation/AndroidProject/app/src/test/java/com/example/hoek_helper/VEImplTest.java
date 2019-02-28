package com.example.hoek_helper;

import com.example.hoek_helper.Model.VEImpl;

import org.junit.Test;

import static org.junit.Assert.*;

public class VEImplTest {

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