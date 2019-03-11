package dk.kugelberg.hoek_helper.model;

public interface SE extends Noegletal {

    void init(X x, STO sto, VE ve, KE ke);

    void setVaerdi(double x);
    double getVaerdi();

    void beregn();

    void setBeregnet(boolean val);
    boolean getBeregnet();
}
