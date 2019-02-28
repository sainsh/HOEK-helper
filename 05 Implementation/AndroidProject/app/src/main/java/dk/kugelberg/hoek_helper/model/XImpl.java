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
}
