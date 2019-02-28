package com.example.hoek_helper.Model;

public class XImpl implements X {
    private int antal;

    @Override
    public void setAntal(int antal) {
        if (antal < 0) {
            System.out.println("tallet skal være et postivie tal");
        }
        this.antal = antal;
    }

    @Override
    public int getAntal() {
        return antal;
    }
}
