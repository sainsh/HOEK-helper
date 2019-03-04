package dk.kugelberg.hoek_helper.model;

public class XImpl implements X {
    private int antal;

    @Override
    public void setAntal(int antal) {
        if (antal < 0) {
            System.out.println("tallet skal være et postivie tal");
        }else{
            this.antal = antal;
        }

    }

    @Override
    public int getAntal() {
        return antal;
    }

    @Override
    public void beregn() {

    }

    @Override
    public void init(VO vo1, VO vo2, STO sto, KO ko, VE ve, X x1, X x2, DOMK domk1, DOMK domk2) {

    }

    @Override
    public boolean erBeregnet() {
        return false;
    }
}
