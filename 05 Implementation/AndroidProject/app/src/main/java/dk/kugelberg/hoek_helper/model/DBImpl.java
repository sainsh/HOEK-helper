package dk.kugelberg.hoek_helper.model;

public class DBImpl implements DB {


    double vaerdi;

    public DBImpl() {
        vaerdi = Double.NaN;
    }


    public void setVaerdi(double vaerdi) {
        this.vaerdi = vaerdi;

    }

    public double getVaerdi() {
        return vaerdi;
    }


}
